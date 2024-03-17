package com.radacode.ciclosvida;

public class Contacto {

    private String name;
    private String date;
    private String cel;
    private String email;
    private String desc;

    public Contacto(String name, String date, String cel, String email, String desc) {
        this.name = name;
        this.date = date;
        this.cel = cel;
        this.email = email;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
