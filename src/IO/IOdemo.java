package IO;/* 缓冲流*/

import java.io.*;

public class IOdemo {
    public static void main(String[] args) {
            CopyFile("F:/wzs/白底.jpg","F:/wzs/白底-副本.jpg");
    }

    public  static void CopyFile(String sourcefile,String dicfile){
        try(
                BufferedInputStream is = new BufferedInputStream(new FileInputStream(sourcefile));
                BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dicfile));
                ) {
            byte[] bytes = new byte[128];
            int len = 0;
            while((len = is.read(bytes,0,128))> 0){
                os.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
