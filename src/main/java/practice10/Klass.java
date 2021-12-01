package practice10;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;

    private Student leader;

    private List<Student> studentList;

    private PropertyChangeSupport support;

    public Klass(int number) {
        this.number = number;
        studentList = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public String getDisplayName() {
        return "Class "+number;
    }

    public void assignLeader(Student student) {
        if (!studentList.contains(student)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        support.firePropertyChange("leader", leader, student);
        leader = student;
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        support.firePropertyChange("studentList", this.studentList, student);
        studentList.add(student);
    }

    public boolean isIn(Student student) {
        return student.getKlass().getNumber() == number;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
