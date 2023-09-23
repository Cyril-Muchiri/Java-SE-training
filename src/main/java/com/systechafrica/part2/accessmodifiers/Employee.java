package com.systechafrica.part2.accessmodifiers;



public class Employee {
    private String name;
    private String id;
    private String email;
    private boolean isAvailable;

    public Employee(String name, String id, boolean isAvailable) {
        this.name = name;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }



    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", email=" + email + ", isAvailable=" + isAvailable + "]";
    }

    
  

}
