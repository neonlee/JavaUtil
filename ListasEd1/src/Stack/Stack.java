package Stack;

public interface Stack<E> extends Iterable<E>{

    public int size();

    public boolean isEmpty();

    public E top();

    public void push(E element);

    public E pop();
}
