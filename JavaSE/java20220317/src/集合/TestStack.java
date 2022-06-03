package 集合;

import 集合工具.MyStack;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        MyStack<String> s=new MyStack<String>();

        s.push("aaa");
        s.push("aaa");
        s.push("aaa");
        s.push("aaa");
        s.push("aaa");

        int size=s.size();


        for (int i = 0; i < size; i++) {
            System.out.println(s.pop());

        }

//        System.out.println(s.remove(0));

    }

}
