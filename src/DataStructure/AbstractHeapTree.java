package DataStructure;
abstract public class AbstractHeapTree<E extends Comparable<E>> {
 private ArrayList<E> tree; 
 AbstractHeapTree(){
     tree=new ArrayList<>();
 }
 abstract protected boolean mustGoUp(E node,E parent);
 public E top(){     //O(1)
     return tree.get(0);
 }
 public void push(E data){   //O(log(N))
     tree.addBack(data);
     heapifyUp(tree.size()-1);
 }
 public E pop(){   //O(log(N))
     E tmp = tree.get(0);
     swap(0, tree.size()-1);
     tree.removeBack();
     heapifyDown(0);
     return tmp;
 }
 public int size(){   //O(1)
     return tree.size();
 }
 public boolean isEmpty(){   //O(1)
     return tree.isEmpty();
 }
 private int leftChild(int i){   //O(1)
     return 2*i+1;
 }
 private int rightChild(int i){   //O(1)
     return 2*i+2;
 }
 private int parent(int i){   //O(1)
     return (i-1)/2;
 }
 private boolean hasParent(int i){   //O(1)
     return i != 0;
 }
 private boolean hasLeft(int i){  //O(1)
     return leftChild(i)<tree.size();
 }
 private boolean hasRight(int i){  //O(1)
     return rightChild(i)<tree.size();
 }
 private void heapifyUp(int i){   //O(log(n))
     if(!hasParent(i)||!mustGoUp(tree.get(i),tree.get(parent(i))))
         return;
     swap(i,parent(i));
     heapifyUp(parent(i));
 }
 private void swap(int i,int j){    //O(1)
     E tmp = tree.get(i);
     tree.set(i, tree.get(j));
     tree.set(j, tmp);
 }
 private void heapifyDown(int i){   //O(log(N))
     if(!hasLeft(i)) return;
     if(!hasRight(i)){
         if(mustGoUp(tree.get(leftChild(i)),tree.get(i))){
             swap(leftChild(i),i);}
         return;
     }
     if(mustGoUp(tree.get(leftChild(i)),tree.get(rightChild(i) ))){
         if(mustGoUp(tree.get(leftChild(i)),tree.get(i))){
             swap(leftChild(i),i);
             heapifyDown(leftChild(i));
         }}else{
             if(mustGoUp(tree.get(rightChild(i)), tree.get(i))){
                 swap(rightChild(i),i);
                 heapifyDown(rightChild(i));
             }
         }
     }
 }
