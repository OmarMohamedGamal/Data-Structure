
package DataStructure;
public class Deque<E>{
    private DoublyLinkedList<E> DoublyLinkedList;
    Deque(){
        DoublyLinkedList=new DoublyLinkedList<>();
    }
    public void pushFront(E data){   //O(1)
        DoublyLinkedList.addFront(data);
    }
    public void pushBack(E data){   //O(1)
        DoublyLinkedList.addBack(data);
    }
    public E popFront(){   //O(1)
        E ret=DoublyLinkedList.getFront();
        DoublyLinkedList.removeFront();
        return ret;
    }
    public E popBack(){   //O(1)
        E ret=DoublyLinkedList.getBack();
        DoublyLinkedList.removeBack();
        return ret;
    }
    public E getFront(){   //O(1)
        return DoublyLinkedList.getFront();
    }
    public E getBack(){   //O(1)
        return DoublyLinkedList.getBack();
    }
    public boolean isEmpty(){   //O(1)
        return DoublyLinkedList.isEmpty();
    }
    public int size(){   //O(1)
        return DoublyLinkedList.size();
    } 
    public E top(){   //O(1)
        return DoublyLinkedList.getFront();
    }
}