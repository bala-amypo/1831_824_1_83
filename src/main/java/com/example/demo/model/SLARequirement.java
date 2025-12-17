package com.example.demo.model;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class SLARequirement{
    @Id
    private Long id;
@Column(unique=true)
private String requirementName;
private String description;

private int maxDeliveryDays;
@Size(min=0,max=100)
private double minQualityScore;
private boolean active;

public Long getId(){
    return id;
}
public void setId(Long id){
    this.id=id;
}

public String getRequirementName(){
    return requirementName;
}
public void setRequirementName(String requirementName){
    this.requirementName=requirementName;
}

public String getDescription(){
    return description;
}
public void setId(String description){
    this.description=description;
}

public int getId(){
    return maxDeliveryDays;
}
public void setId(int maxDeliveryDays){
    this.maxDeliveryDays=maxDeliveryDays;
}

public double getId(){
    return minQualityScore;
}
public void setId(double minQualityScore){
    this.minQualityScore=minQualityScore;
}

public boolean getId(){
    return active;
}
public void setId(boolean active){
    this.active=active;
}
}