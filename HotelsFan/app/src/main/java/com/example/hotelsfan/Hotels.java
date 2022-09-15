package com.example.hotelsfan;

public class Hotels {
    private String id,title,spot,image,text,services_type,status,created_at,updated_at;

    public Hotels(){

    }

    public Hotels(String id, String title, String spot, String image, String text, String services_type, String status, String created_at, String updated_at) {
        this.id = id;
        this.title = title;
        this.spot = spot;
        this.image = image;
        this.text = text;
        this.services_type = services_type;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSpot() {
        return spot;
    }

    public String getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public String getServices_type() {
        return services_type;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setServices_type(String services_type) {
        this.services_type = services_type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
