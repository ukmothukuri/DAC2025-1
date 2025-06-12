package com.example;

public class Student {
    private String name;  
    private String email;
  
    public String getName() {  
        return name;  
    }  
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {  
        this.name = name;  
    }  
    
    public void displayInfo(){  
        System.out.println("Hello: "+name);  
    }  
}
