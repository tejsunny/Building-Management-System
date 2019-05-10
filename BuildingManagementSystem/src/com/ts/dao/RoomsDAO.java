package com.ts.dao;
import java.util.List;




import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;

import com.ts.dto.Rooms;
import com.ts.dto.Tenants;
import com.ts.dto.Landlords;

public class RoomsDAO {
private SessionFactory factory = null;
	
	public  List<Rooms> getAllRooms() {
		List<Rooms> rooms=(List)HibernateTemplate.getObjectListByQuery("From Rooms");
		System.out.println("Inside All Rooms ..."+rooms);
		return rooms;	
	}
	public List<Rooms> getAllVacantRooms() {
		List<Rooms> rooms=(List)HibernateTemplate.getObjectListByQuery("From Rooms where TENANT_ID = -1 and LANDLORD_ID != 600");
		return rooms;
	}
	public int updateLandlord(int flatNo, int landlordId) {
		System.out.println("Reached DAO");
		return HibernateTemplate.updateObjectLandlord(flatNo,landlordId);
	}

	public int deleteTenant(int flatNo) {
		return HibernateTemplate.deleteObject(flatNo);		
	}

	public List<Rooms> getRoomsByLandlordId(int id) {
		List<Rooms> rooms=(List)HibernateTemplate.getObjectByLandLordId(id);
		return rooms;
	}
	public List<Rooms> getRoomsById(int id) {
		List<Rooms> rooms=(List)HibernateTemplate.getObjectByUserId(id);
		System.out.println("Inside All Rooms ..."+rooms);
		return rooms;
	}
	public int update(int flatNo, int tenantId) {
		return HibernateTemplate.updateObject(flatNo,tenantId);
		
	}


	public Rooms getRoomByTenantId(int tenantId) {
		return (Rooms)HibernateTemplate.getObjectByTenantId(tenantId);
	}
	public List<Rooms> getAllFlatsForSale() {
		List<Rooms> rooms=(List)HibernateTemplate.getObjectListByQuery("From Rooms where LANDLORD_ID = 600");
		return rooms;
	}
}
