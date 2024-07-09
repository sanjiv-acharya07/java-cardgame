

public class LLNode <T>{
    T data;
    LLNode<T> prev;
    LLNode<T> next;

    public LLNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    //should return the data stored in the node
    public T getData() {
        return data;
    }

    public LLNode<T> getNext() {
        return next;
    }

    public LLNode<T> getPrev() {
        return prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(LLNode<T> next) {
        this.next = next;
    }

    public void setPrev(LLNode<T> prev) {
        this.prev = prev;
    }
}
