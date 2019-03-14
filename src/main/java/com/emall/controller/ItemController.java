package com.emall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.emall.dataobject.ItemAttrKeyDO;
import com.emall.dataobject.ItemAttrValDO;
import com.emall.dataobject.ItemDO;
import com.emall.dataobject.ItemStockDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/additem",method = RequestMethod.POST)
    public CommonReturnType addItem(@RequestBody JSONObject jsonObject){
        JSONObject itemJson = jsonObject.getJSONObject("item");
        ItemDO itemDO = JSON.toJavaObject(itemJson,ItemDO.class);
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
            itemService.uploadItem(itemDO,itemAttrKeyDOS,itemAttrValDOS,itemStockDOS);
        }catch (BusinessException e) {
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(), "false");
        }
        return CommonReturnType.create("true");
    }
}
