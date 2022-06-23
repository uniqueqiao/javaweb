package com.java.threadtwo;
public class TestMyList {
    public static void main(String[] args) throws InterruptedException {
        MyList list = new MyList();
        //list.add();
        ThreadA t1=new ThreadA(list);
        t1.start();

        ThreadB t2=new ThreadB(list);
        t2.start();
        t1.join();
        t2.join();//让两个自己抢
        //遍历
        list.printList();
    }
}

//线程任务一添加C
class ThreadA extends Thread{
    private MyList list;
    @Override
    public void run() {
        list.add("C");

    }
    public ThreadA(MyList list){
        this.list = list;
    }
}

//线程任务二添加D
class ThreadB extends Thread{
    private MyList list;
    @Override
    public void run() {
            list.add("D");
    }
    public ThreadB(MyList list){
        this.list = list;
    }
}

class MyList{
    private String[] str={"A","B","","",""};
    private int index=2;
    //添加
    public synchronized void add(String s) {//同步方法
        str[index]=s;
        try {
            Thread.sleep(500);//因为休眠去，index++没有执行
        }catch(Exception e) {
            e.printStackTrace();
        }
        index++;

    }
    //遍历
    public void printList(){
        System.out.println("一共有"+index+"个");
        for (int i=0;i<index;i++){
            System.out.print(str[i]+" ");
        }
    }
}