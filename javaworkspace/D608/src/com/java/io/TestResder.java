package com.java.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestResder {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("");
        fos.write('中');
        fos.close();
    }
}
