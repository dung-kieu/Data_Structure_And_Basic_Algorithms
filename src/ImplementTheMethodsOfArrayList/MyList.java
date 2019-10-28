package ImplementTheMethodsOfArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static  final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    private void ensureCapa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }

    private void ensureCapa(int minimum){
        int newSize = minimum;
        elements = Arrays.copyOf(elements,newSize);
    }

    public void add(int index , E element){
        if (this.size == this.elements.length){
            this.ensureCapa();
        } else {
            for (int i = index ; i< this.size;i++){
                elements[i+1] = elements[i];
            }
            elements[index] = element;
        }
        this.size++;
    }

    public E remove(int index){
        E a = (E) elements[index];
        for (int i= index;i<this.size;i++){
            elements[i] = elements[i+1];
        }
        this.size--;
        return a;
    }

    public int size(){
        return this.size;
    }

    public E clone(int a){
        return (E) elements[a];

    }

    public boolean contains( E o){
        for (int i = 0;i<this.size;i++){
            if (elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    public  int indexOf(E o){
        for (int i =0;i<this.size;i++){
            if (elements[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o){
        this.ensureCapa();
        this.size++;
        elements[size - 1] = o;
        return true;
    }

    public E get(int i){
        if (i >=size || i<0){
            throw new IndexOutOfBoundsException("Index:" + i +" , size: " +this.size);
        }
        return (E) elements[i];
    }

    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }


}
