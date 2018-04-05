package ArrayList;

import java.util.Iterator;

public class ArrayList<E> implements IArrayList<E> {

    private E[] A;
    private int capacity = 16;
    private int size = 0;

    public ArrayList() {
        this.A = (E[]) new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.A = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public void clear() {
        A = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {

        if (size == capacity) {
            capacity *= 2;

            E[] B = (E[]) new Object[capacity];
            for (int j = 0; j < size; j++) {
                B[j] = A[j];
                A = B;
            }
        }

        for (int j = i; j < size - 1; j++) {
            A[j + 1] = A[j];
        }
        A[i] = e;
        size++;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        return A[i];
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {

        E temp = A[i];

        for (int j = i; j < size - 1; j++) {
            A[i] = A[i + 1];
        }
        size--;
        return temp;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        E element = A[i];
        A[i] = e;
        return element;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (this.A[i].equals(element)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean remove(E element) {

        for (int i = 0; i < size; i++) {
            if (this.A[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new iterator();
    }

    private class iterator<E> implements Iterator<E> {

        private int count;

        @Override
        public boolean hasNext() {
            return count < size();
        }

        @Override
        public E next() {
            return (E) A[count++];
        }

    }
}
