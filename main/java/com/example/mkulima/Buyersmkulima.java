package com.example.mkulima;


public class Buyersmkulima {
    public String Id;
    public String firstname;
    public String lastname;
    public String email;
    public String phone;
    public String county;
    public String category;
    public String uuzaji;
    public String kununua;
    public String selling;
    public String fid;

    public Buyersmkulima(){

    }

    public Buyersmkulima(String firstname, String lastname, String email, String phone, String county, String category, String uuzaji, String kununua, String selling) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.county = county;
        this.category = category;
        this.uuzaji = uuzaji;
        this.kununua = kununua;
        this.selling = selling;
        return;
    }
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUuzaji() {
        return uuzaji;
    }

    public void setUuzaji(String uuzaji) {
        this.uuzaji = uuzaji;
    }

    public String getKununua() {
        return kununua;
    }

    public void setKununua(String kununua) {
        this.kununua = kununua;
    }

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    public String getFid() {
        return fid;
    }
    public void setFid(String fid) {
        this.fid = fid;
    }
}
