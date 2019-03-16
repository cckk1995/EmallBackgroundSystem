package com.emall.controller;

import com.emall.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *  Created by cckk1995 on 2019/3/14
 */
@CrossOrigin
@Controller
public class FileUploadController {

    @Value("${imgUploadLocations}")
    private String filePath;

    @RequestMapping(value="/uploading",method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file")MultipartFile file,
                     HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
        return filePath+fileName;
    }
}
