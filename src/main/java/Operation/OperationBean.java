package Operation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Payement;
import model.Ticket;

@Stateless
public class OperationBean implements Operation {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Ticket creerTicket() {
		Ticket t = new Ticket();
		em.persist(t);
		return t;
	}
	
	@Override
	public Ticket getTicket(int id) {
		return em.find(Ticket.class, id);
	}
	
	@Override
	public void addPayementToTicket(Payement p, int id) {
		Ticket t = getTicket(id);
		t.addPayement(p);
	}

}
