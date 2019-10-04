package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            for (Task t : tasks) {
                if (t.getPriority() > task.getPriority()) {
                    tasks.add(tasks.indexOf(t), task);
                    break;
                } else if (tasks.indexOf(t) == tasks.size() - 1) {
                    tasks.add(task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return tasks.poll();
    }
}
