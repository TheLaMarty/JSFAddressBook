package com.m.repository;

import com.m.beans.Contact;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@Singleton
@ApplicationScoped
@ManagedBean(name = "service")
public class ContactService {

    private List<Contact> contacts = new ArrayList<>();
    private List<Contact> searchResult = new ArrayList<>();
    private int id = 1;
    private String message;

    public void addContact(Contact newContact) {
        newContact.setId(id++);
        contacts.add(newContact);
    }

    public void deleteContact(int idDelete) {
        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).getId() == idDelete) {
                contacts.remove(i);
            } else {
                message = "Contact with id " + idDelete + " does not exist";
            }
        }
    }

    public void searchContact(String searchString) {

        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).getFirstName().equals(searchString) /*|| contacts.get(i).getLastName().equals(searchString) || contacts.get(i).getCategory().equals(searchString) || contacts.get(i).getEmail().equals(searchString) || contacts.get(i).getPhone().equals(searchString) && contacts.get(i).getFirstName() != null*/) {

                searchResult.add(contacts.get(i));
            }

/*            } else {
                message = "No contact found";
            }*/

        }

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Contact> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Contact> searchResult) {
        this.searchResult = searchResult;
    }

    @PostConstruct
    public void createDB() {

        addContact(new Contact("Isabel", "Franzen", "isabel.franzen@bonniernews.com", "0735956852", "Work"));
        addContact(new Contact("Emelie", "Welander", "emelie.welander@bonniernews.com", "0735976832", "Work"));
        addContact(new Contact("Sofie", "Jensen", "sofie.jensen@bonniernews.com", "0730576894", "Work"));
        addContact(new Contact("Anna", "Jandler", "anna.jandler@bonniernews.com", "0765576743", "Work"));
    }

}
