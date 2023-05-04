package com.example.finalproject;

public class blood {

    int id;

    String name,email,mobile,username,password,blood,city,dist,landmark,gender,add,birth;

    public blood(){}

    public blood(String name, String username,String pass,String email,String mob,String blo,String gen,String dat,String addr,String cit,String dis,String land){

        //this.id=id;
        this.name=name;
        this.email=email;
        this.username=username;
        this.password=pass;
        this.blood=blo;
        this.mobile=mob;
        this.city=cit;
        this.dist=dis;
        this.landmark=land;
        this.gender=gen;
        this.add=addr;
        this.birth=dat;

    }

    //public int getId() {
      //  return id;
   //}

    public void setId(int id) {
        this.id = id;
    }
    //1
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //2
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //3
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //4
    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    //5
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    //6
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //7
    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    //8
    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    //9
    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    //10
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //11
    public String getAddress() {
        return add;
    }

    public void setAddress(String add) {
        this.add = add;
    }

    //12
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}
