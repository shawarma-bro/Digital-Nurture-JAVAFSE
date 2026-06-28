package linkedlist;

public class Main {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Write Code", "In Progress"));
        list.addTask(new Task(3, "Test App", "Pending"));
        list.addTask(new Task(4, "Deploy", "Not Started"));

        System.out.println();
        list.traverse();

        System.out.println();
        list.searchTask(2);

        System.out.println();
        list.searchTask(99);

        System.out.println();
        list.deleteTask(1);
        list.deleteTask(3);
        list.traverse();
    }
}
