import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String regno;
    private String rollno;
    private String name;
    private List<String> gmeetnames;
    public Student(){
        this.id = -1;
        this.regno = "no reg";
        this.rollno = "no roll";
        this.name = "no name";
        this.gmeetnames = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGmeetnames() {
        return gmeetnames;
    }

    public void setGmeetname(List<String> gmeetnames) {
        this.gmeetnames = gmeetnames;
    }
}