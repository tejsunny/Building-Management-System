package com.ts.dao;



import com.ts.db.HibernateTemplate;
import com.ts.dto.Bookings;

public class BookingsDAO {

	public int register(int noOfParticipants, int facilityId,Bookings booking, java.sql.Date dor) {
		System.out.println("Krupani"+facilityId+" "+dor);
		long k = HibernateTemplate.registrationCount(facilityId, dor);
		System.out.println("k" + k);
		int l = HibernateTemplate.facilityCount(facilityId);
		System.out.println("l" + l);
		if((k + noOfParticipants) <= l) {
		    return HibernateTemplate.addObject(booking);
		} else {
			return 0;
		}
	}

	public int register(Bookings booking) {
		
		long k = HibernateTemplate.registrationCount(booking.getFacilities().getFacilityId(), booking.getDateOfRegistration());
		System.out.println("k" + k);
		int l = HibernateTemplate.facilityCount(booking.getFacilities().getFacilityId());
		System.out.println("l" + l);
		if((k + booking.getNoOfRegistrations()) <= l) {
		    return HibernateTemplate.addObject(booking);
		} else {
			return 0;
		}
	}
			
	

}
