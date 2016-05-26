package com.beauti.experthp.bijnorbeautihub.DataBaseModel;

/**
 * Created by expert on 5/5/2016.
 */
public class BeautiSubServices {
    private  int  price,id,point_id,Service_id;;
    private String subService_Name;

    public BeautiSubServices(){}
    public BeautiSubServices(int price,String subService_Name) {
        this.price = price;
        this.subService_Name = subService_Name;
    }
    public int getPoint_id() {
        return this.point_id;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }

    public int getService_id() {
        return this.Service_id;
    }

    public void setService_id(int service_id) {
        Service_id = service_id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubService_Name() {
        return this.subService_Name;
    }

    public void setSubService_Name(String subService_Name) {
        this.subService_Name = subService_Name;
    }
}
