package Operation;

import model.Payement;
import model.Ticket;

public interface Operation {
	Ticket creerTicket();
	
	Ticket getTicket(int id);
	
	//Payement creerPayement(Ticket ticket); 
}
