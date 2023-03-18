package com.dao;

import org.hibernate.Session;
import java.util.List;

import org.hibernate.Transaction;

import com.entity.Flight;

import com.util.HibernateUtil;

public class FlightDao {
	
	 public  void saveFlights(Flight flight) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the passenger object
	            session.saveOrUpdate(flight);
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	 }
	 

            @SuppressWarnings("unchecked")
			public List <Flight> getAllFlights() {

		        Transaction transaction = null;
		        
		        List <Flight> listOfFlights = null;
		        
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start a transaction
		            transaction = session.beginTransaction();
		            // get a Passengers object

		            listOfFlights = session.createQuery("from Flight").getResultList();

		            // commit transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
		        }
		        return listOfFlights;
		    }
            
            /**
             * Delete flights
             * @param id
             */  
            public void deleteFlight(int id) {

                Transaction transaction = null;
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    // start a transaction
                    transaction = session.beginTransaction();

                    // Delete a Passenger object
                    Flight flight = session.get(Flight.class, id);
                    if (flight != null) {
                        session.delete(flight);
                        System.out.println("flight is deleted");
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
             * Update flights
             * @param flights
             */
            public void updateFlight(Flight flight) {
                Transaction transaction = null;
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    // start a transaction
                    transaction = session.beginTransaction();
                    // save the student object
                    session.update(flight);
                    // commit transaction
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                }
            }


			public Flight getFlight(int id) {
				   Transaction transaction = null;
			        Flight flight = null;
			        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			            // start a transaction
			            transaction = session.beginTransaction();
			            // get an user object
			            flight = session.get(Flight.class, id);
			            // commit transaction
			            transaction.commit();
			        } catch (Exception e) {
			            if (transaction != null) {
			                transaction.rollback();
			            }
			            e.printStackTrace();
			        }
			        return flight;
			    }


			public static List<Flight> searchFlights(String theSearchName) {
				// TODO Auto-generated method stub
				return null;
			}


				
			}
	

