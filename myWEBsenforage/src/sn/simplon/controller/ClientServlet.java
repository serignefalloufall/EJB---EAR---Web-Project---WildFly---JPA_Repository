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

import sn.simplon.dao.IClient;
import sn.simplon.dao.IVillage;
import sn.simplon.entities.Client;
import sn.simplon.entities.User;
import sn.simplon.entities.Village;


@WebServlet("/Client")
public class ClientServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IClient clientdao; 
	
	@EJB
	private IVillage villagedao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
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
			
			request.setAttribute("list_client", clientdao.getAll());
			request.setAttribute("list_village", villagedao.getAll());
			
			request.getRequestDispatcher("view/client/list.jsp")
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
			
			String adresse = request.getParameter("adresse").toString();
			String nom = request.getParameter("nom").toString();
			String prenom = request.getParameter("prenom").toString();
			String tel = request.getParameter("tel").toString();
			
			Client cli = new Client();
			
			cli.setAdresse(adresse);
			cli.setNom(nom);
			cli.setPrenom(prenom);
			cli.setTel(tel);

			int id=Integer.parseInt(request.getParameter("village_id").toString());
			Village village = villagedao.get(id);
			cli.setVillage(village);
			
			User user=(User)request.getSession().getAttribute("user_session");
			cli.setUser(user);
			
			int result = clientdao.add(cli);
			if(result!=0) {
				request.setAttribute("message","client ajouter avec succes");
				
			}else {
			
				request.setAttribute("message","Erreur:client non ajouter ");
			
		}
}

	doGet(request, response);

}


}
