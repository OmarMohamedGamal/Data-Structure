package DataStructure;
public class StackQueue<E> implements Queue<E>{
    private Stack<E> s1,s2;
    StackQueue() {
        s1=new ArrayListStack<>();
        s2=new ArrayListStack<>();
    }
    @Override
    public void push(E data) {   //O(1)
        s1.push(data);
    }
    @Override
    public E pop() {  //Amortized O(1)
        if(s2.isEmpty())
            while(!s1.isEmpty())
                s2.push(s1.pop());
        return s2.pop();
    }
    @Override
    public E top() {   //Amortized O(1)
        if(s2.isEmpty())
            while(!s1.isEmpty())
                s2.push(s1.pop());
        return s2.top();
    }
    @Override
    public int size() {   //O(1)
        return s1.size()+s2.size();
    }
    @Override
    public boolean isEmpty() {   //O(1)
        return s1.isEmpty()&&s2.isEmpty();
    }
}