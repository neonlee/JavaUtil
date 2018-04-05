package DLinkedList;

public interface PositionList<E> extends Iterable<E>{

    public int size();

    public boolean isEmpty();

    public Position<E> first();

    public Position<E> last();

    public Position<E> next(Position<E> p) throws Exception;

    public Position<E> prev(Position<E> p) throws Exception;

    public void addFirst(E e);

    public void addLast(E e);
    
    public void add(int i, E e);
    
    public void add(E e);

    public void addAfter(Position<E> p, E e) throws Exception;
    
    public void addBefore(Position<E> p, E e) throws Exception;
    
    public E remove(E p) throws Exception;
    
    public void remove(int i);
    
    public E set(int i, E e) throws Exception;
    
    public E get(int i);

}
