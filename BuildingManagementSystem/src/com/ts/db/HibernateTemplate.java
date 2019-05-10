package com.ts.db;

import java.io.Serializable;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ts.dto.Rooms;
import com.ts.dto.Tenants;
import com.ts.dto.Landlords;
import com.ts.dto.Bookings;
import com.ts.dto.Facilities;

public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static
	{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	public static int deleteObject(int flatNo) {
	       int result=0;
			
			Transaction tx=null;
			
			try {
				
				Session session=sessionFactory.openSession();
				tx=session.beginTransaction();
				String queryString="update Rooms set tenants.tenantId= :tenantId,vacancy= :vacancy where flatNo= :flatNo";
				Query query=session.createQuery(queryString);
				query.setParameter("tenantId", -1);
				query.setParameter("vacancy","YES");
				query.setParameter("flatNo", flatNo);
				result=query.executeUpdate();
				tx.commit();
				System.out.println("Reached Hib....");
				
			} catch (Exception e) {
			
				tx.rollback();
				
				e.printStackTrace();
			}
			
			return result;	

			
		}

	public static int updateBill(int FLAT_NO) {
		int result=0;
				
				Transaction tx=null;
				
				try {
					
					Session session=sessionFactory.openSession();
					tx=session.beginTransaction();
					String queryString="update Bills set waterBill= :waterBill, electricityBill= :electricityBill, maintenanceBill= :maintenanceBill where FLAT_NO= :FLAT_NO";	
					Query query=session.createQuery(queryString);
					query.setParameter("waterBill", 0.0f);
					query.setParameter("electricityBill",0.0f);
					query.setParameter("maintenanceBill", 0.0f);
					query.setParameter("FLAT_NO", FLAT_NO);
					System.out.println("in delete"+query.executeUpdate());
					result=query.executeUpdate();
					tx.commit();
					System.out.println("Reached Hib....");
					
				} catch (Exception e) {
				
					tx.rollback();
					
					e.printStackTrace();
				}
				
				return result;	

				
			}


	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	public static int updateObject(int flatNo, int tenantId) {
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			String queryString="update Rooms set tenants.tenantId= :tenantId, vacancy= :vacancy where flatNo= :flatNo";
			Query query=session.createQuery(queryString);
			query.setParameter("tenantId", tenantId);
			query.setParameter("flatNo", flatNo);
			query.setParameter("vacancy","NO");
			result=query.executeUpdate();
			tx.commit();
			System.out.println("Reached Hib....");
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;	
}

	public static int updateObject(Rooms rooms, int tenantId) {
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			String queryString="update Rooms set rooms.vacancy =:'NO', rooms.tenantId=:tenantId";
			Query query=session.createQuery(queryString);
			query.setParameter("tenantId", tenantId);
			query.setEntity("rooms", rooms);
			result=query.executeUpdate();
			tx.commit();
			System.out.println("Reached Hib....");
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;		
	}
	
	public static Object getObjectByUserName(int userName) {
	
	  String queryString = "from Rooms where userName = :userName";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setInteger("userName", userName);
	  Object queryResult = query.uniqueResult();
	  Rooms room = (Rooms)queryResult;
	  System.out.println(room.getFlatNo()+" "+room.getVacancy()); 
	  return room; 
	}
	public static Object getObjectByLandlordId(int landlordId) {
		
		  String queryString = "from Landlords where landlordId = :landlordId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("landlordId", landlordId);
		  Object queryResult = query.uniqueResult();
		  Landlords landlord = (Landlords)queryResult; 
		  return landlord; 
		}
	public static Object getObjectByTenantId1(int tenantId) {
		System.out.println("servlet..");

		  String queryString = "from Tenants where tenantId = :tenantId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("tenantId", tenantId);
		  Object queryResult = query.uniqueResult();
		  Tenants tenant = (Tenants)queryResult; 
		  return tenant; 
		}
	
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectByLandLordId(int LANDLORD_ID) {
		String queryString = "from Rooms where LANDLORD_ID = :LANDLORD_ID";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("LANDLORD_ID", LANDLORD_ID);
		  query.setFirstResult(0);
		  query.setMaxResults(12);
		  List rooms = query.list();
		  return rooms;
		  
	}

	public static Object getObjectByUserId(int floor) {
		
		String queryString = "from Rooms where floor = :floor";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("floor", floor);
		  query.setFirstResult(0);
		  query.setMaxResults(3);
		  List results = query.list();
		  return results; 
		}

	public static Object getObjectByTenantId(int TENANT_ID) {
		String queryString = "from Rooms where TENANT_ID = :TENANT_ID";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("TENANT_ID", TENANT_ID);
		  Object queryResult = query.uniqueResult();
		  Rooms room = (Rooms)queryResult;
		  return room;	
	}

	public static long registrationCount(int FACILITY_ID, java.sql.Date dateOfRegistration) {
		System.out.println("venky" + FACILITY_ID + " " + dateOfRegistration);
		System.out.println("dateOfRegistration"+dateOfRegistration);
		String queryString = "select sum(noOfRegistrations) from Bookings where FACILITY_ID = :FACILITY_ID and dateOfRegistration = :dateOfRegistration";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setParameter("FACILITY_ID", FACILITY_ID);
		  long k;
		  query.setParameter("dateOfRegistration", dateOfRegistration);
		  if (query.uniqueResult() == null) {
			  k  = 0;
		  } else {
			  k = (long)query.uniqueResult();
		  }
			System.out.println("out of query " + query.uniqueResult());

		  
		  System.out.println("k = "+k);
		  return k;			
	}

	public static int facilityCount(int facilityId) {
		String queryString = "select limitedPeople from Facilities where facilityId = :facilityId";
		Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("facilityId", facilityId);
		  Object queryResult = query.uniqueResult();
		  int l = (int)queryResult;
		  return l;
	}
	public static int deleteBills(int flatNo) {
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			String queryString="update Rooms set tenants.tenantId= :tenantId,vacancy= :vacancy where flatNo= :flatNo";
			Query query=session.createQuery(queryString);
			query.setParameter("tenantId", -1);
			query.setParameter("vacancy","YES");
			query.setParameter("flatNo", flatNo);
			result=query.executeUpdate();
			tx.commit();
			System.out.println("Reached Hib....");
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;	
	}
	public static int updateObjectLandlord(int flatNo, int landlordId) {
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			String queryString="update Rooms set landlords.landlordId= :landlordId, landlordvacancy= :landlordvacancy where flatNo= :flatNo";
			Query query=session.createQuery(queryString);
			query.setParameter("landlordId", landlordId);
			query.setParameter("flatNo", flatNo);
			query.setParameter("landlordvacancy","NO");
			result=query.executeUpdate();
			tx.commit();
			System.out.println("Reached Hib....");
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;	

	}


	
}
