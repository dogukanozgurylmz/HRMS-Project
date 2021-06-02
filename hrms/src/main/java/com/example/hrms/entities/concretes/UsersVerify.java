package com.example.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users_verify")
public class UsersVerify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;

	@Column(name = "verify_code")
	private String verifyCode;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@JsonIgnore
	@Column(name="confirmed_date")
	private Date confirmedDate;
	
}
