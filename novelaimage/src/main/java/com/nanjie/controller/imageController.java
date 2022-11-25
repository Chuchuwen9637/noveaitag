package com.nanjie.controller;


import com.nanjie.common.Result;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

@RestController
public class imageController {
    @Value("${file.image.path}")
    private String imagePath;
    @Value("${file.image.pathsamll}")
    private  String imagesamll;
    private String httppath="http://localhost:4431/down/";
    private String httspath="http://tomxlysplay.com.cn:4431/down/";
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public Result uploadImg(MultipartFile image, HttpServletRequest request) throws IOException {
        if (image.isEmpty()){
            return Result.ok(201,"上传图片为空",null);
        }

        String filename= UUID.randomUUID().toString()+".jpeg";
        image.transferTo(new File(imagePath,filename));
        System.out.println("文件上传成功路径为"+imagePath);
        //图片压缩
        try {
            //图片所在路径
            BufferedImage templateImage = ImageIO.read(new File(imagePath+"/"+filename));
            //原始图片的长度和宽度
            int height = templateImage.getHeight();
            int width = templateImage.getWidth();
            //通过比例压缩
            float scale = 0.5f;
            //通过固定长度压缩
            /*int doWithHeight = 100;
            int dowithWidth = 300;*/
            //压缩之后的长度和宽度
            int doWithHeight = (int) (scale * height);
            int dowithWidth = (int) (scale * width);
            BufferedImage finalImage = new BufferedImage(dowithWidth, doWithHeight, BufferedImage.TYPE_INT_RGB);
            finalImage.getGraphics().drawImage(templateImage.getScaledInstance(dowithWidth, doWithHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
            //上谜案是处理过后的图片

           //图片输出路径，以及图片名
            FileOutputStream fileOutputStream = new FileOutputStream(imagesamll+"/"+filename);

            ImageIO.write(finalImage,"jpeg",fileOutputStream);
          /*  JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
            encoder.encode(finalImage);
            fileOutputStream.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.ok(200,"图片上传成功",httspath+filename);
    }
    @RequestMapping("/down/{filename}")
    public void downimage(@PathVariable String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileInputStream is = new FileInputStream(new File(imagesamll, filename));
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(is,os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
    @RequestMapping("/downbig/{filename}")
    public  void downbigimage(@PathVariable String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileInputStream is = new FileInputStream(new File(imagePath, filename));
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(filename,"UTF-8"));
        IOUtils.copy(is,os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
}
