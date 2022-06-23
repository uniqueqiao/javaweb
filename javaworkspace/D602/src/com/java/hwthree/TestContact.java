package com.java.hwthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.jar.Pack200;

//测试类
public class TestContact{
    public static void main(String[] args){
        Contacts c= new Contacts();
        c.menue();
    }
}

//通讯录类
class Contacts{
    private List<Person> ps = new ArrayList<Person>();//存储联系人
    Scanner sc=new Scanner(System.in);
    //主界面
    public void menue(){
        init();//数据的初始化
        Scanner s = new Scanner(System.in);
        int i ;
        do{  //注意： id 是 集合中的下标
            System.out.println("***************欢迎进入百知通讯录系统*************");
            System.out.println("********1. 查询所有联系人    	2. 根据id查询联系人");
            System.out.println("********3. 根据id修改联系人  	4. 根据id删除联系人");
            System.out.println("********5. 添加联系人         ");
            System.out.println("********6. 输入一个姓，查询出对应此姓对应的联系人【模糊查询】 ");
            //System.out.println("********7. 输入性别，查询出此性别所有联系人 ");
            //System.out.println("********8. 输入一个年龄段，查询出此年龄段的所有联系人 ");
            //System.out.println("********9. 输入一个电话，查询是否有此联系人 ");
            //System.out.println("********10.输入要查询的城市，查询出此城市的所有联系人 ");
            System.out.println("********12. 清空联系人          13. 退出系统");
            System.out.print("请输入您要查询的内容：");
            i = s.nextInt();
            switch (i){
                case 1:   show(); break;
                case 2:
                    System.out.println("根据ID查询联系人");
                    System.out.println("输入要查询ID：");
                    int id=sc.nextInt();
                    checkPersonById(id);break;
                case 3:
                    System.out.println("根据ID修改联系人");
                    System.out.println("输入要修改的ID：");
                    int id2=sc.nextInt();
                    updateById(id2);
                    break;
                case 4:  System.out.println("根据ID删除联系人");
                    System.out.println("输入要删除的ID：");
                    int id3=sc.nextInt();
                    removeById(id3);
                    break;
                case 5:
                    System.out.println("添加联系人");
                    addPerson();
                    break;
                case 12:
                    System.out.println("清空联系人");
                    clearPerson();break;
                case 13:  System.out.println("退出系统");break;
                default: System.out.println("您输入的信息有误");break;
            }
        }while(i!=7);
    }
    //给程序部分初始数据
    public void init(){
        ps.add(new Person("张一",19,"男","12332659566","address1"));
        ps.add(new Person("张二",20,"女","13256597856","address2"));
        ps.add(new Person("张三",21,"男","13336541256","address3"));
        ps.add(new Person("张四",15,"女","15526354896","address4"));
        ps.add(new Person("王一",17,"男","15340653265","address5"));
        ps.add(new Person("网二",20,"女","13852644686","address6"));
        ps.add(new Person("王五",25,"男","13652362686","address7"));

    }
    public void show(){
        for (Person p:ps) {
            System.out.println(p);
        }
    }
    //根据id(下标)查询
    public void checkPersonById(int id){
        if(ps.get(id) != null){
            System.out.println(ps.get(id));
        }else {
            System.out.println("该用户不存在");
        }

    }
    //根据id(下标) 修改
    public void updateById(int id){
        while (true){
            Person p = ps.get(id);
            System.out.println("请输入要修改的内容,按0退出");
            String content=sc.next();
            if(content.equals("姓名")){
                System.out.println("请输入修改的姓名");
                String newName=sc.next();
                p.setName(newName);
                System.out.println("修改成功,当前姓名为："+p.getName());
            }else if (content.equals("年龄")) {
                System.out.println("请输入修改的年龄");
                Integer newAge=sc.nextInt();
                p.setAge(newAge);
                System.out.println("修改成功,当前年龄为:"+p.getAge());
            }else if (content.equals("性别")) {
                System.out.println("请输入修改的性别");
                String newSex=sc.next();
                p.setSex(newSex);
                System.out.println("修改成功,当前性别为:"+p.getSex());
            }else if (content.equals("电话")) {
                System.out.println("请输入修改的电话");
                String newTel=sc.next();
                p.setTel(newTel);
                System.out.println("修改成功,当前电话为:"+p.getTel());
            }else if (content.equals("住址")) {
                System.out.println("请输入修改的住址");
                String newAdd=sc.next();
                p.setAddress(newAdd);
                System.out.println("修改成功,当前住址为:"+ p.getAddress());
            }else if (content.equals("0")) {
                break;
            }else System.out.println("输入有误");
        }

    }
    //根据id(下标)删除联系人
    public void removeById(int id){
        Person p=ps.get(id);
        boolean b=ps.remove(p);
        if(b==true)
            System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    //添加联系人
    public void addPerson(){
        System.out.println("请依次输入姓名、年龄、性别、电话、住址，空格隔开");
        String name=sc.next();
        int age=sc.nextInt();
        String sex=sc.next();
        String tel=sc.next();
        String add=sc.next();
        if(ps.add(new Person(name,age,sex,tel,add))==true)
            System.out.println("添加成功");
        else System.out.println("添加失败");
    }
    //清空用户
    public void clearPerson(){
        ps.clear();
        System.out.println("清空成功");
    }
}

class Person{
    //属性：姓名、年龄、性别、电话、住址---》私有化
    private String name;
    private Integer age;
    private String sex;
    private String tel;
    private String address;
    //构造方法

    public Person() {
    }

    public Person(String name, Integer age, String sex, String tel, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.address = address;
    }
//get、set

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getAge(), person.getAge()) && Objects.equals(getSex(), person.getSex()) && Objects.equals(getTel(), person.getTel()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSex(), getTel(), getAddress());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
