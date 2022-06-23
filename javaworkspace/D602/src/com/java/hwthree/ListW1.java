package com.java.hwthree;
import java.util.ArrayList;
public class ListW1 {
    public static void main(String[] args) {
        login("张三", "1111111");
        login("王五", "2222222");
    }
   /* 定义一个函数login(String name,String password)，接收用户名和密码，
    判断该用户是否存在，存在返回true，不存在则返回 false.
    login函数中：定义一个List集合，存储多个Admin对象，*/
    public static boolean login(String name,String password) {
        ArrayList<Admin> list = new ArrayList<>();
        list.add(new Admin("001", "张三", "1111111"));
        list.add(new Admin("002", "李四", "2222222"));
        list.add(new Admin("003", "王三", "3333333"));
        list.add(new Admin("004", "刘五", "4444444"));
        int flag = 0;
        for (Admin admin : list) {
            if (admin.getName().equals(name) && admin.getPasssword().equals(password)) {
                flag++;
                System.out.println("登陆成功");
                return true;
            }
        }
        if (flag == 0) {
            System.out.println("登陆失败");
            return false;
        }
        return false;
    }
}
/*Admin的属性：id、name、password*/
class Admin{
    private String id;
    private String name;
    private String passsword;

    public Admin() {
    }

    public Admin(String id, String name, String passsword) {
        this.id = id;
        this.name = name;
        this.passsword = passsword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", passsword='" + passsword + '\'' +
                '}';
    }
}