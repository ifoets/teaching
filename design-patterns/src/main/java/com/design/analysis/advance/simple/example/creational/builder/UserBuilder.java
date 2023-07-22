package com.design.analysis.advance.simple.example.creational.builder;

public class UserBuilder {
    public final String firstName;
    public final String lastName;
    public int age;
    public String phone;
    public String address;

    public UserBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }
    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }
    //Return the finally consrcuted User object
    public User build() {
        User user =  new User(new UserBuilder(firstName,lastName));
        validateUserObject(user);
        return user;
    }
    private void validateUserObject(User user) {
        //Do some basic validations to check
        //if user object does not break any assumption of system
    }
}

