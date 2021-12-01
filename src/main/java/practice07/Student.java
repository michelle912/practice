package practice07;


public class Student extends Person {

    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {

        if (klass != null && this.equals(klass.getLeader())) {
            return super.introduce()+" "+String.format("I am a Student. I am Leader of Class %d.", klass.getNumber());
        }

        return super.introduce()+" "+String.format("I am a Student. I am at Class %d.", klass.getNumber());
    }
}
