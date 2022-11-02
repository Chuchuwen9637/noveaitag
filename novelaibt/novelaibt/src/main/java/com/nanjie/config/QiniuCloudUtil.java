package com.nanjie.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class QiniuCloudUtil {

    // 设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = "qqJ8sTmXU4E9jFhmUQXeasc2jHuEN22BmVXfOvRZ";
    private static final String SECRET_KEY = "4iqB8Y9H0-Y8M94TOptfEorU35iLNarbA-5l5FRW";

    // 要上传的空间
    private static final String bucketname = "shangnanjie";

    // 密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private static final String DOMAIN = "giao.tomxlysplay.com.cn";

    private static final String style = "imageView2/0/q/75";

    public String getUpToken() {
        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
    }
    // 普通上传
    public String uplaoad(String filePath, String fileName) throws IOException {
        // 创建上传对象
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            // 调用put方法上传
            String token = auth.uploadToken(bucketname);
            /*if  (UtilValidate.isEmpty(token)) {
                System.out.println("未获取到token，请重试！");
                return null;
            }*/
            Response res = uploadManager.put(filePath, fileName, token);
            // 打印返回的信息
            System.out.println("七牛云"+res.bodyString());
            if (res.isOK()) {
                Ret ret = res.jsonToObject(Ret.class);
                //如果不需要对图片进行样式处理，则使用以下方式即可
                //return DOMAIN + ret.key;
                return DOMAIN + ret.key + "?" + style;
            }
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println("七牛云2"+r.toString());
            try {
                // 响应的文本信息
                System.out.println("七牛云3"+r.bodyString());
            } catch (QiniuException e1) {
                // ignore
            }
        }
        return null;
    }


    //base64方式上传
    public String put64image(byte[] base64, String key) throws Exception{
        String file64 = Base64.encodeToString(base64, 0);
        Integer l = base64.length;
        String url = "http://up-z2.qiniup.com/putb64/" + l + "/key/"+ UrlSafeBase64.encodeToString(key);
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        //System.out.println(request.headers());
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println("64base七牛云");
        System.out.println(response);
        //如果不需要添加图片样式，使用以下方式
        //return DOMAIN + key;
        return "http://"+DOMAIN +"/"+ key;
    }


    // 普通删除(暂未使用以下方法，未测试)
    public void delete(String key) throws IOException {
        // 实例化一个BucketManager对象
        Configuration cfg = new Configuration(Zone.zone2());
        BucketManager bucketManager = new BucketManager(auth,cfg);
        // 此处的33是去掉：http://ongsua0j7.bkt.clouddn.com/,剩下的key就是图片在七牛云的名称
        key = key.substring(33);
        try {
            // 调用delete方法移动文件
            bucketManager.delete(bucketname, key);
        } catch (QiniuException e) {
            // 捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
        }
    }

    class Ret {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;
    }
}
