package com.java.ex;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestEx {
}
class MyClass {
    public void m1()throws IOException {}
}
class Sub extends MyClass {
    @Override
    public void m1() throws FileNotFoundException, EOFException{

    }
}