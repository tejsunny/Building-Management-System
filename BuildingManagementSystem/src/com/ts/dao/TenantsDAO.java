package com.ts.dao;

import java.util.List;


import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Landlords;
import com.ts.dto.Tenants;

public class TenantsDAO {
   private SessionFactory factory = null;
	public int register(Tenants room) {
		return HibernateTemplate.addObject(room);
	}

	public  List<Tenants> getAllRooms() {
		List<Tenants> rooms=(List)HibernateTemplate.getObjectListByQuery("From Rooms");
		System.out.println("Inside All Rooms ..."+rooms);
		return rooms;	
	}
	
	public int updateDao(Tenants tenants) {
		System.out.println("Reached DAO");
		return HibernateTemplate.updateObject(tenants);

	}

	public Tenants getTenant(int user) {

		return (Tenants)HibernateTemplate.getObjectByTenantId1(user);
	}

}
