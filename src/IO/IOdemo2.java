package IO;/* 重定向 */

import java.io.*;
import java.util.Scanner;

public class IOdemo2 {
    public static void main(String[] args) {
            //testRedictOut();
            testRedicIn();
    }
    /* 标准输出流(输出屏幕)重定向为向文件输出*/
    public static void testRedictOut(){
        try(
                PrintStream ps = new PrintStream(new FileOutputStream("F:/wzs/tt1.txt"))
                ) {
            System.setOut(ps);
            System.out.println("白日依山尽，");
            System.out.println("黄河入海流。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*标准输入流(输入为键盘)重定向为从文件输入*/
    public static void testRedicIn(){
        try(
                FileInputStream fi = new FileInputStream("F:/wzs/tt1.txt")
                ) {
            System.setIn(fi);
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                System.out.println(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
