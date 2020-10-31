package sn.simplon.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sn.simplon.dao.IUser;
import sn.simplon.dao.UserImpl;
import sn.simplon.entities.*;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/Login")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUser userdao;
		
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
       
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
		if(request.getParameter("email")!=null) {
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		User user= userdao.getConnection(email, password);
		
		if(user!= null) {
			
			request.getSession().setAttribute("user_roles", 0);
			request.getSession().setAttribute("admin_roles", 0);
			
			List<Roles> roles= user.getRoles();
			
			if(roles.size()==0) {
				request.getRequestDispatcher("view/login/login.jsp")
				   .forward(request, response);
				
			}else {
		//response.getWriter().print(user.getPrenom());
			for(Roles r:roles) {
				if(r.getId()==1) {
					request.getSession().setAttribute("user_roles", 1);
				}
				
				if(r.getId()==2) {
					request.getSession().setAttribute("admin_roles", 2);
				}
				
			}
	   }
			
			request.getSession().setAttribute("user_session", user);
			request.getRequestDispatcher("view/login/accueil.jsp")
			   .forward(request, response);
	}else {
		//response.getWriter().print("email ou password incorrect");
		request.setAttribute("error_message", "email ou passe incorect");
		request.getRequestDispatcher("view/login/login.jsp")
		   .forward(request, response);
		
		
	}
		}else {
			request.getRequestDispatcher("view/login/login.jsp")
			   .forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
