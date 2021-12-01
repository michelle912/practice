package practice10;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Klass klass = new Klass(2);
        LinkedList<Klass> linkedList = new LinkedList<Klass>();
        linkedList.add(klass);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        Student jerry = new Student(1, "Jerry", 8, new Klass(3));

        klass.appendMember(jerry);
        klass.assignLeader(jerry);
    }
}
