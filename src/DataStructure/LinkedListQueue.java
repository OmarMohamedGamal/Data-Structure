
package DataStructure;
public class LinkedListQueue<E extends Comparable<E>> implements Queue<E>{
    private SinglyLinkedList<E> LinkedList;
    LinkedListQueue(){
        LinkedList=new SinglyLinkedList<>();
    }
    @Override
    public void push(E data) {   //O(1)
        LinkedList.addBack(data);
    }
    @Override
    public E pop() {    //O(1)
        E ret=LinkedList.getFront();
        LinkedList.removeFront();
        return ret;
    }
    @Override
    public E top() {    //O(1)
        return LinkedList.getFront();
    }
    @Override
    public int size() {   //O(1)
        return LinkedList.size();
    }
    @Override
    public boolean isEmpty() {   //O(1)
        return LinkedList.isEmpty();
    }
}
