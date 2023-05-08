package com.employee;

public class Employee {
    private int staff_id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    
    public Employee(int staff_id, String name, String email, String phone, 
    		String username, String password) {
	this.staff_id = staff_id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.username = username;
	this.password = password;
    }

    public int getId() {
        return staff_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }    
}
