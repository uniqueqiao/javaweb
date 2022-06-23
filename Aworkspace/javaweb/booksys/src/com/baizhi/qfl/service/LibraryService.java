package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.Book;

import java.util.List;

/**
 * 图书管理系统业务功能标准（接口）
 */
public interface LibraryService {
	/**
	 * 描述:TODO 将参数book对象添加到数据仓库类中
	 */
	public void addBook(Book book);

	public void removeBook(Integer bookId);

	public void updateBook(Book book);

	public List<Book> queryAllBooks();
	/**
	 * 描述:TODO 根据价格区间找到   minPrice<=price<=maxPrice的所有图书
	 */
	public List<Book> getBooksByPriceRange(double minPrice, double maxPrice);
	/**
	 * 描述:TODO 根据类名查找所有的图书
	 */
	public List<Book> getBooksByCategory(String category);
}

