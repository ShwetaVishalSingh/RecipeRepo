package com.recipe.se.recipes.practice;

import com.recipe.se.recipes.practice.SingletonClassExample;

class Main
{
    public static void main(String args[])
    {
        // instantiating Singleton class with variable x
        SingletonClassExample x = SingletonClassExample.getInstance();

        // instantiating Singleton class with variable y
        SingletonClassExample y = SingletonClassExample.getInstance();

        // instantiating Singleton class with variable z
        SingletonClassExample z = SingletonClassExample.getInstance();

        // changing variable of instance x
        x.value = (x.value).toUpperCase();

        System.out.println("String from x is " + x.value);
        System.out.println("String from y is " + y.value);
        System.out.println("String from z is " + z.value);
        System.out.println("\n");

        // changing variable of instance z
        z.value = (z.value).toLowerCase();

        System.out.println("String from x is " + x.value);
        System.out.println("String from y is " + y.value);
        System.out.println("String from z is " + z.value);
    }
}
