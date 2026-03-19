package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects.
 * Supports adding tasks, finding by ID, and filtering by status.
 * Duplicate task IDs are not permitted.
 *
 * @author Howard Student
 */
public class TaskManager {

    private final Map<String, Task> tasks = new LinkedHashMap<>();

    /**
     * Adds a task to the manager.
     * Throws an exception if a task with the same ID already exists.
     *
     * @param task the Task to add
     * @throws IllegalArgumentException if the task ID is already present
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds and returns the task with the given ID.
     * Returns null if no matching task is found.
     *
     * @param taskId the ID to search for
     * @return the matching Task, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns all tasks whose status matches the given value.
     *
     * @param status the status to filter by
     * @return list of tasks with the specified status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}
