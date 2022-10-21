package Operation;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
