import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    List<Student> students = new ArrayList<>();

    public StudentDAOImpl(){
        this.loadStudents();
    }
    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public List<String> getGmeetNames(Student student) {
        for(Student x:students){
            if(x.equals(student))
                return x.getGmeetnames();
        }
        return null;
    }

    @Override
    public Student getStudentByGmeetName(String gmeetName) {
        for(Student student:students){
            if(student.getGmeetnames().contains(gmeetName))
                return student;
        }
        return null;
    }
    public boolean loadStudents(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/mapping.csv"));
            reader.read();
            while (reader.ready()){
                String line = reader.readLine();
                String[] words = line.split(",");
                Student student = new Student();
                student.setName(words[0]);
                for(int i=0;i<words.length;i++)
                    student.getGmeetnames().add(words[i]);
                students.add(student);
            }
        }
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        return false;
    }
}
