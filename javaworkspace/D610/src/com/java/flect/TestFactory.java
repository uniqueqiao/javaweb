package com.java.flect;
import java.io.FileInputStream;
import java.util.Properties;
public class TestFactory {
    public static void main(String[] args) throws Exception {
        //开闭原则：开：拓展；闭：程序的修改
        Computer comp=new Computer();
        USB usb=USBFactory.getUSB();
        comp.service(usb);
    }
}
//利用工厂解决对象的创建
class USBFactory{
    public static USB getUSB() throws Exception {
      /*  //用IO流读取文件[太复杂]
        FileReader fr = new FileReader("file/factory.txt");
        BufferedReader br=new BufferedReader(fr);
        String r=br.readLine();
        String[] s=r.split("=");
        //根据类名获取类对象
        Class c=Class.forName(s[1]);*/
        Properties pro=new Properties();
        FileInputStream fis=new FileInputStream("file/config.txt");
        pro.load(fis);
        //利用不变的key获取value   getProperty
        String value = pro.getProperty("className");
        //根据类名获取类对象
        Class c=Class.forName(value);
        //根据类对象获取实例
        Object obj = c.newInstance();
        return (USB)obj;
    }
}
class Computer{
    public void service(USB usb) {
        usb.work();
    }
}
interface USB{
    void work();
}
class Fan implements USB{
    public void work() {
        System.out.println("FAN...");
    }
}
class Mouse implements USB{
    public void work() {
        System.out.println("MOUSE...");
    }
}
class Keyboard implements USB{
    public void work() {
        System.out.println("KEYBOARD...");
    }
}


