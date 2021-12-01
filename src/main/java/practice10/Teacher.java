package practice10;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements PropertyChangeListener {

    private List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new ArrayList<>();
    }

    public Teacher(int id, String name, int age, List<Klass> klassList) {
        super(id, name, age);
        classes = klassList;
        klassList.forEach(klass -> klass.addPropertyChangeListener(this));
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        if (classes.isEmpty()) {
            return super.introduce()+" I am a Teacher. I teach No Class.";
        }

        List<String> classNumberList = classes.stream().map(Klass::getNumber).map(String::valueOf).collect(Collectors.toList());

        return super.introduce()+" "+String.format("I am a Teacher. I teach Class %s.", String.join(", ", classNumberList));
    }

    public String introduceWith(Student student) {
        if (isTeaching(student)) {
            return super.introduce()+String.format(" I am a Teacher. I teach %s.", student.getName());
        }

        return super.introduce()+String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }

    public boolean isTeaching(Student student) {
        return classes.stream().anyMatch(klass -> klass.isIn(student));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("studentList")) {
            System.out.printf("I am %s. I know %s has joined Class %d.\n", getName(), evt.getNewValue(), ((Student)evt.getNewValue()).getKlass().getNumber());
        } else if (evt.getPropertyName().equals("leader")) {
            System.out.printf("I am %s. I know %s become Leader of Class %d.\n", getName(), evt.getNewValue(), ((Student)evt.getNewValue()).getKlass().getNumber());
        }
    }
}
