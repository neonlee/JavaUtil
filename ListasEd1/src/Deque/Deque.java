package Deque;

public interface Deque<E> extends Iterable<E>{

    public int size();

    public boolean isEmpty();

    public E getFirst();

    public E getLast();

    public void addFirst();

    public void addLast();

    public E removeLast();

    public E removeFirst();

}
