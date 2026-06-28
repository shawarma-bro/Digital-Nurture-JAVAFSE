package mvc;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", 101, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.showStudentDetails();

        System.out.println("\nUpdating student info...\n");

        controller.updateStudentName("Alice Johnson");
        controller.updateGrade("A+");

        controller.showStudentDetails();
    }
}
