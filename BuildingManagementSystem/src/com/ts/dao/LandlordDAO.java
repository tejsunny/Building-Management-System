package com.ts.dao;
import java.util.List;


import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Landlords;

public class LandlordDAO {
private SessionFactory factory = null;
	
	public Landlords getLandlord(int user) {

		return (Landlords)HibernateTemplate.getObjectByUserName(user);
	}

	public int register(Landlords landlords) {
		return HibernateTemplate.addObject(landlords);
	}

	public  List<Landlords> getAllLandlords() {
		List<Landlords> landlords=(List)HibernateTemplate.getObjectListByQuery("From Landlords");
		//System.out.println("Inside All Departments ..."+depts);
		return landlords;	
	}
	public int updateDao(Landlords landlords) {
		return HibernateTemplate.updateObject(landlords);

	}


	public Landlords getLandlords(int id) {
		return (Landlords)HibernateTemplate.getObject(Landlords.class,id);
	}

}
