

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class image {
    public static void main(String[] args) {
        File f=new File("D:\\google下载的文件");
        String[] list = f.list();
        for (String s : list) {
           File imagename=new File("D:\\google下载的文件\\"+s);
           System.out.println(imagename.getName()+"获取名字");
          // imagename.renameTo(new File(imagename+".jpeg"));
            System.out.println(s);
        }

    }
    public static void ceshi(String name){
        try {
            //图片所在路径
            BufferedImage templateImage = ImageIO.read(new File("D:\\google下载的文件\\image_RSmGHM\\image\\"+name));
            //原始图片的长度和宽度
            System.out.println("当前文件为"+name);
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


            //图片输出路径，以及图片名
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zhou\\Desktop\\yausohou\\"+name);
            ImageIO.write(finalImage,"jpeg",fileOutputStream);;
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            return;
        }

    }
    @Test
    public void dddd(){
        File file=new File("D:\\google下载的文件\\image_RSmGHM\\image");
        for (String s:file.list()
             ) {
            image.ceshi(s);
            System.out.println(s);
        }
    }
}
