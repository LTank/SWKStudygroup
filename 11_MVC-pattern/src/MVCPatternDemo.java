public class MVCPatternDemo {

    private static Student retriveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Henrik");
        student.setStudentID("27");
        student.setClassNo("DAT17V1");
        return student;
    }

    public static void main(String[] args) {

        //Get student record from the database
        Student model  = retriveStudentFromDatabase();

        //Create a view to write student details in console
        StudentView view = new StudentView();

        //Create a controller, to handle changes between view and model
        StudentController controller = new StudentController(model, view);

        //Update the view
        controller.showView();

        //Update data in model through controller
        controller.setStudentName("Tobias");
        controller.setStudentID("12");

        //Update the view again
        controller.showView();
    }
}