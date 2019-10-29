package ru.job4j.list;

public class NodeCycle<E> {
    private E value;
    NodeCycle<E> next;

    public NodeCycle(E value) {
        this.value = value;
    }

    static boolean hasCycle(NodeCycle first) {
        boolean rst = false;
        NodeCycle outerLoopNode = first;
        int count = 0;
        while (outerLoopNode.next != null && !rst) {
            NodeCycle innerLoopNode = first;
            for (int i = 0; i <= count; i++) {
                if (outerLoopNode.next == innerLoopNode) {
                    rst = true;
                    break;
                }
                innerLoopNode = innerLoopNode.next;
            }
            outerLoopNode = outerLoopNode.next;
            count++;
        }
        return rst;
    }
}
