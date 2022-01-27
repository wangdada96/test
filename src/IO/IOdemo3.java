package IO;/*RandomAccessFile*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IOdemo3 {
    public static void main(String[] args) {
        try(
                RandomAccessFile rd = new RandomAccessFile("F:/wzs/tt1.txt","rw");
                ) {
            //定位到文件末尾，进行写操作
            rd.seek(rd.length());
            rd.write("欲穷千里目\n".getBytes());
            rd.write("更上一层楼\n".getBytes());
            //定位到文件开头
            rd.seek(0);
            String line = null;
            while((line = rd.readLine()) !=  null){
                /*getBytes()默认编码规则为utf-8,readLine()默认解码规则为ISO8859-1，故会导致乱码，因此采用如下方式解决乱码*/
                byte[] bytes = line.getBytes("ISO8859-1");
                line = new String(bytes,"UTF-8");
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
