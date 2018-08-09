package com.example.reversedList;

public class Main {
    public static void main(String args[]) {
        LinkedList tester = new LinkedList(new LinkedList.Node("a"));
        tester.append(new LinkedList.Node("b"));
        tester.append(new LinkedList.Node("c"));
        tester.append(new LinkedList.Node("d"));
        tester.append(new LinkedList.Node("e"));
        tester.append(new LinkedList.Node("f"));

        LinkedList reversed = tester.getReverseIterative();
        reversed.print();
        reversed.reverseRecursive();
        reversed.print();
        tester.reverseIterative();
        tester.print();
    }
}
