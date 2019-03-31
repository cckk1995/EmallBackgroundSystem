package com.emall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emall.dataobject.ShufflingFigureDataDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.ShufflingFigureDataService;
import com.emall.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/shufflingFigureData")
@CrossOrigin
public class ShufflingFigureDataController {
    @Autowired
    private ShufflingFigureDataService shufflingFigureDataService;

    /**
     * 添加一个新的轮播图
     * @param itemId
     * @param sourceUrl
     * @param imgUrl
     * @param sorted
     * @return
     */
    @RequestMapping(value = "/addShufflingFigureData",method = RequestMethod.POST)
        public CommonReturnType addShufflingFigureData(@RequestParam(value = "itemId") String itemId,
                                                       @RequestParam(value = "sourceUrl") String sourceUrl,
                                                       @RequestParam(value = "imgUrl") String imgUrl,
                                                       @RequestParam(value = "sorted") int sorted){
        Date date = new Date();
        SnowFlake snowFlake = new SnowFlake(3,3);
        String shuffleId = String.valueOf(snowFlake.nextId());
        ShufflingFigureDataDO shufflingFigureDataDO = createShufflingFigureDataDO(shuffleId,itemId,sourceUrl,imgUrl,sorted,date,date);
        try {
            shufflingFigureDataService.uploadShufflingFigureData(shufflingFigureDataDO);
        } catch (BusinessException e) {
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("轮播图添加成功");
    }

    /**
     *
     * @param idGroup
     * @return
     */
    @RequestMapping(value = "/deleteShufflingFigureData",method = RequestMethod.GET)
    public CommonReturnType deleteShufflingFigureData(@RequestParam(value ="idGroup")String idGroup){
        try {
            shufflingFigureDataService.deleteShufflingFigureData(idGroup);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("轮播图删除成功");
    }
    /**
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/modifyShufflingFigureData",method = RequestMethod.POST)
    public CommonReturnType modifyShufflingFigureData(@RequestBody JSONObject jsonObject){
        ShufflingFigureDataDO shufflingFigureDataDO = JSON.toJavaObject(jsonObject,ShufflingFigureDataDO.class);
     //   shufflingFigureDataDO.setUpdatedDate(DateTimeUtil.getCurrentTime());
        try {
            shufflingFigureDataService.modifyShufflingFigureData(shufflingFigureDataDO);
        } catch (BusinessException e) {
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("轮播图修改成功");
    }

    /**
     * 获得所有的轮播图
     * @return
     */
    @RequestMapping(value = "/getAllShuffleFigure",method = RequestMethod.GET)
    public CommonReturnType getAllShufflingFigure(){
        try{
            return CommonReturnType.create(shufflingFigureDataService.getAllShufflingFigure());
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
    }

    private ShufflingFigureDataDO createShufflingFigureDataDO(String shuffId,String itemId,String sourceUrl, String imgUrl, int sorted, Date createdDate,Date updatedDate){
        ShufflingFigureDataDO shufflingFigureDataDO = new ShufflingFigureDataDO();
        shufflingFigureDataDO.setShufflingId(shuffId);
        shufflingFigureDataDO.setCreatedDate(createdDate);
        shufflingFigureDataDO.setImgUrl(imgUrl);
        shufflingFigureDataDO.setItemId(itemId);
        shufflingFigureDataDO.setSourceUrl(sourceUrl);
        shufflingFigureDataDO.setSorted(sorted);
        shufflingFigureDataDO.setUpdatedDate(updatedDate);
        return shufflingFigureDataDO;
    }
}
