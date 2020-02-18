package com.recipe.se.recipes.practice;

class SingletonClassExample {

    private static SingletonClassExample SINGLETONOJB = null;

    String value;

    private SingletonClassExample() {
        value = "i am a string of a singleton class";
    }

    public static  SingletonClassExample getInstance() {
        if(SINGLETONOJB == null)
        {
            SINGLETONOJB = new SingletonClassExample();
        }
        return SINGLETONOJB;
    }
}
