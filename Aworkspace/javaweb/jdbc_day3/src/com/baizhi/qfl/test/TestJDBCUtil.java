package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;

public class TestJDBCUtil {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getConnection();
        System.out.println(conn);
    }
}
