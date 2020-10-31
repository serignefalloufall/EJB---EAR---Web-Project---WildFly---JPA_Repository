package sn.simplon.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.simplon.dao.IUser;
import sn.simplon.dao.UserImpl;
import sn.simplon.entities.User;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUser userdao; 
	
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	if(request.getSession().getAttribute("user_session")!=null) {
		
		if(request.getParameter("action")!=null)
		{
			if(request.getParameter("action").equals("delete"))
			{
			int id=Integer.parseInt(request.getParameter("id").toString());
			userdao.delete(id);
			}

			if(request.getParameter("action").equals("edit"))
			{
				int id=Integer.parseInt(request.getParameter("idEdit").toString());
				User user=userdao.get(id);
				request.setAttribute("lieuEdit", user);
			}
		}
			
			request.setAttribute("list_user", userdao.getAll());
			
			request.getRequestDispatcher("view/user/list.jsp")
		      .forward(request, response);
      	}else {
		        response.sendRedirect("login");
	}   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("valider") != null) {
			String email = request.getParameter("email").toString();
			String nom = request.getParameter("nom").toString();
			String password = request.getParameter("password").toString();
			String prenom = request.getParameter("prenom").toString();
			
			User user = new User();
			user.setEmail(email);
			user.setNom(nom);
			user.setPassword(password);
			user.setPrenom(prenom);
			
			int ok = userdao.add(user);
			request.setAttribute("message",ok);
			request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
		}
	}

}
