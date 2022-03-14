import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClassGUI {

    private static JTextField textFirstName;
    private static JTextField textLastName;
    static ClassContainer classContainer = new ClassContainer();

    public static void main(String[] args) {
        DbController db = new DbController();

        JTable table = new JTable();
        Object[] colums = {"Group Name", "Max Student Number"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("Class manager");
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100, 100, 690, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        // border layout, flow layout, grid layout

        model.setColumnIdentifiers(colums);
        table.setModel(model);

        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setSelectionBackground(Color.lightGray);
        table.setGridColor(Color.lightGray);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.lightGray);
        pane.setBackground(Color.white);
        pane.setBounds(10, 10, 650, 350);
        frame.getContentPane().add(pane);

        textFirstName = new JTextField();
        textFirstName.setBounds(220, 375, 180, 35);
        frame.getContentPane().add(textFirstName);
        textFirstName.setColumns(10);

        textLastName = new JTextField();
        textLastName.setBounds(220, 420, 180, 35);
        frame.getContentPane().add(textLastName);
        textLastName.setColumns(10);

        JLabel lblGroupName = new JLabel("Group Name");
        lblGroupName.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblGroupName.setForeground(Color.white);
        lblGroupName.setBounds(10, 385, 250, 20);
        frame.getContentPane().add(lblGroupName);

        JLabel lblMaxStudents = new JLabel("Max Students Number");
        lblMaxStudents.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblMaxStudents.setForeground(Color.white);
        lblMaxStudents.setBounds(10, 430, 250, 20);
        frame.getContentPane().add(lblMaxStudents);

        Object[] row = new Object[2];

        List<Class> cL = db.selectAllGroups();
        for (Class cTest : cL){
            row[0] = cTest.getNameOfGroup();
            row[1] = cTest.getMaxNumberOfStudents();
            classContainer.addClass(cTest.getNameOfGroup(), cTest.getMaxNumberOfStudents(), cTest, cTest.getId());
            model.addRow(row);
        }
//        db.selectAllStudents();




        for (var cl : classContainer.getMap().entrySet()) {
            System.out.println(cl.getKey() + " --- " + cl.getValue().getMaxNumberOfStudents());
        }

//        Student s1 = new Student("Karol", "Malek", StudentCondition.NIEOBECNY, 2000, 15);
//        Student s2 = new Student("Michal", "Kulka", StudentCondition.NIEOBECNY, 2000, 0);
//        Student s3 = new Student("Andrzej", "Kowalski", StudentCondition.CHORY, 1999, 100);
////        db.addNewStudent(s1);
////        db.addNewStudent(s2);
////        db.addNewStudent(s3);
//        Class c = new Class("Grupa01", 5);
//        c.addStudent(s1);
//        c.addStudent(s2);
//        c.addStudent(s3);

//        row[0] = c.getNameOfGroup();
//        row[1] = c.getMaxNumberOfStudents();
//        classContainer.addClass(c.getNameOfGroup(), c.getMaxNumberOfStudents(), c);
//        model.addRow(row);

//        Student s21 = new Student("Antek", "Wilk", StudentCondition.NIEOBECNY, 1997, 65);
//        Student s22 = new Student("Jakub", "Pilka", StudentCondition.ODRABIAJACY, 1998, 40);
//        Student s23 = new Student("Anna", "Janowska", StudentCondition.CHORY, 1997, 45);
//        Class c2 = new Class("Grupa02", 10);
//        c2.addStudent(s21);
//        c2.addStudent(s22);
//        c2.addStudent(s23);
//
//        row[0] = c2.getNameOfGroup();
//        row[1] = c2.getMaxNumberOfStudents();
//        classContainer.addClass(c2.getNameOfGroup(), c2.getMaxNumberOfStudents(), c2);
//        model.addRow(row);

        JButton btnAdd = new JButton("ADD");
        btnAdd.setBounds(10, 465, 317, 35);
        frame.getContentPane().add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                row[0] = textFirstName.getText();
                row[1] = textLastName.getText();

                Class newClass = new Class(textFirstName.getText(), Double.parseDouble(textLastName.getText()));
                classContainer.addClass(newClass.getNameOfGroup(), newClass.getMaxNumberOfStudents(), newClass, newClass.getId());
                System.out.println(classContainer);
//                DbController.selectAllGroups(classContainer);
                db.addNewGroup(newClass);
                db.selectAllGroups();
//                db.selectAllGroups();

                model.addRow(row);

                textFirstName.setText("");
                textLastName.setText("");
            }
        });

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(342, 465, 317, 35);
        frame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String nameOfGroup = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
//                    System.out.println(classContainer.getClassByName(nameOfGroup));
                    db.deleteGroup(classContainer.getClassByName(nameOfGroup));
                    classContainer.removeClass(nameOfGroup);

                    model.removeRow(i);
                } else {
                    JOptionPane.showMessageDialog(frame, "Delete Error");
                }
            }
        });

        JButton btnOpen = new JButton("OPEN");
        btnOpen.setBounds(10, 515,650, 35);
        frame.getContentPane().add(btnOpen);
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameOfGroup = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
                System.out.println("name of group: " + nameOfGroup);
                StudentListGUIPage studentList = new StudentListGUIPage(nameOfGroup);
            }
        });

        frame.setResizable(false);
        frame.setVisible(true);

    }

}
