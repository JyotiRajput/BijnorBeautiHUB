package com.beauti.experthp.bijnorbeautihub.Model;

/**
 * Created by expert on 5/5/2016.
 */
public class BeautyServices {
    private  String service_name;
    private int id;

    public BeautyServices(){}
    public BeautyServices(String service_name) {
        this.service_name = service_name;
    }
    public BeautyServices(String service_name, int id) {
        this.service_name = service_name;
        this.id = id;
    }

    public String getService_name() {
        return this.service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
