
package DataStructure;
public class ArrayStack<E> implements Stack<E> {
    private final static int CAPACITY=1000;
    private E[]array;
    private int size;
    ArrayStack(){
        this(CAPACITY); 
    }
    ArrayStack(int capacity){
        array=(E[]) new Object[capacity];
    }
    @Override
    public void push(E data) {   //O(1)
        if(size==array.length){
            throw new IllegalStateException("The Stack is Full");
        }
        array[size]=data;
        ++size;
    }
    @Override
    public E pop() {   //O(1)
        if(isEmpty())
            throw new IllegalStateException("Can't pop From EmptyStack");
        --size;
        return array[size]; 
    }
    @Override
    public E top() {   //O(1)
        return array[size-1];
    }
    @Override
    public boolean isEmpty() {   //O(1)
        return size==0;
    }
    @Override
    public int size() {   //O(1)
        return size;
    }
}