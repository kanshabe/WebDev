package com.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlightDao;

import com.entity.Flight;

@WebServlet("/FlightController")

public class FlightController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private FlightDao flightDao;
	
	
       
	// Servlet initialization with the database object.
	 public void init() {
		   
	    	flightDao = new FlightDao();
	    	
	    	  			
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing flights
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listFlights(request, response);
				break;
				
			case "LOAD":
				loadFlight(request, response);
				break;
				
						
			case "SEARCH":
                searchFlights(request, response);
                break;
								
			default:
				listFlights(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	

	private void loadFlight(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// read flight id from form data
			// String theFlightId = request.getParameter("flightId");
			int id = Integer.parseInt(request.getParameter("flightId"));
			
			// get flight from database (db util)
			Flight theFlight = flightDao.getFlight(id);
			
			// place flight in the request attribute
			request.setAttribute("THE_FLIGHT", theFlight);
			
			// send to jsp page: booking-flight-form.jsp.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/booking-flight-form.jsp");
			dispatcher.forward(request, response);		
	}

	
    private void searchFlights(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read search name from form data
        String theSearchName = request.getParameter("theSearchName");
        
        // search flights from db util
        List<Flight> flights = FlightDao.searchFlights(theSearchName);
        
        // add flights to the request
        request.setAttribute("FLIGHT_LIST", flights);
                
        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-flights.jsp");
        dispatcher.forward(request, response);
    }
	

	// Method to send details to Flight JSP for display of Flight information.
		private void listFlights(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get flights from db util
			List <Flight> flights = flightDao.getAllFlights();
			
			// add flights to the request
			request.setAttribute("FLIGHT_LIST", flights);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-flights.jsp");
			dispatcher.forward(request, response);
		}
		
		
	// Method to enter and save booking details for a customer.
		private void savePassengers(HttpServletRequest request, HttpServletResponse response) 
				throws Exception {

				// read flight id from form data
				// String theFlightId = request.getParameter("flightId");
				int idFlight = Integer.parseInt(request.getParameter("flightId"));
				
				// get flight from database (db util)
				Flight theFlight = flightDao.getFlight(idFlight);
				
				// place flight in the request attribute
				request.setAttribute("THE_FLIGHT", theFlight);
				
				// send to jsp page: booking-flight-form.jsp.jsp
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/booking-confirmed-form.jsp");
				dispatcher.forward(request, response);		
		}
		

		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        try {
	            // read the "command" parameter
	            String theCommand = request.getParameter("command");
	                    
	            // route to the appropriate method
	            switch (theCommand) {
	                            
	            case "SAVE":
					savePassengers(request, response);
					break;
	                                
	            default:
	            	listFlights(request, response);
	            }
	                
	        }
	        catch (Exception exc) {
	            throw new ServletException(exc);
	        }
	        
	    }
	

}
