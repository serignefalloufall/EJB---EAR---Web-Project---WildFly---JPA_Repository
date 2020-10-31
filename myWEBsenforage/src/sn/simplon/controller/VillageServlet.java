package sn.simplon.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.simplon.entities.User;
import sn.simplon.entities.Village;
import sn.simplon.dao.IVillage;
import sn.simplon.dao.VillageImpl;

@WebServlet("/Village")
public class VillageServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IVillage villagedao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VillageServlet() {
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
			
			request.setAttribute("list_village", villagedao.getAll());
			
			request.getRequestDispatcher("view/village/list.jsp")
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
			String nom = request.getParameter("nom").toString();
			//response.getWriter().print("nom = "+nom);
			Village v = new Village();
			
			v.setNom(nom);
			
			User user=(User)request.getSession().getAttribute("user_session");
			v.setUser(user);
			
			int result = villagedao.add(v);
			if(result!=0) {
				request.setAttribute("message","village ajouter avec succes");
				
			}else {
			
				request.setAttribute("message","Erreur:Vllage non ajouter ");
			
		}
}

	doGet(request, response);

}


}
