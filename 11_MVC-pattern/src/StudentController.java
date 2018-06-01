public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name){
        model.setName(name);
    }

    public String getStudentName(){
        return model.getName();
    }

    public void setStudentID(String studentID){
        model.setStudentID(studentID);
    }

    public String getStudentID(){
        return model.getStudentID();
    }

    public void setStudentClass(String studentClass){
        model.setClassNo(studentClass);
    }

    public String getStudentClass(){
        return model.getClassNo();
    }

    public void showView(){
        view.printStudentDetails(model.getName(), model.getStudentID(), model.getClassNo());
    }
}