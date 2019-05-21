package DataStructure;
public class MonotonicStack<E extends Comparable<E> >implements Stack<E>{
    private ArrayListStack<E> monotonicStack,minimums,maximums;
    MonotonicStack(){
        monotonicStack=new ArrayListStack<>();
        minimums=new ArrayListStack<>();
        maximums=new ArrayListStack<>();
    }
    @Override
    public void push(E data) {   //O(1)
        monotonicStack.push(data);
        if(minimums.isEmpty()){
            minimums.push(data);
        }else if(data.compareTo(minimums.top())<=0){
            minimums.push(data);
        }
        if(maximums.isEmpty()){
            maximums.push(data);
        }else if(data.compareTo(maximums.top())>=0){
            maximums.push(data);
        }
    }
    public E getMax(){   //O(1)
        return maximums.top();
    }
    public E getMin(){   //O(1)
        return minimums.top();
    }
    @Override
    public E pop() {   //O(1)
        if(monotonicStack.top().compareTo(minimums.top())==0)
            minimums.pop();
        if(monotonicStack.top().compareTo(maximums.top())==0)
            maximums.pop();
        return monotonicStack.pop();
    }
    @Override
    public E top() {   //O(1)
        return monotonicStack.top();
    }
    @Override
    public boolean isEmpty() {   //O(1)
        return monotonicStack.isEmpty();
    }
    @Override
    public int size() {   //O(1)
        return monotonicStack.size();
    }
}