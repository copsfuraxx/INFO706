package web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Operation.Operation;
import model.Ticket;

/**
 * Servlet implementation class ValiderPaiementServlet
 */
@WebServlet("/ValiderPaiementServlet")
public class ValiderPaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Operation op;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderPaiementServlet() {
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
		int id = Integer.parseInt(request.getParameter("n_ticket"));
		Ticket t = op.getTicket(id);
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
