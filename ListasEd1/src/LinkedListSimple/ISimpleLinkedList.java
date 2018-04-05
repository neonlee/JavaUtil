package LinkedListSimple;

interface IDuplaLinkedList<Tipo> extends Iterable<Tipo>{
    public void add(Tipo element);

    public void add(int index, Tipo element);
    
    public void addBegin(Tipo element);
    
    public void addEnd(Tipo element);
    
    public Tipo get(int index);
    
    public boolean contains(Tipo element);

    public Tipo remove(int index);

    public boolean remove(Tipo element);
    
    public Tipo removeBegin();
    
    public Tipo removeEnd();
    
    public boolean isEmpty();

    public int size();

    public void clean();
    
}
