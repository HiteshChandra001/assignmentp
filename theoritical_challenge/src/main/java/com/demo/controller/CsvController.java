package com.demo.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.service.CsvProcessor;
@RestController
@RequestMapping("csv")
public class CsvController {

	private final CsvProcessor csvProcessor;

	@Autowired
	public CsvController(CsvProcessor csvProcessor) {
		this.csvProcessor = csvProcessor;
	}

	@PostMapping("/process")
	public ResponseEntity<ByteArrayResource> processCsv(@RequestParam("file") MultipartFile input) {
		try {
			// Process the uploaded CSV file
			ByteArrayOutputStream outputStream = csvProcessor.process(input);

			// Create a ByteArrayResource from the output stream
			ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

			// Return the processed CSV as a downloadable file
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType("application/csv"))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"processed.csv\"")
					.body(resource);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}

