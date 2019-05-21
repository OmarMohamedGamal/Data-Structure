package DataStructure;
public class ArrayList<E> implements List<E>{
    private E []array;
    private int size;
    private final static int CAPACITY=1000;
    ArrayList(){
        this(CAPACITY);
    }
    ArrayList(int capacity){
        array=(E[]) new Object[capacity];
    }
    private void resize(int newCapacity){ //O(N)       
        E[] tempArray=(E[])new Object[newCapacity];
        for(int i =0;i<newCapacity;++i)
            tempArray[i]=array[i];
        array=tempArray;
    }
    

    @Override
    public E get(int index) {    //O(1)
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public void addBack(E data) {   //Amortized O(1)
        if(size == array.length)
            resize(2*array.length);
        array[size++] = data;
    }

    @Override
    public E removeBack() {   //O(1)
        if(isEmpty())
            throw new IllegalStateException();
        return array[--size];
    }

    @Override
    public int size() {   //O(1)
        return size;
    }

    @Override
    public boolean isEmpty() {    //O(1)
        return size==0;
    }
    public void set(int index,E data){  //O(1)
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        if(index==size)
            addBack(data);
        array[index]=data;
    }
    
}