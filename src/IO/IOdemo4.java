package IO;/*序列化*/
/**
 * 序列化规则：
 * 该对象中引用类型的成员变量也必须是可序列化的（实现Serializable接口）
 * 该类的直接和间接父类要么具有无参构造器，要么是可序列化的
 * 一个对象只会序列化一次，再次序列化时仅仅会输出它的序列号而已
 */
import java.io.*;

public class IOdemo4 {
    public static void main(String[] args) {
        //testSerialize();
        testDeserialize();
    }
    //序列化是将对象中的数据（成员变量）转化为子节序列存储在磁盘上或网络传输，和成员方法无关
    public static void testSerialize(){
        try(
                ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("F:/wzs/car.txt"));
                ) {
            ob.writeObject(new Car("奔驰","red",300));
            ob.writeObject(new Car("宝马","black",500));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //反序列化不会调用对象的初始化方法，而是从序列化的序列中得到对象
    public  static void testDeserialize(){
        try(
                ObjectInputStream obi = new ObjectInputStream(new FileInputStream("F:/wzs/car.txt"));
                ) {
            System.out.println(obi.readObject());
            System.out.println(obi.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


static class Car implements Serializable {
        private String brand;
        private String color;
        private int price;

        public Car(String brand, String color, int price) {
            System.out.println("Init Car");
            this.brand = brand;
            this.color = color;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", color='" + color + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
