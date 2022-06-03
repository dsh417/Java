package 集合.练习;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList implements List {

    private Object[] data;
    private int size;

    public MyArrayList(){
        data=new Object[10];
        size=0;
    }

    private void expand(){
        if(size==data.length){
            Object[] temp=new Object[data.length+data.length/2];
            System.arraycopy(data,0,temp,0,data.length);
            data=temp;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        expand();
        data[size++]=o;
//        后++先用后加

        return true;
    }

    @Override
    public boolean remove(Object o) {
        /*
        *
        *
        * */
        int i;
        if((i=indexOf(o))!=-1){
            remove(i);
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        data=new Object[10];
        size=0;
    }

    @Override
    public Object get(int index) {

        /*
        *
        * */

        return data[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        /*
        *
        *
        * */
        Object temp=data[index];
//        for (int i = index+1; i < data.length; i++) {
//
//        }
        System.arraycopy(data,index+1,data,index,size-index-1);
        size--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        /*
        *
        * */
        for (int i = 0; i < data.length; i++) {
            if(o==null?get(i)==null :o.equals(get(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        /*
        *
        *
        * */
        Object[] temp=new Object[size];
        System.arraycopy(data,0,temp,0,data.length);
        return temp;
    }
}
