
package DataStructure;
public class DoublyLinkedList<E> {
    private int size;
    private Node <E> front,back; 
    DoublyLinkedList() { }
    DoublyLinkedList(E intialValue) {
        addFront(intialValue);}
    private static class Node<E>{
        private E data;
        private Node<E> next,prev;
        Node(){}
        Node(E data){
            this(data,null,null);
        }
        Node(E data,Node<E> next,Node<E> prev){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
        public E getData() {
            return data;
        }
        public void setData(E Data) {
            this.data = Data;
        }        
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public Node<E> getPrev() {
            return prev;
        }       
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
    public int size(){   //O(1)
        return size;
    }
    public boolean isEmpty(){   //O(1)
        return size==0;
    }
    public void addFront(E data){   //O(1)
        Node<E> newNode = new Node<>(data);
        if(isEmpty()){
            front=newNode;
            back=newNode;
            newNode.setData(data);
        }else{
            newNode.setNext(front);
            front.setPrev(newNode);
            front=newNode;
            }
       ++size;
    }
    public void removeFront(){   //O(1)
        if(isEmpty()){
            throw new IllegalStateException("Can't Remove From Empty List");
        }
        if(size==1){
            front=null;
            back=null;
        }
        else{
            front = front.getNext();
            front.setPrev(null);}
        --size;
    }
    public E getFront(){   //O(1)
        return front.getData();
    }
    public void addBack(E data){   //O(1)
        if(isEmpty())
            addFront(data);
        else{
            Node<E> newNode = new Node<>(data);
            newNode.setPrev(back);
            back.setNext(newNode);
            back=newNode;
            ++size;
        }
    }
    public void removeBack(){   //O(1)
        if(isEmpty())
            throw new IllegalStateException("Can't Remove From an Empty list");
        if(size==1){
            removeFront();
        }
        else{
            back=back.getPrev();
            back.setNext(null);
            --size;
        }
    }
    public E getBack(){   //O(1)
        return back.getData();
    }
    public void add(E data,int index){
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        if(index==0){
            addFront(data);
        }
        else if(index==size)
            addBack(data);
        else{
            Node<E> cur=front;
            for(int i=0;i<index;++i)
                cur=cur.getNext();
            Node<E> newNode=new Node<>(data,cur,cur.getPrev());
            cur.getPrev().setNext(newNode);
            cur.setPrev(newNode);
            ++size;
        }
    }
    public void remove(int index){   //O(N)
        if(isEmpty()){
            throw new IllegalStateException("Can't Remove From Empty List");
        }
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }else if(index==0){
         removeFront();
        }else if(index==size-1){
            removeBack();
        }else{
            Node<E> cur=front;
            for(int i=0;i<index;++i){
                cur=cur.getNext();
            }
            cur.getNext().setPrev(cur.getPrev());
            cur.getPrev().setNext(cur.getNext());
            --size;
        }
    }
    public E get(int index){    //O(N)
        if(index<0||index>=size)
            throw new IndexOutOfBoundsException();
        if(index==0)
            return getFront();
        else if(index==size-1)
            return getBack();
        else{
            Node<E> cur=front;
            for(int i=0;i<index;++i)
                cur=cur.getNext();
            return cur.getData();
        }
        
    }
}