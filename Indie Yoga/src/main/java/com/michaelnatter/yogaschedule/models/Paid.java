package com.michaelnatter.yogaschedule.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="instructors_courses")
public class Paid {
	
//	@EmbeddedId
//	PaidCompositeKey identification;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("instructorId")
	@JoinColumn(name="instructor_id")
	Instructor instructor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("courseId")
	@JoinColumn(name="course_id")
	Course course;
	
//    @Column(updatable=false)
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date createdAt;
//    
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date updatedAt;
    
//	@Value("false")
//    private String paid;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    
    public Paid() {
    	
    }



//	public PaidCompositeKey getIdentification() {
//		return identification;
//	}
//
//
//
//	public void setIdentification(PaidCompositeKey identification) {
//		this.identification = identification;
//	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}



//	public String getPaid() {
//		return paid;
//	}
//
//
//
//	public void setPaid(String paid) {
//		this.paid = paid;
//	}

















//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}


    
    
}