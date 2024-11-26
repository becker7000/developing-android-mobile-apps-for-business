package mx.com.cst.mobile.mysimplelogin.models;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String pass;

    // Constructor
    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    // Método toString
    @Override
    public String toString() {
        return "User(name='" + name + "', pass='" + pass + "')";
    }
}

