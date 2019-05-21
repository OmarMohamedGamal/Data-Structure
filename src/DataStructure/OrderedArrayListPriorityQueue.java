package DataStructure;
public class OrderedArrayListPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E>{
    private ArrayList<E> sortedArrayList;
    OrderedArrayListPriorityQueue() {
        sortedArrayList=new ArrayList<>();
    }
    @Override
    public void push(E data) {   //O(n)
        insertElement(data);
    }
    @Override
    public E pop() {        //O(1)
        return sortedArrayList.removeBack();
    }
    @Override
    public E front() {        //O(1)
        return sortedArrayList.get(size()-1);
    }
    @Override
    public boolean isEmpty() {        //O(1)
        return sortedArrayList.isEmpty();
    }
    @Override
    public int size() {        //O(1)
        return sortedArrayList.size();
    }
    public void insertElement(E data){   //O(n)
        sortedArrayList.addBack(data);
        int i = sortedArrayList.size()-2;
        while(i>=0&&sortedArrayList.get(i).compareTo(sortedArrayList.get(i+1))>0){
            E tmp= sortedArrayList.get(i);
            sortedArrayList.set(i, sortedArrayList.get(i+1));
            sortedArrayList.set(i+1, tmp);
            --i;
        }
    }
}