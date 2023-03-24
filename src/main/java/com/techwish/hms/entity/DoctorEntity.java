package com.techwish.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DOCTOR_TAB")
public class DoctorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DOC_ID_COL")
	private Long id;
	
	@Column(name="DOC_NAME_COL")
	private String doctorName;

	@Column(name="DOC_QUALIF_COL")
	private String docQualif;

	@Column(name="DOC_SPEC_COL")
	private String docSpec;
	
	@Column(name="DOC_DEPT_COL")
	private String docDept;

	@Column(name="DOC_ADDR_COL")
	private String docAddr;
	
	@Column(name="DOC_CONT_COL")
	private String docContact;
	
	
}
