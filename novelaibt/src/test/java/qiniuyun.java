import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class qiniuyun {
    public static void main(String[] args) throws QiniuException {
        //1：密钥，这里写问们上面的密钥
        final String AK = "";
        final String SK = "";
        //2：指定工作空间，也就我我们上面创建的存储空间
        final String BUCKET = "";

        Auth auth =Auth.create(AK,SK);
        String token = auth.uploadToken(BUCKET);

        //指定大区
        Configuration cfg = new Configuration(Zone.zone2());

        //我们需要上传的文件的地址
        String local = "C:\\Users\\zhou\\Desktop\\yuanshen\\dddd.png";
        //上传的文件的名称
        String name = "beauuty.jpg";
        File file = new File(local);
        //进行图片的上传
        UploadManager uploadManager = new UploadManager(cfg);
       Response response= uploadManager.put(file,name,token);
       System.out.println(response);
    }

    @Test
    public void yasuo() {
       /* try {
            //图片所在路径
            BufferedImage templateImage = ImageIO.read(new File("D:\\google下载的文件\\image.jpeg\\1f92b6e4-8a9d-4913-8803-590577c6d537.jpeg"));


            //原始图片的长度和宽度
            int height = templateImage.getHeight();
            int width = templateImage.getWidth();

            //通过比例压缩
            float scale = 0.5f;

            //通过固定长度压缩
            *//*int doWithHeight = 100;
            int dowithWidth = 300;*//*

            //压缩之后的长度和宽度
            int doWithHeight = (int) (scale * height);
            int dowithWidth = (int) (scale * width);



            BufferedImage finalImage = new BufferedImage(dowithWidth, doWithHeight, BufferedImage.TYPE_INT_RGB);

            finalImage.getGraphics().drawImage(templateImage.getScaledInstance(dowithWidth, doWithHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);


            //图片输出路径，以及图片名
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zhou\\Desktop\\yausohou\\1f92b6e4-8a9d-4913-8803-590577c6d537.jpeg");
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
            encoder.encode(finalImage);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
    }

}
