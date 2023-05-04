package com.example.finalproject;

public class hosp {

    int id;
    String hname,hemail,hpass,hmobile,hcit,hdis,hadd,hland,huser;

    public hosp(){}

    public hosp(int id,String hname,String husername,String hpassword,String hemail,String hmobile,String hadd,String hcit,String hdis,String hland){
        this.id=id;
        this.hname=hname;
        this.huser=husername;
        this.hpass=hpassword;
        this.hemail=hemail;
        this.hmobile=hmobile;
        this.hadd=hadd;
        this.hcit=hcit;
        this.hdis=hdis;
        this.hland=hland;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    //1
    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    //2
    public String getHpassword() {
        return hpass;
    }

    public void setHpassword(String hpassword) {
        this.hpass = hpassword;
    }

    //3
    public String getHemail() {
        return hemail;
    }

    public void setHemail(String email) {
        this.hemail = email;
    }

    //4
    public String getHusername() {
        return huser;
    }

    public void setHusername(String husername) {
        this.huser = husername;
    }

    //5
    public String getHmobile() {
        return hmobile;
    }

    public void setHmobile(String hmobile) {
        this.hmobile = hmobile;
    }

    //6
    public String getHadd() {
        return hadd;
    }

    public void setHadd(String hadd) {
        this.hadd = hadd;
    }

    //7
    public String getHcit() {
        return hcit;
    }

    public void setHcit(String hcit) {
        this.hcit = hcit;
    }

    //8
    public String getHdis() {
        return hdis;
    }

    public void setHdis(String hdis) {
        this.hdis = hdis;
    }

    //9
    public String getHland() {
        return hland;
    }

    public void setHland(String hland) {
        this.hland = hland;
    }





}
