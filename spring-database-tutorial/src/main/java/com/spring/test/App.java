package com.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/test/beans/beans.xml");

		//get the bean offersDao
		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

		//update offer
		Offer updateOffer = new Offer(4, "Claire", "claire@gmail.com", "Web design to fit any budget");
		if(offersDao.update(updateOffer)) {
			System.out.println("Object updated.");
		}
		else {
			System.out.println("Cannot update object.");
		}
		//end update offer

		try {
			//batch update
			List<Offer> offersList = new ArrayList<Offer>();

			offersList.add(new Offer("Dave", "dave@gmail.com", "Cash for software."));
			offersList.add(new Offer("Karen", "karen@gmail.com", "Elegant web design"));

			int[] rvals = offersDao.create(offersList);

			for(int value: rvals) {
				System.out.println("Updated " + value + " rows.");
			}
			//end batch update 
			//Offer offer1=new Offer("Dave", "dave@gmail.com", "javscript coding");
			//offersDao.create(offer1);// create new offer
			//offersDao.delete(3);//delete offer
			
			//get all the offer
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			// get the offer where id=2
			Offer offer = offersDao.getOffer(2);

			System.out.println("Should be Mike: " + offer);
		}
		catch(CannotGetJdbcConnectionException ex) {
			System.out.println("Unable to connect to database.");
		}
		catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

}
