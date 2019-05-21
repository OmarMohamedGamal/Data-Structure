
package DataStructure;
public class LinkedListStack<E extends Comparable<E>>  implements Stack<E>  {
    private SinglyLinkedList<E> LinkedList;
    LinkedListStack() {
        LinkedList=new SinglyLinkedList<>();
    }
    @Override
    public void push(E data) {   //O(1)
        LinkedList.addFront(data);
    }
    @Override
    public E pop() {   //O(1)
        E ret = LinkedList.getFront();
        LinkedList.removeFront();
        return ret;
    }
    @Override
    public E top() {   //O(1)
        return LinkedList.getFront();
    }
    @Override
    public boolean isEmpty() {   //O(1)
        return LinkedList.isEmpty();
    }
    @Override
    public int size() {   //O(1)
        return LinkedList.size();
    }
}
