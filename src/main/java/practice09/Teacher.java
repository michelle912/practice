package practice09;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new ArrayList<>();
    }

    public Teacher(int id, String name, int age, List<Klass> klassList) {
        super(id, name, age);
        classes = klassList;
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

}
