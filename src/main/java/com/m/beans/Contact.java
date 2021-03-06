package com.m.beans;

public class Contact {

    private int id = 0;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String category;
    private boolean editable;

    public Contact() {

    }

    public Contact(String firstName, String lastName, String email, String phone, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {

        this.editable = editable;
    }

    public void editContact(Contact contact) {
        contact.setEditable(true);
    }
}
