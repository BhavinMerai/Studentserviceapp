package com.sso.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    
   @Column( length = 45)
   private String email;
    
   @Column( length = 64)
   private String password;
    
   @Column(length = 20)
   private String firstName;
    
   @Column(  length = 20)
   private String lastName;
    
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "professor_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")
   )
   private Set<Roles> roles = new HashSet<>();

   public void addRole(Roles role) {
       this.roles.add(role);
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Set<Roles> getRoles() {
	return roles;
}

public void setRoles(Set<Roles> roles) {
	this.roles = roles;
}

   // getters and setters are not shown for brevity
   
   
}
