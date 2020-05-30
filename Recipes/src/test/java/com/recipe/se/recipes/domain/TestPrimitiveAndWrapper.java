package com.recipe.se.recipes.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestPrimitiveAndWrapper {
    static int i = 50;
    int y =2;
    final int j = 10;

    public TestPrimitiveAndWrapper(int y) {
        this.y = y;
        hello();
    }
     public TestPrimitiveAndWrapper() {
      //  super()
        //this(10);
     }

    public static void main(String[] args) {
        Date date = new Date();
        TestPrimitiveAndWrapper testPrimitiveAndWrapper = new TestPrimitiveAndWrapper();
        //testPrimitiveAndWrapper.j=30;
        i=100;
        System.out.println(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzzz");
        String strDate= formatter.format(date);
        System.out.println(strDate);

        Date d1 = new Date(2000, 11, 21);
        System.out.println(d1);
        Date d3 = new Date(2010, 1, 3);
        boolean a = d3.after(d1);
        System.out.println("Date d3 comes after " +
                "date d2: " + a);
    }
    public  void hello() {
        i = 200;
    }
}
