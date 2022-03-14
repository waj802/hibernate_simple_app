//public class Main {
//
//
//    public static void main(String[] args) {
//        Student s1 = new Student("Karol", "Malek", StudentCondition.NIEOBECNY, 2000, 15);
//        Student s2 = new Student("Michal", "Kulka", StudentCondition.NIEOBECNY, 2000, 0);
//        s1.print();
//        System.out.println();
//        System.out.println(s1.compare(s1, s2));
//        System.out.println();
//
//        Class c = new Class("Grupa01", 15);
//        c.addStudent(s1);
//        c.addStudent(s2);
//        System.out.println(s1);
//        System.out.println(c);
//        System.out.println();
//
//        c.addPoints(s1, 30);
//        System.out.println(c);
//        System.out.println();
//
//        c.getStudent(s2);
//        System.out.println(c);
//        System.out.println();
//        c.addStudent(s2);
//
//        c.changeCondiction(s1, StudentCondition.CHORY);
//        System.out.println(c);
//        System.out.println();
//
//        c.removePoints(s1, 20);
//        System.out.println(c);
//        System.out.println();
//
//        System.out.println(c.search("Malek"));
//        System.out.println();
//
//        System.out.println(c.searchPartial("Kul"));
//        System.out.println();
//
//        System.out.println(c.countByCondition(StudentCondition.CHORY));
//        System.out.println();
//
//        c.summary();
//        System.out.println();
//
//        System.out.println(c.sortByLastName());
//        System.out.println();
//
//        c.addPoints(s2, 100);
//        System.out.println(c.sortByPoints());
//        System.out.println();
//
//        System.out.println(c.max());
//        System.out.println();
//
//        ClassContainer classContainer = new ClassContainer();
//        classContainer.addClass(c.getNameOfGroup(), c.getMaxNumberOfStudents(), c);
//        System.out.println(classContainer);
//        System.out.println();
//
//        classContainer.removeClass(c.getNameOfGroup());
//        System.out.println(classContainer);
//        System.out.println();
//
//        classContainer.addClass(c.getNameOfGroup(), c.getMaxNumberOfStudents(), c);
//        Class c2 = new Class("Grupa02", 10);
//        classContainer.addClass(c2.getNameOfGroup(), c2.getMaxNumberOfStudents(), c2);
//        System.out.println(classContainer);
//        System.out.println(classContainer.findEmpty());
//        System.out.println();
//
//        classContainer.summary();
//
//    }
//}
