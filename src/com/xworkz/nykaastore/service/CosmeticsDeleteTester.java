package com.xworkz.nykaastore.service;

import com.xworkz.nykaastore.dao.CosmeticsDAO;
import com.xworkz.nykaastore.dao.impl.CosmeticsDAOImpl;

public class CosmeticsDeleteTester {

	public static void main(String[] args) {
		
		
		CosmeticsDAO cosmeticsDAO=new CosmeticsDAOImpl();
		
		boolean result=cosmeticsDAO.deleteRecordBasedOnCosmeticsId(5);
		
		System.out.println("result:"+result);
		
		
		

	}

}
