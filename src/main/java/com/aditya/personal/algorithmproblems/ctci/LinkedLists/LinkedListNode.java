package com.aditya.personal.algorithmproblems.ctci.LinkedLists;

public class LinkedListNode<T> {


    public LinkedListNode() {

    }

    public LinkedListNode(T data) {
        this.data = data;
    }

    private T data;

    private LinkedListNode<T> next;

    public T getData() {
        return this.data;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode<T> nextNode) {
        this.next = nextNode;
    }


}
