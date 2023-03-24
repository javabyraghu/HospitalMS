package com.techwish.hms.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techwish.hms.payload.DoctorDto;
import com.techwish.hms.service.IDoctorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "DOCTOR OPERATIONS")
@RequestMapping("/v1/api/doctor")
public class DoctorRestController {

	@Autowired
	private IDoctorService service;
	
	/**
	 * This method is for Creating a new Doctor in Database
	 * @param doctorDto in JSON Format
	 * @return Success Response on creation
	 */
	@PostMapping("/save")
	@ApiOperation("CREATING DOCTOR")
	public ResponseEntity<String> createDoctor(
			@RequestBody @Valid DoctorDto doctorDto
			) 
	{
		Long id = service.addDoctor(doctorDto);
		String message = "Doctor '"+id+"' is created ";
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/all")
	//@ApiIgnore
	public ResponseEntity<List<DoctorDto>> fetchAllDoctors() {
		List<DoctorDto> list = service.getAllDoctors();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<DoctorDto> fetchOneDoctor(
			@PathVariable Long id
			)
	{
		DoctorDto dto = service.getOneDoctor(id);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteDoctor(
			@PathVariable Long id
			)
	{
		service.deleteDoctor(id);
		
		return ResponseEntity.ok("DOCTOR '"+id+"' DELETED");
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateDoctor(
			@RequestBody DoctorDto doctorDto
			) 
	{
		service.updateDoctor(doctorDto);
		
		return ResponseEntity.ok("DOCTOR '"+doctorDto.getId()+"' UPDATED");
	}

	@PatchMapping("/modify/{id}/{docDept}")
	public ResponseEntity<String> updateDocDeptById(
			@PathVariable Long id,
			@PathVariable String docDept
			) 
	{
		service.updateDocDeptById(id, docDept);
		return ResponseEntity.ok("DOCTOR '"+id+"' UPDATED WITH NEW DEPT ");
	}
}
