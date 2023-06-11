import java.util.Stack;

class stackPatient {
    private String name;
    private int age;

    public stackPatient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getage() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nage: " + age;
    }
}