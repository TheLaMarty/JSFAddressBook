package com.m.controllers;

import com.m.beans.Contact;
import com.m.repository.ContactService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean(name = "controller")
public class Controller {

    private List<Contact> contacts;
    private List<Contact> searchResult;
    private Contact newContact = new Contact();
    private int idDelete;
    private String searchString;
    private String message;

    @ManagedProperty("#{service}")
    private ContactService contactService;

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void init() {
        contacts = contactService.getContacts();
    }

    public Contact getNewContact() {
        return newContact;
    }

    public void setNewContact(Contact newContact) {
        this.newContact = newContact;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void createContact() {
        contactService.addContact(newContact);

    }

    public void searchContact() {
        contactService.searchContact(searchString);
    }

    public void deleteContact() {
        contactService.deleteContact(idDelete);
    }

    public int getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(int idDelete) {
        this.idDelete = idDelete;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getMessage() {

        message = contactService.getMessage();

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Contact> getSearchResult() {
        searchResult = contactService.getSearchResult();
        return searchResult;
    }

    public void setSearchResult(List<Contact> searchResult) {
        this.searchResult = searchResult;
    }

    public void updateContact() {

        for (Contact contact : contacts
                ) {
            contact.setEditable(false);
        }
    }
}
