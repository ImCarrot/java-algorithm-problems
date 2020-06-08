package com.aditya.personal.algorithmproblems.ctci.LinkedLists;

public class LoopDetection {


    public LinkedListNode<?> circularLinkedList(LinkedListNode<?> input) {

        if (input == null)
            return null;

        LinkedListNode<?> slowPointer = input;
        LinkedListNode<?> fastPointer = input;

        while (fastPointer != null && fastPointer.getNext() != null) {

            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext(); // doesn't throw since we're already checking for null at while

            // means they both are referring to the same node.
            if (fastPointer == slowPointer)
                break;
        }


        if (slowPointer != fastPointer)
            return null; // meaning not a circular LL

        LinkedListNode<?> dPointer = input;

        while(dPointer != slowPointer) {
            dPointer = dPointer.getNext();
            slowPointer = slowPointer.getNext();
        }

        return dPointer;
    }
// 110 668 243
}
