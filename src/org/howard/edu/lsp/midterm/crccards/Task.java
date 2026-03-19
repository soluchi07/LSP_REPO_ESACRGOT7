package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task with an ID, description, and status.
 * Valid statuses are OPEN, IN_PROGRESS, and COMPLETE.
 *
 * @author Howard Student
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with the given ID and description.
     * Status defaults to "OPEN".
     *
     * @param taskId      unique identifier for the task
     * @param description brief description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task's unique ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current status of the task.
     *
     * @return the status string
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status. Must be one of OPEN, IN_PROGRESS, or COMPLETE.
     * Any other value sets the status to UNKNOWN.
     *
     * @param status the new status value
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation in the format: taskId description [status].
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
