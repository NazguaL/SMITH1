package Lab04.Animals;

public class Animal {
    public String name;
    public int age;
    public static enum AnimalName {
        Eagle,
        Lion,
        Giraffe,
        Zebra;
    }

    public Animal (String name, int age) {
        this.name = name;
        this.age = age;
    }
}