package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        if (tasks.isEmpty()) {
            tasks.add(task);
        } else {
            for (Task t : tasks) {
                if (t.getPriority() > task.getPriority()) {
                    tasks.add(index, task);
                    break;
                } else if (index == tasks.size() - 1) {
                    tasks.add(task);
                    break;
                }
                index++;
            }
        }
    }

    public Task take() {
        return tasks.poll();
    }
}
