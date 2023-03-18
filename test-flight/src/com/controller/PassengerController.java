package com.controller;
import com.entity.Passengers;
import com.dao.PassengersDao;
import com.dao.UserDao;
import com.entity.User;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassengerController
 */
@WebServlet("/")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private PassengersDao passengersDao;
	 private UserDao userDao;
	 
	 public void init() {
	        passengersDao = new PassengersDao();
	        userDao = new UserDao();
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		}  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String action = request.getServletPath();
		 
		 try {
	            switch (action) {
	            
	                case "/new":
                        showNewForm(request, response);
                    break;
                    
	                case "/insert":
	                    savePassengers(request, response);
	                    
	                case "/delete":
	                    deletePassenger(request, response);
	                    break;
	                    
	                case "/edit":
	                	showEditForm(request, response);
	                    
	                case "/update":
	                    updatePassenger(request, response);
	                    break;
	                    
	                case "register":
	                	registerUser(request, response);
	                    break;
	                    
					
					/*
					 * default: listPassengers(request, response); break;
					 */
	            }
	            
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	}

	
	
	
	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);

		userDao.saveUser(user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
		dispatcher.forward(request, response);
	}
	

	private void updatePassenger(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
       
                 
        Passengers newPassenger = new Passengers(id,firstName,lastName,age,gender);
        passengersDao.savePassengers(newPassenger);
        response.sendRedirect("list");
		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
	        Passengers existingUser = passengersDao.getPassengers(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("passenger-form.jsp");
	        request.setAttribute("passenger", existingUser);
	        dispatcher.forward(request, response);

		
	}

	private void deletePassenger(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        passengersDao.deletePassenger(id);
        response.sendRedirect("list");
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("passenger-form.jsp");
        dispatcher.forward(request, response);
		
	}

	private void savePassengers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        
                 
        Passengers newPassenger = new Passengers(firstName,lastName,age,gender);
        passengersDao.savePassengers(newPassenger);
        response.sendRedirect("list");
        
	}


	/*
	 * private void listPassengers(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException, ServletException { List
	 * <Passengers> listOfPassengers = passengersDao.getAllPassengers();
	 * request.setAttribute("listPassengers", listOfPassengers); RequestDispatcher
	 * dispatcher = request.getRequestDispatcher("passenger-list.jsp");
	 * dispatcher.forward(request, response);
	 * 
	 */
	}
	


