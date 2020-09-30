package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String entry = request.getParameter("entry");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebCarDealershipIanWetzler");
		EntityManager em = emf.createEntityManager();
		CarHelper help = new CarHelper(em);
		if(entry.equalsIgnoreCase("id") | entry.equalsIgnoreCase("year")) {
			int change = Integer.parseInt(request.getParameter("change"));
			em.getTransaction().begin();
			help.editCarIdYear(id, entry, change);
			em.getTransaction().commit();
			getServletContext().getRequestDispatcher("/Results.jsp").forward(request, response);
		}
		else if(entry.equalsIgnoreCase("make") | entry.equalsIgnoreCase("model")) {
			String change = request.getParameter("change");
			em.getTransaction().begin();
			help.editCarMakeModel(id, entry, change);
			em.getTransaction().commit();
			getServletContext().getRequestDispatcher("/Results.jsp").forward(request, response);
		}
		
		}
	
}


