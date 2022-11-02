package com.nanjie.controller;

import com.nanjie.common.Result;
import com.nanjie.config.QiniuCloudUtil;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
@RestController
public class typeimageController {
    @ResponseBody
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public Result uploadImg(@RequestParam MultipartFile image, HttpServletRequest request) throws IOException {
        //1：密钥，这里写问们上面的密钥
        final String AK = "qqJ8sTmXU4E9jFhmUQXeasc2jHuEN22BmVXfOvRZ";
        final String SK = "4iqB8Y9H0-Y8M94TOptfEorU35iLNarbA-5l5FRW";
        //2：指定工作空间，也就我我们上面创建的存储空间
        final String BUCKET = "shangnanjie";
        byte[] bytes = image.getBytes();
        Auth auth =Auth.create(AK,SK);
        String token = auth.uploadToken(BUCKET);
        //指定大区
        Configuration cfg = new Configuration(Zone.zone2());
        //我们需要上传的文件的地址
        //上传的文件的名称
        String name = UUID.randomUUID().toString();
        //进行图片的上传
        UploadManager uploadManager = new UploadManager(cfg);
        Response response= uploadManager.put(bytes,name,token);
        System.out.println(response);
        return Result.ok(200,"上传更改","http://giao.tomxlysplay.com.cn/"+name);
    }
}
