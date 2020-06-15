package Lab02;


import com.google.gson.*;

/**
 * Created by nazgual on 2/26/20.
 */
public class Lab02PersonEquals {
    public Lab02PersonEquals(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    private String name;
    private String surname;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lab02PersonEquals person = (Lab02PersonEquals) o;
        return this.age == person.age &&
               this.surname.equals(person.surname) &&
               this.name.equals(person.name);
    }

    public String toJson(Lab02PersonEquals personEquals) {
        Gson gson = new Gson();
        String json = gson.toJson(personEquals);
        return json;
    }

    public Lab02PersonEquals fromJson(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Lab02PersonEquals personEquals = gson.fromJson(json, Lab02PersonEquals.class);
        return personEquals;
    }
}
