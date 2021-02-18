package com.xworkz.nykaastore.service;

import com.xworkz.nykaastore.dao.CosmeticsDAO;
import com.xworkz.nykaastore.dao.impl.CosmeticsDAOImpl;

public class CosmeticsCountTester {

	public static void main(String[] args) {
		
		
		CosmeticsDAO cosmeticsDAOImpl=new CosmeticsDAOImpl();
		
		cosmeticsDAOImpl.totalNumberOfRecords();
		
		
		cosmeticsDAOImpl.maxPrice();
		
		System.out.println("highest price from cosmetics record");

	}

}
