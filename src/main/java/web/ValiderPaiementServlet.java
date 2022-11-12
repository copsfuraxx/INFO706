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
import model.Payement;
import model.PayementType;
import model.Ticket;

/**
 * Servlet implementation class ValiderPaiementServlet
 */
@WebServlet("/ValiderPaiement")
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
		PayementType pt = PayementType.valueOf(request.getParameter("typePayement"));
		double price = Double.parseDouble(request.getParameter("price"));
		LocalDateTime now = LocalDateTime.parse(request.getParameter("now"));
		Payement p = new Payement(pt, price, now);
		op.addPayementToTicket(p,id);
		if(request.getParameter("recue") != null) {
			Ticket t = op.getTicket(id);
			request.setAttribute("ticket", t);
			request.getRequestDispatcher("/Recue.jsp").forward(request, response);	
		}else {
			response.getWriter().append("Payement validé");
		}
		
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
