package com.techwish.hms.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techwish.hms.payload.DoctorDto;
import com.techwish.hms.service.IDoctorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(description = "DOCTOR OPERATIONS")
@RequestMapping("/v1/api/doctor")
public class DoctorRestController {

	@Autowired
	private IDoctorService service;
	
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
	@ApiIgnore
	public ResponseEntity<List<DoctorDto>> fetchAllDoctors() {
		List<DoctorDto> list = service.getAllDoctors();
		return ResponseEntity.ok(list);
	}
}
