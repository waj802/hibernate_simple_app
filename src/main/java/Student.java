import javax.persistence.*;


@Entity
@Table(name = "student_list")
public class Student implements Comparable{

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", length = 255, nullable = true, unique = false)
    private String firstName;

    @Column(name = "last_name", length = 255, nullable = true, unique = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private StudentCondition studentCondition;

    @Column(name = "year")
    private Integer yearOfBirth;

    @Column(name = "points")
    private double numberOfPoints;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Class cl;

    public Student() {
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public Student(String firstName, String lastName, StudentCondition studentCondition, Integer yearOfBirth, double numberOfPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.numberOfPoints = numberOfPoints;
    }

    public Student(String firstName, String lastName, StudentCondition studentCondition, Integer yearOfBirth, double numberOfPoints, Class cl) {
        this.cl = cl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.numberOfPoints = numberOfPoints;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentCondition=" + studentCondition +
                ", yearOfBirth=" + yearOfBirth +
                ", numberOfPoints=" + numberOfPoints +
                '}';
    }

    public void print(){
        System.out.println("Imie: " + firstName + "\nNazwisko: " + lastName + "\nStan studenta: " + studentCondition + "\nRok urodzenia: " + yearOfBirth + "\nLiczba punktow: " + numberOfPoints);
    }


    public boolean compare(Student s1, Student s2){
        if(s1.lastName.equals(s2.lastName)){
            System.out.println("Nazwiska studentow sa takie same!");
            return true;
        }
        else {
            System.out.println("Nazwiska studentow sa inne!");
            return false;
        }
    }

    public double getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(double numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setStudentCondition(StudentCondition studentCondition) {
        this.studentCondition = studentCondition;
    }

    public StudentCondition getStudentCondition() {
        return studentCondition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Class getCl() {
        return cl;
    }

    public void setCl(Class cl) {
        this.cl = cl;
    }

}
