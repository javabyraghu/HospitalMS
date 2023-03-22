package com.techwish.hms.payload;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DoctorDto {

	private Long id;
	
	@NotNull
	private String doctorName;

	@NotNull
	private String docQualif;

	@NotNull
	private String docSpec;
	
	@NotNull
	private String docDept;

	@NotNull
	private String docAddr;
	
	@NotNull
	private String docContact;
	
	
}
