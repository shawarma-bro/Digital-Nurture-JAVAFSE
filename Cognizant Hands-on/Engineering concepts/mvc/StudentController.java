package mvc;

public class StudentController {
    Student model;
    StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudentName(String name) {
        model.name = name;
    }

    public void updateGrade(String grade) {
        model.grade = grade;
    }

    public void showStudentDetails() {
        view.displayStudentDetails(model);
    }
}
