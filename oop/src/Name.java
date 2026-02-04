import java.util.Comparator;

public class Name implements Comparator<Student> {



    @Override
    public int compare(Student o1, Student o2) {
        return o2.compareTo(o1);
    }
}
