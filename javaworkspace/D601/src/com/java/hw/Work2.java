package com.java.hw;
import java.util.*;

public class Work2 {
    public static void main(String[] args) {
        //(1)创建多个商品对象，存储在List集合中
        List<Product> pro=new ArrayList<Product>();
        pro.add(new Product("bj1", 1000.0, 0, "北京"));
        pro.add(new Product("bj2", 2000.0, 100, "北京"));
        pro.add(new Product("bj2", 10000.0, 1, "北京"));
        pro.add(new Product("bj4",5000.0 , 0, "北京"));
        pro.add(new Product("sh1", 500.0, 500, "上海"));
        pro.add(new Product("sh2",6000.0 ,0 , "上海"));
        pro.add(new Product("sh3", 300.0,1000 , "上海"));
        pro.add(new Product("sh4", 100.0,10000 , "上海"));
        //(2)显示所有的商品信息；
        System.out.println("-----显示所有的商品信息----");
        for (Product p:pro) {
            System.out.println(p);
        }
        //(3) 打印输出商品价格 > 1000 的所有商品信息；
        System.out.println("-----打印输出商品价格 > 1000 的所有商品信息---");
        for (Product p:pro) {
            if(p.getPrice()>1000)
            System.out.println(p);
        }
        //(4) 打印售空的商品的信息；
        System.out.println("-----打印售空的商品的信息---");
        for (Product p:pro) {
            if(p.getAmount()==0)
                System.out.println(p);
        }
        //(5) 打印输出商品产地为"北京"的商品信息；
        System.out.println("----打印输出商品产地为\"北京\"的商品信息---");
        for (Product p:pro) {
            if(p.getAddress()=="北京")
                System.out.println(p);
        }
        //(7) 输入一个价格段，查询出集合中所有在这个价格区间的所有商品信息。
        System.out.println("---输入一个价格段，查询出集合中所有在这个价格区间的所有商品信息---");
        Scanner sc=new Scanner(System.in);
        double n=sc.nextDouble(),m=sc.nextDouble();
        for (Product p:pro) {
            if(p.getPrice()>n&&p.getPrice()<m)
                System.out.println(p);
        }
    }
}
//创建一个商品(Product)类,属性：商品名，商品单价，商品的数量，商品产地.
class Product{
    private String name;
    private Double price;
    private Integer amount;
    private String address;

    public Product() {
    }

    public Product(String name, Double price, Integer amount, String address) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}