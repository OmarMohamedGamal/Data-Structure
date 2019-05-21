package DataStructure;
public class SinglyLinkedList<E extends Comparable<E>> {
    private static class Node<E>{
      private  E data;
      private  Node <E> next ; 
      Node (){}
      Node(E data){
        this(data,null);        
      }
      Node(E data , Node<E> next){
          this.data = data;
          this.next =next;
      }
        public E getData() {
            return data;
        } 
        public void setData(E data) {
            this.data = data;
        }
        public Node <E> getNext() {
            return next;
        }
        public void setNext(Node <E> next) {
            this.next = next;
        }            
    }
    private Node<E> front , back;
    private int size;
    SinglyLinkedList() {}
    SinglyLinkedList(E initialValue) {
        addFront(initialValue);
    }
    public void addFront(E data){   //O(1)
       Node<E> newNode = new Node<>(data,front);
       front = newNode;
       if(size==0) back=newNode;
        ++size;
    }
    public int size(){   //O(1)
        return this.size;
    }
    public E getFront(){   //O(1)
        if(isEmpty())
            throw new IllegalStateException("Can't get Front of an Empty List.");
        return front.getData();
    }
    public void removeFront(){   //O(1)
        if(isEmpty())
            throw new IllegalStateException("Can't Remove from an Empty List.");
        if(size == 1){
            front = null;
            back = null;
        }
        else{
        front= front.getNext();
        }
        --size;
    }
    public boolean isEmpty(){   //O(1)
        return size==0;
    }
    public void add(E data, int index){   //O(N)
        if(index<0 ||index>size)
            throw new IndexOutOfBoundsException();
        if(index==0) 
            addFront(data);
        else if(index==size)
            addBack(data);
        else{
            Node<E> cur = front;
            for (int i = 0; i < index-1; ++i) {
                cur = cur.getNext();
            }
            Node <E> newNode = new Node(data,cur.getNext());
            cur.setNext(newNode);
            ++size;
        } 
            
    
    }
    public void remove(int index){   //O(N)
        if(index<0 ||index>=size)
            throw new IndexOutOfBoundsException(); 
        if(index==0) 
            removeFront();
        else if(index==size-1)
            removeBack();
        else{
            Node<E> cur=front;
            for(int i=0;i<index-1;++i)
                cur= cur.getNext();
            cur.setNext(cur.getNext().getNext());
            --size;
        }
    }
    public E get (int index){   //O(N)
        if(index < 0 || index>=size)
            throw new IndexOutOfBoundsException();
        if(index==0)
           return getFront();
        else if(index == size - 1)
            return getBack();
        else{
            Node<E>cur=front;
            for(int i=0 ; i<index ; ++i){
                cur=cur.getNext();
            }
            return cur.getData();
        }
    }
    public void clear(){   //O(1)
        front=null;
        back= null;
        size=0;
    }
    public void sort(){   //O(N^2)
       for(int i=0;i<size-1;++i){
           Node<E>cur=front;
           for(int j=0;j<size-i-1;++j){
               if(cur.getData().compareTo(cur.getNext().getData())>0){
                   E tmp=cur.getData();
                   cur.setData(cur.getNext().getData());
                   cur.getNext().setData(tmp);  
               }
                cur=cur.getNext();
           }}
    }
    public int find(E data){   //O(N)
        if(isEmpty())
            throw new IllegalStateException("List is Empty.");
        if(data.compareTo(front.getData())==0){
            return 0;}
        else if(data.compareTo(back.getData())==0){
            return size-1; }
        else{
            int x=-1;
            Node<E> cur=front;
            for(int i=1;i<size;++i){
                cur=cur.getNext();
                if(data.compareTo(cur.getData())==0)
                    x=i;
        }
            if(x==-1){
                System.out.println("Data not Found");
            }
            return x;
    } }
    public void addBack(E data){   //O(1)
        if(size==0){
            addFront(data);
        }else{
            Node<E> newNode = new Node(data);
            back.setNext(newNode);
            back=newNode;
            ++size;}
    }
    public void removeBack(){   //O(N)
        if(size<2){
            removeFront();
        }else{
        Node<E> cur=front;
        for(int i=0;i<size-2;++i)
            cur=cur.getNext();
        cur.setNext(null);
        back=cur;
        --size;
        }
    }
    public E getBack(){   //O(1)
        if(isEmpty())
            throw new IllegalStateException();
        return back.getData();
    }   
}