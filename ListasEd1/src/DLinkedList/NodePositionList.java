package DLinkedList;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NodePositionList<E> implements PositionList<E> {

    private int numElts;
    private final DNode<E> header, trailer;

    public NodePositionList() {
        numElts = 0;
        this.header = new DNode<>(null, null, null);
        this.trailer = new DNode<>(header, null, null);
        header.setNext(trailer);
    }

    protected DNode<E> checkPositionList(Position<E> p) throws Exception {
        if (p == null) {
            throw new Exception("Null position passed to NodeList");
        }

        if (p == header) {
            throw new Exception("the header not is not a valid positon");
        }

        if (p == trailer) {
            throw new Exception("the trailer not is not a valid positon");
        }

        try {
            DNode<E> temp = (DNode<E>) p;
            if ((temp.getPrev() == null) || (temp.getNext() == null)) {
                throw new Exception("position does not belong to a valid NodeList");
            }
            return temp;
        } catch (Exception e) {
            throw new Exception("position is of wrong type for this list");
        }
    }

    @Override
    public int size() {
        return numElts;
    }

    @Override
    public boolean isEmpty() {
        return numElts == 0;
    }

    @Override
    public Position<E> first() {
        return header.getNext();
    }

    @Override
    public Position<E> last() {
        return trailer.getPrev();
    }

    @Override
    public Position<E> next(Position<E> p) throws Exception {
        DNode<E> v = checkPositionList(p);
        DNode<E> next = v.getNext();

        if (next == header) {
            throw new Exception("Cannot advance past the beginning of the list");
        }
        return next;
    }

    @Override
    public Position<E> prev(Position<E> p) throws Exception {
        DNode<E> v = checkPositionList(p);
        DNode<E> prev = v.getPrev();

        if (prev == header) {
            throw new Exception("Cannot advance past the beginning of the list");
        }
        return prev;
    }

    @Override
    public void addFirst(E e) {
        numElts++;
        DNode<E> newNode = new DNode<>(header, header.getNext(), e);
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
    }

    @Override
    public void addLast(E e) {
        numElts++;
        DNode<E> newNode = new DNode<>(trailer, trailer.getNext(), e);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
    }

    @Override
    public void addAfter(Position<E> p, E e) throws Exception {
        DNode<E> v = checkPositionList(p);
        numElts++;
        DNode<E> newNode = new DNode<>(v, v.getNext(), e);
        v.getNext().setPrev(newNode);
        v.setNext(newNode);
    }

    @Override
    public void addBefore(Position<E> p, E e) throws Exception {
        DNode<E> v = checkPositionList(p);
        numElts++;
        DNode<E> newNode = new DNode<>(v.getPrev(), v, e);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
    }

    @Override
    public E remove(E p) {
        DNode<E> element = header.getNext();
        
        for (int i = 0; i < numElts; i++) {
            if (element.element().equals(p)) {
                break;
            }
            element = element.getNext();
        }
        
        DNode<E> v = null;
        try {
            v = checkPositionList(element);
        } catch (Exception ex) {
            Logger.getLogger(NodePositionList.class.getName()).log(Level.SEVERE, null, ex);
        }
        numElts--;
        DNode<E> vPrev = v.getPrev();
        DNode<E> vNext = v.getNext();

        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);

        E vElem = v.element();

        v.setNext(null);
        v.setPrev(null);

        return vElem;
    }

    @Override
    public E set(int i, E e) throws Exception {
        Position<E> p = element(i);
        DNode<E> v = checkPositionList(p);
        E oldElt = v.element();
        v.setElement(e);
        return oldElt;
    }

    @Override
    public Iterator<E> iterator() {
        return new IIt<>(this);

    }

    @Override
    public void add(E e) {

        DNode<E> element = element(numElts - 1);
        if (numElts == 0) {
            addFirst(e);
        } else {
            try {
                addAfter(element, e);
            } catch (Exception ex) {
                Logger.getLogger(NodePositionList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void add(int i, E e) {
        DNode<E> element = element(i);
        try {
            addAfter(element, e);
        } catch (Exception ex) {
            Logger.getLogger(NodePositionList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DNode<E> element(int i) {
        DNode<E> element = header.getNext();
        for (int j = 0; j < i; j++) {
            element = element.getNext();
        }
        return element;
    }

    @Override
    public E get(int i) {
        return element(i).element();
    }

    @Override
    public void remove(int i) {
        DNode<E> element = element(i);
        try {
            remove(element.element());
        } catch (Exception ex) {
            Logger.getLogger(NodePositionList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class IIt<E> implements Iterator<E> {

        private PositionList<E> list;
        private Position<E> cursor;

        public IIt(PositionList<E> list) {
            this.list = list;
            cursor = (list.isEmpty()) ? null : list.first();
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E toReturn = cursor.element();

            try {
                cursor = (cursor == list.last()) ? null : list.next(cursor);
            } catch (Exception ex) {
                Logger.getLogger(NodePositionList.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toReturn;
        }
    }

    public class DNode<E> implements Position<E> {

        private DNode<E> prev, next;
        private E element;

        public DNode(DNode<E> prev, DNode<E> next, E element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

        @Override
        public E element() {
            if ((prev == null) && (next == null)) {
                try {
                    throw new Exception("Position is not in a list");
                } catch (Exception ex) {
                    Logger.getLogger(DNode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return element;
        }

        public DNode<E> getPrev() {
            return prev;
        }

        public void setPrev(DNode<E> prev) {
            this.prev = prev;
        }

        public DNode<E> getNext() {
            return next;
        }

        public void setNext(DNode<E> next) {
            this.next = next;
        }

        public void setElement(E element) {
            this.element = element;
        }

    }

}
