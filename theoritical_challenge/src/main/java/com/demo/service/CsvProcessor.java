package com.demo.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

@Service
public class CsvProcessor {
	private Map<String, Double> cellValues = new LinkedHashMap<>();

	public ByteArrayOutputStream process(MultipartFile file) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try (CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(file.getInputStream())));
				CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream))) {
			
			String[] nextLine;
			int rowNumber = 1;

			while ((nextLine = reader.readNext()) != null) {
				String[] processedRow = new String[nextLine.length]; // Hold processed row values
				for (int col = 0; col < nextLine.length; col++) {
					String cellId = getCellId(rowNumber, col);
					String cellValue = nextLine[col];
					double value = processCell(cellValue);
					cellValues.put(cellId, value);
					processedRow[col] = String.valueOf(value); // Store processed value
				}
				writer.writeNext(processedRow); // Write the processed row to the output CSV
				rowNumber++;
			}
			writer.flush(); // Ensure all content is written to the output stream
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputStream;
	}

	// Process the cell value, handling numbers or formulas
	private double processCell(String cellValue) {
		if (cellValue.startsWith("=")) {
			return evaluateFormula(cellValue.substring(1)); // Remove "=" from formula
		} else {
			return Double.parseDouble(cellValue); // Handle normal numeric values
		}
	}

	// Evaluate a formula using simple arithmetic operations
	private double evaluateFormula(String formula) {
		double result = 0;
		if (formula.contains("+")) {
			String[] operands = formula.split("\\+");
			result = getValue(operands[0]) + getValue(operands[1]);
		} else if (formula.contains("-")) {
			String[] operands = formula.split("-");
			result = getValue(operands[0]) - getValue(operands[1]);
		} else if (formula.contains("*")) {
			String[] operands = formula.split("\\*");
			result = getValue(operands[0]) * getValue(operands[1]);
		} else if (formula.contains("/")) {
			String[] operands = formula.split("/");
			result = getValue(operands[0]) / getValue(operands[1]);
		}
		return result;
	}

	// Get the value of a cell from the map or evaluate it if it’s a formula reference
	private double getValue(String cellReference) {
		cellReference = cellReference.trim(); // Handle spaces
		if (cellValues.containsKey(cellReference)) {
			return cellValues.get(cellReference);
		} else {
			return Double.parseDouble(cellReference); // Parse numeric values
		}
	}

	// Generate a cell ID like A1, B2, C3, etc.
	private String getCellId(int row, int col) {
		return (char) ('A' + col) + String.valueOf(row);
	}
}
