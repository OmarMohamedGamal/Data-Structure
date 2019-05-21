package DataStructure;
public class ArrayQueue<E> implements Queue<E>{
    private E []array;
    private int size,front,back;
    private static final int CAPACITY=1000;
    ArrayQueue(){
        this(CAPACITY);
    }
    ArrayQueue(int capacity){
        array =(E[]) new Object[capacity];
    }
    @Override
    public void push(E data) {       //O(1)
        if(size==array.length)
            throw new IllegalStateException("The Queue is Full");
        array[back]=data;
        back=(back+1)%array.length;
        ++size;
    }
    @Override
    public E pop() {      //O(1)
        if(isEmpty())
            throw new IllegalStateException("Can't pop From Empty Queue");
        E ret =array[front];
        front=(front+1)%array.length;
        --size;
        return ret;
    }
    @Override
    public E top() {     //O(1)
        return array[front];
    }
    @Override
    public int size() {    //O(1)
        return size;
    }
    @Override
    public boolean isEmpty() {    //O(1)
        return size==0;
    }
}