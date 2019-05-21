package DataStructure;
public class ArrayListStack<E> implements Stack<E>{
    private ArrayList<E> array;
    ArrayListStack(){
        array=new ArrayList<>();
    }
    ArrayListStack(int intialCapacity){
        array =new ArrayList<>(intialCapacity);
    }
    @Override
    public void push(E data) {   //O(1)
        array.addBack(data);
    }
    @Override
    public E pop() {   //O(1)
        E ret =array.get(array.size()-1);
        array.removeBack();
        return ret;
    }
    @Override
    public E top() {   //O(1)
        return array.get(array.size()-1);
    }
    @Override
    public boolean isEmpty() {   //O(1)
        return array.isEmpty();
    }   
    @Override
    public int size() {   //O(1)
        return array.size();
    }
}