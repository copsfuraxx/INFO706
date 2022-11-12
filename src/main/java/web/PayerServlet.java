package web;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Operation.Operation;
import model.PayementType;
import model.Ticket;

/**
 * Servlet implementation class Payer
 */
@WebServlet("/Payer")
public class PayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private Operation op;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayerServlet() {
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
		// TODO Auto-generated method stub
		Ticket t = op.getTicket(id);
		request.setAttribute("ticket", t);
		LocalDateTime now = LocalDateTime.now();
		float price = calculatePrice(t.getDateEntree(),now);
		request.setAttribute("price", price);
		request.setAttribute("now", now);
		System.out.println(PayementType.getStrings());
		request.setAttribute("payementTypes", PayementType.getStrings());
		request.getRequestDispatcher("/Payer.jsp").forward(request, response);	
	}
	
	float calculatePrice(LocalDateTime start, LocalDateTime end) {
		float price_per_minute = 0.02f; //€
		Duration total_time = Duration.between(start, end);
		float price = total_time.toMinutes() * price_per_minute;
		System.out.println(price);
		return price;
	}

}
