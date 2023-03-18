package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.Passengers;
import com.util.HibernateUtil;


public class PassengersDao{
	
		
	 public  void savePassengers(Passengers passenger) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the passenger object
	            session.saveOrUpdate(passenger);
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	 }
	 

		/*
		 * @SuppressWarnings("unchecked") public List <Passengers> getAllPassengers() {
		 * 
		 * Transaction transaction = null;
		 * 
		 * List <Passengers> listOfPassengers = null;
		 * 
		 * try (Session session = HibernateUtil.getSessionFactory().openSession()) { //
		 * start a transaction transaction = session.beginTransaction(); // get a
		 * Passengers object
		 * 
		 * listOfPassengers = session.createQuery("from Passengers").getResultList();
		 * 
		 * // commit transaction transaction.commit(); } catch (Exception e) { if
		 * (transaction != null) { transaction.rollback(); } e.printStackTrace(); } }
		 */
		        /*return listOfPassengers;
		    }
               
               /**
                * Delete Passenger
                * @param id
                */  
               public void deletePassenger(int id) {

                   Transaction transaction = null;
                   try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                       // start a transaction
                       transaction = session.beginTransaction();

                       // Delete a Passenger object
                       Passengers passenger = session.get(Passengers.class, id);
                       if (passenger != null) {
                           session.delete(passenger);
                           System.out.println("passenger is deleted");
                       }

                       // commit transaction
                       transaction.commit();
                   } catch (Exception e) {
                       if (transaction != null) {
                           transaction.rollback();
                       }
                       e.printStackTrace();
                   }
               }
               /**
                * Update Passengers
                * @param passengers
                */
               public void updatePassenger(Passengers passenger) {
                   Transaction transaction = null;
                   try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                       // start a transaction
                       transaction = session.beginTransaction();
                       // save the student object
                       session.update(passenger);
                       // commit transaction
                       transaction.commit();
                   } catch (Exception e) {
                       if (transaction != null) {
                           transaction.rollback();
                       }
                       e.printStackTrace();
                   }
               }


			public Passengers getPassengers(int id) {
				   Transaction transaction = null;
			        Passengers passenger = null;
			        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			            // start a transaction
			            transaction = session.beginTransaction();
			            // get an user object
			            passenger = session.get(Passengers.class, id);
			            // commit transaction
			            transaction.commit();
			        } catch (Exception e) {
			            if (transaction != null) {
			                transaction.rollback();
			            }
			            e.printStackTrace();
			        }
			        return passenger;
			    }


				
			}
	
               
	
