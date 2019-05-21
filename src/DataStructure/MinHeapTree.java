package DataStructure;
public class MinHeapTree<E extends Comparable<E>> extends AbstractHeapTree<E>{
    @Override
    protected boolean mustGoUp(E node, E parent) {  //O(1)
        return node.compareTo(parent)<0;
    }
}