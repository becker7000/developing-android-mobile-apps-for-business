package mx.ipn.cic.activitynavigationexample;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String name;
    private String lastname;
    private int age;

    public UserDTO() {
    }

    public UserDTO(String name,
                   String lastname,
                   int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return String.format("%s %s", this.name, this.lastname);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}