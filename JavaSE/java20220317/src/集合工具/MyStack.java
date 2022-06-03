package 集合工具;

import java.util.Stack;
//适配器模式
public class MyStack<E> {
    private Stack<E> stack;

    public MyStack(){
        stack=new Stack<E>();
    }

    public boolean empty(){
        return stack.empty();
    }

    public E peek(){
        return stack.peek();
    }

    public E pop(){
        return stack.pop();
    }

    public E push(E item){
        return stack.push(item);
    }

    public int search(Object o){
        return stack.search(o);
    }

    public int size(){
        return stack.size();
    }

}
