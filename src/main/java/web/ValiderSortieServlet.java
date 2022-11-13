package web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Operation.Operation;
import model.Ticket;

/**
 * Servlet implementation class ValiderSortieServlet
 */
@WebServlet("/ValiderSortie")
public class ValiderSortieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Operation op;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderSortieServlet() {
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
		int id = Integer.parseInt(request.getParameter("n_ticket"));
		Ticket t = op.getTicket(id);
		if(t.isValid(LocalDateTime.now())) {
			response.getWriter().append("Ouvert");
			op.addSortieToTicket(id);
			}
		else
			response.getWriter().append("Fermer");
	}

}
