package com.xworkz.nykaastore.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.nykaastore.dto.CosmeticsDTO;

public interface CosmeticsDAO {

	Connection getDBConnection() throws ClassNotFoundException, SQLException;

	// CRUD
	boolean save(CosmeticsDTO cosmetics);

	ArrayList<CosmeticsDTO> readAllRecords();

	boolean updateRecordBasedOnBrand(double newPriceValue, String brand);

	boolean deleteRecordBasedOnCosmeticsId(int cosmeticsId);

	List<CosmeticsDTO> readingNameAndBrandFromTable();

	int totalNumberOfRecords();

	double maxPrice();

}
