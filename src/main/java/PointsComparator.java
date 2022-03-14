import java.util.Comparator;

public class PointsComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getNumberOfPoints() < o2.getNumberOfPoints()) return -1;
        if (o1.getNumberOfPoints() > o2.getNumberOfPoints()) return 1;
        return 0;
    }
}
