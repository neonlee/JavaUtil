package Queue;

public interface Queue<E> {

    public void enqueue(E elemento);

    public E dequeue();

    public int size();

    public boolean isEmpty();

    public E front();

}
