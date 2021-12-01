package practice05;

public class Teacher extends Person {

    private Integer klass;

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
        this.klass = null;
    }

    public Integer getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        if (klass == null) {
            return super.introduce()+" I am a Teacher. I teach No Class.";
        }

        return super.introduce()+" "+String.format("I am a Teacher. I teach Class %d.", klass);
    }

}
