package Operation;

import model.Payement;
import model.Ticket;

public interface Operation {
	Ticket creerTicket();
	
	Ticket getTicket(int id);
	
	void addPayementToTicket(Payement p, int id);
}
