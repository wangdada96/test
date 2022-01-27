package IO;/* 打印流 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class IOdemo1 {
    public static void main(String[] args) {
            testPrintStream("F:/wzs/tt.txt");
    }
    public static void testPrintStream(String sour){
        try(
                FileOutputStream os = new FileOutputStream(sour);
                PrintStream ps = new PrintStream(os);
                ) {
            ps.println("今天没吃饭");
            ps.println("今天吃饭了，嘻嘻！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
