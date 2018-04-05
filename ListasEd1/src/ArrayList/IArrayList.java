package ArrayList;

import java.util.Iterator;

public interface IArrayList<E> extends Iterable<E>{

    public int size();

    public boolean add(E e);
    
    public void clear();
    
    public boolean contains(E element);
    
    public boolean remove(E element);
    
    public boolean isEmpty();

    public void add(int i, E e) throws IndexOutOfBoundsException;

    public E get(int i) throws IndexOutOfBoundsException;

    public E remove(int i) throws IndexOutOfBoundsException;

    public E set(int i, E e) throws IndexOutOfBoundsException;
    
    public Iterator<E> iterator();

}
