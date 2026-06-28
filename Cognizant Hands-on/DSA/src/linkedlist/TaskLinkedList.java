package linkedlist;

public class TaskLinkedList {
    Task head;

    public void addTask(Task t) {
        if (head == null) {
            head = t;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = t;
        }
        System.out.println("Task added: " + t.taskName);
    }

    public void searchTask(int id) {
        Task current = head;
        boolean found = false;

        while (current != null) {
            if (current.taskId == id) {
                System.out.println("Task found:");
                current.display();
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.taskId == id) {
            System.out.println("Task deleted: " + head.taskName);
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == id) {
                System.out.println("Task deleted: " + current.next.taskName);
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Task with ID " + id + " not found.");
    }

    public void traverse() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("--- All Tasks ---");
        Task current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }
}
