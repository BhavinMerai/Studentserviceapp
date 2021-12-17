package com.sso.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(nullable = false, length = 45)
    private String name;
 
    public Roles() { }
     
    public Roles(String name) {
        this.name = name;
    }
     
    public Roles(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Roles(Integer id) {
        this.id = id;
    }
     
 
    @Override
    public String toString() {
        return this.name;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
    // getters and setters are not shown for brevity   
    
    
}