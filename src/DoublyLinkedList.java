import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{

    private LLNode<T> head;
    private LLNode<T> fakeHead;
    private int size;
    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    public LLNode<T> search(T data) {
        LLNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
        return null;


    }

    public void insert(T data) {
        LLNode<T> newNode = new LLNode<>(data);
        if (isEmpty()) {
            head = newNode;
            fakeHead = newNode;
        } else {
            fakeHead.setNext(newNode);
            newNode.setPrev(fakeHead);
            fakeHead = newNode;

        }
        size++;
    }

    public void delete(LLNode<T> toRemove) {
        if (toRemove == null || isEmpty()) {
            return;
        }
        if (toRemove.getPrev() != null) {
            toRemove.getPrev().setNext(toRemove.getNext());
        } else {
            head = toRemove.getNext();
        }
        if (toRemove.getNext() != null) {
            toRemove.getNext().setPrev(toRemove.getPrev());
        }
        size--;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<T>() {
            private LLNode<T> current = head;

            public boolean hasNext() {
                if (current == null) {
                    return false;
                }
                return true;
            }

            public T next() {
                if (!hasNext()) {
                    return null;
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
        return iter;
    }
}
