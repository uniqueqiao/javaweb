package com.baizhi.qfl.view;
import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.service.LibraryService;
import com.baizhi.qfl.service.LibraryServiceImpl;
import com.baizhi.qfl.service.ManagerService;
import com.baizhi.qfl.service.ManagerServiceImpl;

import java.util.List;
import java.util.Scanner;



public class LibraryView {
	private Scanner sc=new Scanner(System.in);
	private ManagerService ms= new ManagerServiceImpl();
	private LibraryService lib=new LibraryServiceImpl();
	public  void login(){
		System.out.println("*******************欢迎使用图书馆管理系统********************");
		System.out.println("图书馆管理员登陆");
		System.out.print("用户名:");
		String username=sc.next();
		System.out.print("密码：");
		String password=sc.next();
		if(ms.login(username, password)) {
			System.out.println("登陆成功，进入图书管理系统!");
			showMainView();
		}else {
			System.out.println("用户密码错误");
		}
	}
	public  void showMainView(){
		while(true){
			System.out.println("*******************管理员操作界面********************");
			System.out.println("1.增加图书");
			System.out.println("2.删除图书");
			System.out.println("3.修改图书信息");
			System.out.println("4.查看所有图书");
			System.out.println("5.*根据价格区间查找图书");
			System.out.println("6.*类别名称，查找图书");
			System.out.println("7.退出");
			System.out.println("*******************管理员操作界面********************");
			System.out.println("请输入你的选项：");
			int selected = sc.nextInt();
			requestDispatcher(selected);
		}
	}
	public void  requestDispatcher(int selected) {
		try {
			switch(selected){
				case 1:{ showAddBookView(); break;}
				case 2:{ deleteBookView(); break;}
				case 3:{ updateBookView();break;}
				case 4:{ queryAllBookView(); break;}
				case 5:{ queryBookByPriceView(); break;}
				case 6:{ queryBookBygenreView(); break;}
				case 7:{
					System.out.println("--------------------谢谢使用,再见------------------");
					System.exit(0);
					break;
				}
				default:{
					throw new Exception("输入错误，请考虑重新选择！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//	增加图书
	public void showAddBookView(){
		System.out.println("请输入书名");
		String name=sc.next();
		System.out.println("请输入价格");
		double price =sc.nextDouble();
		System.out.println("请输入类型");
		String category=sc.next();
		System.out.println("请输入细节内容");
		String detail=sc.next();
		Book book = new Book(null,name,price,category,detail);
		lib.addBook(book);
		System.out.println("添加成功");
	}
	//	删除图书
	public void deleteBookView(){
		// 输入删除书籍编号，先展示要删除的书籍信息，存在则删除；书籍不存在给与提示
		System.out.println("请输入要删除的图书id");
		int id=sc.nextInt();
		lib.removeBook(id);
		System.out.println("删除成功");
	}
	//	修改图书信息
	public void updateBookView(){
		// 输入修改书籍编号，先展示要修改的书籍信息，存在则修改相关信息，不存在则给与提示
		System.out.println("请输入要删除的图书id");
		int id=sc.nextInt();
		System.out.println("请输入书名");
		String name=sc.next();
		System.out.println("请输入价格");
		double price =sc.nextDouble();
		System.out.println("请输入类型");
		String category=sc.next();
		System.out.println("请输入细节内容");
		String detail=sc.next();
		Book book = new Book(id,name,price,category,detail);
		lib.updateBook(book);
	}
	//	查看所有图书
	public void queryAllBookView(){
		List<Book> books=lib.queryAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	//	根据价格区间查找图书
	public void queryBookByPriceView(){
		System.out.println("请输入最低价格");
		double minprice =sc.nextDouble();
		System.out.println("请输入最高价格");
		double maxprice =sc.nextDouble();
		List<Book> books=lib.getBooksByPriceRange(minprice,maxprice);
		for(Book book : books) {
			System.out.println(book);
		}
	}
	//	类别名称查找图书
	public void  queryBookBygenreView(){
		System.out.println("请输入要查找的类型");
		String category=sc.next();
		List<Book> list= lib.getBooksByCategory(category);
		for (Book book : list) {
			System.out.println(book);
		}
	}
}