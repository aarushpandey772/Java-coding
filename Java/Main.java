import student.Student;
import faculty.Faculty;

public class Main {

    public static void main(String[] args) {

        Student s = new Student();
        Faculty f = new Faculty();

        s.display();
        System.out.println();
        f.display();
    }
}