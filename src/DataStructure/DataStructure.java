package DataStructure;
public class DataStructure {
    public static void main(String[] args) {
        OrderedArrayListPriorityQueue<Integer> a=new OrderedArrayListPriorityQueue<>();
        a.push(2);
        a.push(3);
        System.out.println(a.pop());
        a.push(5);
        a.push(7);
        a.push(8);
        a.push(9);
        a.push(20);
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println(a.front());
    }
} 