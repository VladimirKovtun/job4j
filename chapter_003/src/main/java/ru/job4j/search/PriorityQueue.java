package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var index = 0;
        for (var t : tasks) {
            if (t.getPriority() > task.getPriority() || index == tasks.size() - 1) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
