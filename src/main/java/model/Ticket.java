package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDateTime dateEntree;
	
	private LocalDateTime dateSortie;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "payementId", referencedColumnName = "id")
	private List<Payement> payement;
	
	public Ticket() {
		dateEntree = LocalDateTime.now();
		dateSortie = null;
	}

	public LocalDateTime getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie() {
		dateSortie = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDateEntree() {
		return dateEntree;
	}

	public List<Payement> getPayement() {
		return payement;
	}

	/*public void setPayementId(Payement payement) {
		this.payement = payement;
	}*/
}
