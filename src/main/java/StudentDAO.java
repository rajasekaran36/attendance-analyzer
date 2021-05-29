import java.util.List;

public interface StudentDAO {
    public List<Student> getAllStudents();
    public List<String> getGmeetNames(Student student);
    public Student getStudentByGmeetName(String gmeetName);
}
