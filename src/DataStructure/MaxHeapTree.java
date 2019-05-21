package DataStructure;
public class MaxHeapTree<E extends Comparable<E>> extends AbstractHeapTree<E>{
    @Override
    protected boolean mustGoUp(E node, E parent) {  //O(1)
        return node.compareTo(parent)>0;
    }
}