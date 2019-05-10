package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Facilities;

public class FacilitiesDAO {
private SessionFactory factory = null;
	
	public Facilities getFacilities(int user) {

		return (Facilities)HibernateTemplate.getObjectByUserName(user);
	}

	public int register(Facilities facilities) {
		return HibernateTemplate.addObject(facilities);
	}

	public  List<Facilities> getAllFacilities() {
		List<Facilities> facilities=(List)HibernateTemplate.getObjectListByQuery("From Facilities");
		//System.out.println("Inside All Departments ..."+depts);
		return facilities;	
	}

}
