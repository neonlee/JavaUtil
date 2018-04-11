package Stack;

import DLinkedList.NodePositionList;
import java.util.Iterator;

public class NodeStack<E> implements Stack<E> {

    private NodePositionList<E> list;

    public NodeStack() {
        this.list = new NodePositionList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E top() {
        return list.get(list.size() - 1);
    }

    @Override
    public void push(E element) {
        list.addLast(element);
    }

    @Override
    public E pop() {
        E element = this.top();
        list.remove(element);
        return element;
    }

    @Override
    public Iterator<E> iterator() {
       return list.iterator();
    }

}
