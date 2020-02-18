package com.recipe.se.recipes.practice;

public class HashCodeAndEqualsExample {

    public static void main(String[] args) {
        Student alex1 = new Student(1, "Alex");
        Student alex2 = new Student(1, "Alex12");

        System.out.println("alex1 hashcode = " + alex1.hashCode());
        System.out.println("alex2 hashcode = " + alex2.hashCode());

        boolean b = alex1.equals(alex2);
        boolean b1 = alex1 == alex2;
        System.out.println("Checking equality between alex1 and alex2 = " + b);
        System.out.println("Checking equality between alex1 and alex2 = " + b1);


    }
}
