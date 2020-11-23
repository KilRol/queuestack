package com.kilrol.queuestack.model;

public class MyList<T> {

    Push<T> sq;

    public void setSq(Push<T> sq) {
        this.sq = sq;
        sq.setList(this);
    }

    public void push(T item) {
        sq.push(item);
    }

    public int getSize() {
        return size;
    }

    public T elementAt() {
        T info = currentNode.value;
        if (currentNode.next != null) currentNode = currentNode.next;
        return info;
    }

    public T getIndex(int index) {
        Node<T> cur = head;
        for (int i = 0; cur != null && i < index; i++, cur = cur.next) ;
        return cur.value;
    }

    protected class Node<T> {
        protected T value;
        protected Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    protected Node<T> head;
    protected int size;
    protected Node<T> currentNode;

    public MyList() {
        head = null;
        size = 0;
        currentNode = head;
    }

    public void add(T value) {
        Node<T> nodeToAdd = new Node<T>(value);
        if (head == null) {
            head = nodeToAdd;
            currentNode = head;
        } else {
            Node<T> cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = nodeToAdd;
            currentNode = nodeToAdd;
        }
        size++;
    }

    public void add_front(T value) {
        Node<T> nodeToAdd = new Node<T>(value);
        if (head == null) {
            head = nodeToAdd;
            currentNode = head;
        } else {
            nodeToAdd.next = head;
            head = nodeToAdd;
        }

        size++;
    }

    public T pop() {
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public String toString() {
        String out = "List";
        for (Node<T> i = this.head; i != null; i = i.next)
            out += i + " ";
        return out;
    }
}