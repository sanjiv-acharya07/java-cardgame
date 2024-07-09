

public class CDLLNode <T> {
    T data;
    CDLLNode<T> prev;
    CDLLNode<T> next;

    public CDLLNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public CDLLNode<T> getNext() {
        return next;
    }

    public CDLLNode<T> getPrev() {
        return prev;
    }
    public void setNext(CDLLNode<T> next) {
        this.next = next;

    }

    public void setPrev(CDLLNode<T> prev) {
        this.prev = prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }

}
