package com.emall.controller;


import com.emall.dataobject.CategoryDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.CategoryService;
import com.emall.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获得所有的分类
     * @return
     */
    @RequestMapping(value ="/getAllCategory",method = RequestMethod.GET)
    public CommonReturnType getAllCategory(){
        try{
            return CommonReturnType.create(categoryService.getAllCategory());
        }catch (BusinessException e){
            return CommonReturnType.create(CrossOrigin.class,"false");
        }
    }

    /**
     * 添加一个分类
     * @param catParentId
     * @param catName
     * @return
     */
    @RequestMapping(value = "/addCategory",method = RequestMethod.POST)
    public CommonReturnType addCategory(@RequestParam(value = "catParentId") int catParentId,
                                        @RequestParam(value = "catName") String catName){
        if(catName==null) {
            return CommonReturnType.create("参数不完整","false");
        }
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setCatParentId(catParentId);
        categoryDO.setCatName(catName);
        categoryDO.setCatStatus(true);
        categoryDO.setCreateTime(DateTimeUtil.getCurrentTime());
        categoryDO.setUpdateTime(DateTimeUtil.getCurrentTime());
        categoryDO.setSortOrder(100);
        try{
            categoryService.addCategory(categoryDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("添加分类成功");
    }

    /**
     * 删除分类
     * @param catId
     * @return
     */
    @RequestMapping(value = "/deleteCategory",method = RequestMethod.POST)
    public CommonReturnType deleteCategory(@RequestParam(value = "catId") int catId){
        try{
            categoryService.deleteCategory(catId);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("删除分类成功");
    }
}
