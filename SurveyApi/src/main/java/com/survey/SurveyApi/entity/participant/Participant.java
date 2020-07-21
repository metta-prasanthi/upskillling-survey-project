
package com.survey.surveyapi.entity.participant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.survey.surveyapi.entity.AbstractEntity;

@Entity
@Table(name = "Participant")
public class Participant  extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "First name cannot be null")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null")
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email cannot be null")
    private String email;

	public Participant() {
    }
        
    public Participant(Long id, @NotEmpty(message = "First name cannot be null") String firstName,
			@NotEmpty(message = "Last name cannot be null") String lastName,
			@Email(message = "Email should be valid") @NotEmpty(message = "Email cannot be null") String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}