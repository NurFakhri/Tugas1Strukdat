import java.util.LinkedList;
import java.util.Queue;

class queuePatient {
    private String name;
    private int age;

    public queuePatient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nage: " + age;
    }
}
