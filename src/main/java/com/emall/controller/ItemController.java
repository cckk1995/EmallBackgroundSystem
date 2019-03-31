package com.emall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.emall.controller.viewobject.ItemVO;
import com.emall.dataobject.*;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.ItemService;
import com.emall.utils.DateTimeUtil;
import com.emall.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/getAllItems",method = RequestMethod.GET)
    public CommonReturnType getAllItems(){
        List<ItemDO> list = null;
        try{
            list = itemService.getItems();
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create(list);
    }

    @Value("${snake.item.dataCenterId}")
    private int dataCenterId;

    /**
     * 添加商品信息
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/additem",method = RequestMethod.POST)
    public CommonReturnType addItem(@RequestBody JSONObject jsonObject){
        JSONObject itemJson = jsonObject.getJSONObject("item");
        ItemDO itemDO = JSON.toJavaObject(itemJson,ItemDO.class);
        SnowFlake snowFlake = new SnowFlake(dataCenterId,3);
        String itemId = String.valueOf(snowFlake.nextId());
        itemDO.setItemId(itemId);
        itemDO.setCreateTime(new Date());
        itemDO.setUpdateTime(new Date());
        JSONArray attrKeyJson = jsonObject.getJSONArray("attrkey");
        List<ItemAttrKeyDO> itemAttrKeyDOS = new ArrayList<>();
        for(int i = 0; i < attrKeyJson.size(); i++){
            JSONObject t = attrKeyJson.getJSONObject(i);
            ItemAttrKeyDO itemAttrKeyDO = JSON.toJavaObject(t,ItemAttrKeyDO.class);
            itemAttrKeyDO.setItemId(itemId);
            itemAttrKeyDOS.add(itemAttrKeyDO);
        }
        JSONArray attrValJson = jsonObject.getJSONArray("attrVal");
        List<ItemAttrValDO> itemAttrValDOS = new ArrayList<>();
        for(int i = 0; i < attrValJson.size(); i++){
            JSONObject t = attrValJson.getJSONObject(i);
            ItemAttrValDO itemAttrValDO = JSON.toJavaObject(t,ItemAttrValDO.class);
            itemAttrValDO.setItemId(itemId);
            itemAttrValDOS.add(itemAttrValDO);
        }
        JSONArray stockJson= jsonObject.getJSONArray("stock");
        List<ItemStockDO> itemStockDOS = new ArrayList<>();
        for(int i = 0; i < stockJson.size(); i++){
            JSONObject t = stockJson.getJSONObject(i);
            ItemStockDO stockDO = JSON.toJavaObject(t,ItemStockDO.class);
            stockDO.setItemId(itemId);
            itemStockDOS.add(stockDO);
        }
        try{
            itemService.uploadItem(itemDO,itemAttrKeyDOS,itemAttrValDOS,itemStockDOS);
        }catch (BusinessException e) {
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(), "false");
        }
        return CommonReturnType.create("true");
    }

    /**
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/modifyitem",method = RequestMethod.POST)
    public CommonReturnType modifyItem(@RequestBody JSONObject jsonObject){
        JSONObject itemJson = jsonObject.getJSONObject("item");
        ItemDO itemDO = JSON.toJavaObject(itemJson,ItemDO.class);
        Date date = new Date();
        itemDO.setUpdateTime(date);
        JSONArray attrKeyJson = jsonObject.getJSONArray("attrkey");
        List<ItemAttrKeyDO> itemAttrKeyDOS = new ArrayList<>();
        for(int i = 0; i < attrKeyJson.size(); i++){
            JSONObject t = attrKeyJson.getJSONObject(i);
            itemAttrKeyDOS.add(JSON.toJavaObject(t,ItemAttrKeyDO.class));
        }
        JSONArray attrValJson = jsonObject.getJSONArray("attrVal");
        List<ItemAttrValDO> itemAttrValDOS = new ArrayList<>();
        for(int i = 0; i < attrValJson.size(); i++){
            JSONObject t = attrValJson.getJSONObject(i);
            itemAttrValDOS.add(JSON.toJavaObject(t,ItemAttrValDO.class));
        }
        JSONArray stockJson= jsonObject.getJSONArray("stock");
        List<ItemStockDO> itemStockDOS = new ArrayList<>();
        for(int i = 0; i < stockJson.size(); i++){
            JSONObject t = stockJson.getJSONObject(i);
            itemStockDOS.add(JSON.toJavaObject(t,ItemStockDO.class));
        }
        try{
            itemService.modifyItem(itemDO,itemAttrKeyDOS,itemAttrValDOS,itemStockDOS);
        }catch (BusinessException e) {
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(), "false");
        }
        return CommonReturnType.create("true");
    }

    /**
     * 删除指定itemid的商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteItem",method = RequestMethod.GET)
    public CommonReturnType deleteItem(@RequestParam(value = "itemId") String id){
        try{
            itemService.deleteItem(id);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("商品删除成功");
    }

    /**
     * 返回所有分类信息
     * @return
     */
    @RequestMapping(value = "/getAllCategory",method = RequestMethod.GET)
    public CommonReturnType getAllCategory(){
        List<CategoryDO> list = null;
        try{
            list = itemService.getAllCategory();
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create(list);
    }
    /**
     * 添加分类信息
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/addCategory",method = RequestMethod.POST)
    public CommonReturnType addCategory(@RequestBody JSONObject jsonObject){
        CategoryDO categoryDO = JSON.toJavaObject(jsonObject,CategoryDO.class);
        categoryDO.setCreateTime(DateTimeUtil.getCurrentTime());
        categoryDO.setUpdateTime(DateTimeUtil.getCurrentTime());
        try{
            itemService.uploadCategory(categoryDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("分类添加成功");
    }

    /**
     * 修改分类信息
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/updateCategory",method = RequestMethod.POST)
    public CommonReturnType updateCategory(@RequestBody JSONObject jsonObject) {
        CategoryDO categoryDO = JSON.toJavaObject(jsonObject,CategoryDO.class);
        try {
            categoryDO.setUpdateTime(DateTimeUtil.getCurrentTime());
            itemService.modifyCategory(categoryDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return  CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("分类修改成功");
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteCategory",method = RequestMethod.GET)
    public CommonReturnType deleteCategory(@RequestParam(value = "catId") int id){
        try {
            itemService.deleteCategory(id);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("分类删除成功");
    }

    @RequestMapping(value = "/getByCatId",method = RequestMethod.GET)
    public CommonReturnType getByCatId(@RequestParam(value = "catId") String catIdGroup){
        String[] catIdS = catIdGroup.split(",");
        List<ItemVO> itemVOS = new ArrayList<>();
        try{
            for(String s : catIdS){
                int catId = Integer.valueOf(s);
                itemVOS.addAll(itemService.getItemVOByCatId(catId));
            }
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create(itemVOS);
    }

    @RequestMapping(value = "/getItemDetail",method = RequestMethod.GET)
    public CommonReturnType getItemDetail(@RequestParam(value = "itemId") String itemId){
        Map<String,Object> map = null;
        try{
            map = itemService.getItemDetail(itemId);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create(map);
    }
}
