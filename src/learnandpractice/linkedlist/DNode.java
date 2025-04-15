package learnandpractice.linkedlist;

public class DNode {
    public int data;
    public DNode next;
    public DNode back;

    public DNode(int d) {
        this.data = d;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getBack() {
        return back;
    }

    public void setBack(DNode back) {
        this.back = back;
    }
}
