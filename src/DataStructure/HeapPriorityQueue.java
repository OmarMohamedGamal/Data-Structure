package DataStructure;
public class HeapPriorityQueue<E extends Comparable<E>>implements PriorityQueue<E>{
    private MaxHeapTree<E> maxHeapTree;
    HeapPriorityQueue(){
        maxHeapTree=new MaxHeapTree<>();
    }
    @Override
    public void push(E data) {    //O(log(n))
        maxHeapTree.push(data);
    }
    @Override
    public E pop() {    //O(log(n))
        return maxHeapTree.pop();
    }
    @Override
    public E front() {  //O(1)
        return maxHeapTree.top();
    }
    @Override
    public boolean isEmpty() {  //O(1)
        return maxHeapTree.isEmpty();
    }
    @Override
    public int size() {  //O(1)
        return maxHeapTree.size();
    }   
}