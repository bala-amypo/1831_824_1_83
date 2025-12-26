// package com.example.demo.model;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import java.sql.Timestamp;
// import jakarta.persistence.Column;
// @Entity
// public class Vendor{
//   @Id
//   @GeneratedValue(strategy=GenerationType.IDENTITY)
//   private Long id;
//   @Column(unique=true)
//   private String name;
// private String contactEmail;
// private String contactPhone;
// private boolean active = true;
// private Timestamp createdAt;
// private Timestamp updatedAt;

// public Long getId(){
//     return id;
// }
// public void setId(Long id){
//     this.id=id;
// }
// public String getName(){
//     return name;
// }
// public void setName(String name){
//     this.name=name;
// }

// public String getContactEmail(){
//     return contactEmail;
// }
// public void setContactEmail(String contactEmail){
//     this.contactEmail=contactEmail;
// }

// public String getContactPhone(){
//     return contactPhone;
// }
// public void setContactPhone(String contactPhone){
//     this.contactPhone=contactPhone;
// }

// public boolean getActive(){
//     return active;
// }
// public void setActive(boolean active){
//     this.active=active;
// }

// public Timestamp getCreatedAt(){
//     return createdAt;
// }
// public void setCreatedAt(Timestamp createdAt){
//     this.createdAt=createdAt;
// }

// public Timestamp getUpdatedAt(){
//     return updatedAt;
// }
// public void setUpdatedAt(Timestamp updatedAt){
//     this.updatedAt=updatedAt;
// }
// public Vendor(Long id,String name,String contactEmail,String contactPhone,boolean active,Timestamp createdAt,Timestamp updatedAt){
//     this.id=id;
//     this.name=name;
//     this.contactEmail=contactEmail;
//     this.contactPhone=contactPhone;
//     this.active=active;
//     this.createdAt=createdAt;
//     this.updatedAt=updatedAt;
// }
// public Vendor(){}
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String contactEmail;
    private String contactPhone;
    private Boolean active;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    // ✅ REQUIRED by tests
    public Vendor() {
    }

    // ✅ REQUIRED by tests (EXACT order & types)
    public Vendor(Long id, String name, String contactEmail, String contactPhone,
                  Boolean active, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getters & setters

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getContactEmail() { return contactEmail; }
    public String getContactPhone() { return contactPhone; }
    public Boolean getActive() { return active; }
    public Timestamp getCreatedAt() { return createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
    public void setActive(Boolean active) { this.active = active; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
}
