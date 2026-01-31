package com.demo4.demo4;

public class Student {
    private String firstname;
    private String lastname;

    public Student(){

    }

    public Student(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
