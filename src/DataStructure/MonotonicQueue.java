package DataStructure;
public class MonotonicQueue<E extends Comparable<E>> implements Queue<E>{
    ArrayQueue<E> monotonicQueue;
    Deque<E> minimums,maximums; 
    MonotonicQueue(){
        monotonicQueue = new ArrayQueue<>();
        minimums = new Deque<>();
        maximums = new Deque<>();
    }
    @Override
    public void push(E data) {   //AmortizedO(1)
        monotonicQueue.push(data);
        while(!maximums.isEmpty()&&data.compareTo(maximums.getBack())>0)
            maximums.popBack();
        maximums.pushBack(data);
        while(!minimums.isEmpty()&&data.compareTo(minimums.getBack())<0)
            minimums.popBack();
        minimums.pushBack(data);
    }
    @Override
    public E pop() {   //O(1)
        if(monotonicQueue.top().compareTo(maximums.getFront())==0)
            maximums.popFront();
        if(monotonicQueue.top().compareTo(minimums.getFront())==0)
            minimums.popFront();
        return monotonicQueue.pop();
    }
    @Override
    public E top() {   //O(1)
        return monotonicQueue.top();
    }
    @Override
    public int size() {   //O(1)
        return monotonicQueue.size();
    }
    @Override
    public boolean isEmpty() {   //O(1)
        return monotonicQueue.isEmpty();
    }
    public E getMin(){   //O(1)
        return minimums.getFront();
    }
    public E getMax(){   //O(1)
        return maximums.getFront();
    }
}