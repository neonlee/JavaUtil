package LinkedListSimple;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedList<Tipo> implements IDuplaLinkedList<Tipo> {

    private Node<Tipo> inicio, fim;
    private int tamanho;

    public LinkedList() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void add(Tipo elemento) {
        Node<Tipo> NovoNo = new Node<>(elemento);
        if (inicio == null) {
            inicio = fim = NovoNo;
            tamanho++;
        } else {
            this.fim.setNext(NovoNo);
            fim = NovoNo;
            tamanho++;
        }
    }

    @Override
    public void add(int index, Tipo element) {
        Node<Tipo> NovoNo = new Node<>(element);
        Node<Tipo> no = inicio;
        if (index - 1 == 0) {
            this.add(element);
        } else if (index >= this.tamanho) {
            System.out.println("Indice passado de forma inexistente");
        } else if (index == this.tamanho) {
            this.addEnd(element);
        } else {
            for (int i = 0; i < index - 2; i++) {
                no = no.getNext();
            }
            NovoNo.setNext(no.getNext());
            no.setNext(NovoNo);
            tamanho++;
        }
    }

    @Override
    public void addBegin(Tipo elemento) {
        Node<Tipo> NovoNo = new Node<>(elemento);
        if (inicio == fim) {
            inicio = fim = NovoNo;
            tamanho++;
        } else {
            NovoNo.setNext(inicio);
            inicio = NovoNo;
            tamanho++;
        }

    }

    @Override
    public void addEnd(Tipo elemento) {
        Node<Tipo> NovoNo = new Node<>(elemento);
        if (inicio == null) {
            inicio = fim = NovoNo;
            tamanho++;
        } else {
            this.fim.setNext(NovoNo);
            fim = NovoNo;
            tamanho++;
        }
    }

    @Override
    public Tipo get(int index) {
        Node<Tipo> no = inicio;
        for (int i = 0; i < index; i++) {
            no = no.getNext();
        }
        return no.getElement();
    }

    @Override
    public boolean contains(Tipo element) {
        Node<Tipo> no = inicio;
        for (int i = 0; i <= tamanho; i++) {
            if (no.getElement().equals(element)) {
                return true;
            }
            no = no.getNext();
        }
        return false;
    }

    @Override
    public Tipo remove(int indice) {
        Node<Tipo> node = inicio;
        if (indice == 0) {
            removeBegin();
        } else {
            for (int i = 0; i <= indice - 1; i++) {
                if (i == indice - 1) {
                    node.setNext(node.getNext().getNext());
                }
                node = node.getNext();
            }
            tamanho--;
        }

        return (Tipo) node;
    }

    @Override
    public Tipo removeEnd() {
        Node<Tipo> no = inicio;
        if (inicio == fim) {
            inicio = fim = null;
            tamanho--;
        } else {
            for (int i = 0; i <= tamanho - 1; i++) {
                if (no.getNext() == fim) {
                    no.setNext(null);
                    fim = no;
                    tamanho--;
                    return (Tipo) no.getNext();
                }
                no = no.getNext();
            }

        }

        return null;
    }

    @Override
    public Tipo removeBegin() {
        Node<Tipo> no = inicio;
        if (inicio == fim) {
            inicio = fim = null;
            tamanho--;
        } else {
            inicio = inicio.getNext();
            tamanho--;
        }
        return (Tipo) no;
    }

    @Override
    public boolean remove(Tipo elemento) {
        Node<Tipo> no = inicio;
        if (elemento == inicio.getElement()) {
            this.removeBegin();
        } else if (elemento == fim.getElement()) {
            this.removeEnd();
        } else {
            for (int i = 0; i < tamanho; i++) {
                if (no.getElement().equals(elemento)) {
                    remove(i);
                    return true;
                }
                no = no.getNext();
            }
        }
        return false;
    }

    @Override
    public void clean() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public Iterator iterator() {
        return new IteradorListaEncadeada();
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;

    }

    private class IteradorListaEncadeada implements Iterator<Tipo> {

        private Node<Tipo> proximo;

        public IteradorListaEncadeada() {
            this.proximo = inicio;
        }

        @Override
        public boolean hasNext() {
            return proximo != null;
        }

        @Override
        public Tipo next() {
            Tipo elemento = this.proximo.getElement();
            this.proximo = this.proximo.getNext();
            return elemento;
        }

    }

//No da classe
    private class Node<Tipo> {

        private Tipo element;
        private Node next;

        public Node(Tipo element) {
            this.element = element;
        }

        public Node(Tipo element, Node prev) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Tipo getElement() {
            return element;
        }

        public void setElement(Tipo element) {
            this.element = element;
        }

    }
}
