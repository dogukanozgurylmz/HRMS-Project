package com.example.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="confirm_employer_users")
public class ConfirmEmployer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int Id;
	
	@OneToOne(targetEntity = EmployerUser.class)
	@JoinColumn(name="employer_id", referencedColumnName="id")
	private EmployerUser employer;
	
	@Column(name = "employee_id")
	private int staffUser;
	
	@Column(name="confirmed_date")
	private Date confirmedDate;
	
	@Column(name="is_confirm")
	private boolean isConfirm;
	
}
