package com.ts.dao;
import java.util.List;


import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Landlords;

public class BillsDAO {
private SessionFactory factory = null;
	
public int deleteBills(int flatNo) {
	// TODO Auto-generated method stub
	return HibernateTemplate.deleteBills(flatNo);
}
public int updateBills(int flatNo) {
	// TODO Auto-generated method stub
	System.out.println("in dao"+flatNo);
	return HibernateTemplate.updateBill(flatNo);
}


}
