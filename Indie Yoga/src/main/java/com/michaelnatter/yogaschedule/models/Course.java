package com.michaelnatter.yogaschedule.models;


import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name of course is required!")
	@Size(min=2,max=50,message="Name must be between 3 and 30 characters")
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date dateTime;
	
    @NotEmpty(message="Location is required!")
    @Size(min=8, max=128, message="Location must be between 8 and 128 characters")
    private String location;
	
    @NotNull(message="Price of course is required!")
    @Min((int) 0)
    private Integer price;
    
    @NotEmpty(message="Description is required!")
    @Size(min=8, max=128, message="Description must be between 8 and 128 characters")
    private String description;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
    
	@ManyToMany()
	@JoinTable(
	    name = "instructors_courses",
	    joinColumns = @JoinColumn(name = "course_id"),
	    inverseJoinColumns = @JoinColumn(name = "instructor_id"))
	    
	private List<Instructor> instructors;

	public List<Instructor> getInstructors() {
	  return instructors;
	}
  
    public Course() {}
    

    
    
    

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor getInstructor() {
		return instructor;
	}






	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}






//	public Set<Paid> getPaid() {
//		return paid;
//	}
//
//
//	public void setPaid(Set<Paid> paid) {
//		this.paid = paid;
//	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
		this.updatedAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
