package mvc;

public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student Details:");
        System.out.println("Name: " + student.name);
        System.out.println("Roll Number: " + student.rollNumber);
        System.out.println("Grade: " + student.grade);
    }
}
