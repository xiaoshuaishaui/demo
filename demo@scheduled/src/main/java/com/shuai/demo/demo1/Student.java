package com.shuai.demo.demo1;

public class Student extends Person{

    public Student(){
        this.name = "xieshuai";
    }

    public static void main(String[] args) {
        System.out.println(new Student().name);
    }
}
