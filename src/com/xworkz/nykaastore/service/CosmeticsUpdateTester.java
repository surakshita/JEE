package com.xworkz.nykaastore.service;

import com.xworkz.nykaastore.dao.CosmeticsDAO;
import com.xworkz.nykaastore.dao.impl.CosmeticsDAOImpl;

public class CosmeticsUpdateTester {

	public static void main(String[] args) {
		
		
		CosmeticsDAO cosmeticsDAO=new CosmeticsDAOImpl();
		boolean result=cosmeticsDAO.updateRecordBasedOnBrand(449.00, "Mac");
		
		System.out.println("updated price :"+result);
	}

}
