package com.beauti.experthp.bijnorbeautihub.Model;

/**
 * Created by expert on 5/5/2016.
 */
public class BeautiPoints {
    private String name,contact,address;
    private int image,id;

    public BeautiPoints(){}
    public BeautiPoints(String name){
        this.name=name;
    }
    public BeautiPoints(String name, String contact, int image,String address) {
        this.name = name;
        this.contact = contact;
        this.image = image;
        this.address=address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;

    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {

        this.name = name;
    }
}
