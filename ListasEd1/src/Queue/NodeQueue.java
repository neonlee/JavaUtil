package Queue;

import DLinkedList.NodePositionList;

public class NodeQueue<E> implements Queue<E> {

    private NodePositionList<E> list;

    public NodeQueue() {
        this.list = new NodePositionList<>();
    }

    @Override
    public void enqueue(E elemento) {
        this.list.addFirst(elemento);
    }

    @Override
    public E dequeue() {
        this.list.remove(0);
        return list.get(0);
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
    public E front() {
        return list.get(0);
    }

}
