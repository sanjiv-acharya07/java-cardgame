import java.util.Iterator;

public class CircularDoublyLinkedList <T> implements Iterable<T>{
    private CDLLNode<T> head;
    private int size;
    public CircularDoublyLinkedList() {
        this.head = null;
        this.size = 0;

    }
    public void insert(T element) {
        CDLLNode<T> newNode = new CDLLNode<>(element);
        if (isEmpty()) {
            head = newNode;
            head.setNext(head);

            head.setPrev(head);
        } else {

            newNode.setNext(head);

            newNode.setPrev(head.getPrev());
            head.getPrev().setNext(newNode);

            head.setPrev(newNode);
        }
        size++;
    }

    public CDLLNode<T> search(T data) {
        CDLLNode<T> current = head;
        if (isEmpty()) {
            return null;
        }
        do {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        } while (current != head);
        return null;

    }
    public void delete(CDLLNode<T> toDelete) {
        if (isEmpty() || toDelete == null) {
            return;
        }
        if (size == 1) {
            head = null;
            size = 0;
        } else {

            toDelete.getPrev().setNext(toDelete.getNext());

            toDelete.getNext().setPrev(toDelete.getPrev());
            if (toDelete == head) {
                head = toDelete.getNext();

            }
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<T>() {
            private CDLLNode<T> current = head;
            private boolean firstIteration = true;
            public boolean hasNext() {
                if (current == null || (!firstIteration && current == head)) {
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
                if (firstIteration) {
                    firstIteration = false;
                }
                return data;
            }
        };
        return iter;
    }

}
