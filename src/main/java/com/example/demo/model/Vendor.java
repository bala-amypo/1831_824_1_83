package com.example.demo.model;
import jakarta.persistence.Id;
public class Vendor{
    @Id
    private Long id;
@column(unique=true)
private String requirementName;
private String description;
private int maxDeliveryDays;
private double minQualityScore;
private boolean active;

public Long getId(){
    return id;
}
public void setId(Long id){
    this.id=id;
}

public String getId(){
    return requirementName;
}
public void setId(String requirementName){
    this.requirementName=requirementName;
}

public String getId(){
    return description;
}
public void setId(String description){
    this.description=description;
}

public String getId(){
    return requirementName;
}
public void setId(String requirementName){
    this.requirementName=requirementName;
}

public String getId(){
    return requirementName;
}
public void setId(String requirementName){
    this.requirementName=requirementName;
}

public String getId(){
    return requirementName;
}
public void setId(String requirementName){
    this.requirementName=requirementName;
}
}