public class Main {
    public static void main(String[] args){
        StudentDAO doa = new StudentDAOImpl();
        for(Student student : doa.getAllStudents()){
            System.out.println(student.getName());
        }
    }
}
