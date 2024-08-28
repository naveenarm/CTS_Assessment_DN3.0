class Task {
    int taskId;
    String taskName;
    boolean status;

    public Task(int taskId, String taskName, boolean status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

class LinkedList {
    Node head;

    class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Method to add a task to the linked list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next!= null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to search for a task by taskId
    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp!= null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to traverse the linked list and print all tasks
    public void traverseTasks() {
        Node temp = head;
        while (temp!= null) {
            System.out.println("Task Id: " + temp.task.taskId + ", Task Name: " + temp.task.taskName + ", Status: " + temp.task.status);
            temp = temp.next;
        }
    }

    // Method to delete a task by taskId
    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next!= null) {
            if (temp.next.task.taskId == taskId) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        LinkedList taskList = new LinkedList();

        // Add tasks
        taskList.addTask(new Task(1, "Task 1", true));
        taskList.addTask(new Task(2, "Task 2", false));
        taskList.addTask(new Task(3, "Task 3", true));

        // Traverse tasks
        taskList.traverseTasks();

        // Search for a task
        Task task = taskList.searchTask(2);
        if (task!= null) {
            System.out.println("Task found: " + task.taskName);
        } else {
            System.out.println("Task not found");
        }

        // Delete a task
        taskList.deleteTask(2);

        // Traverse tasks after deletion
        taskList.traverseTasks();
    }
}