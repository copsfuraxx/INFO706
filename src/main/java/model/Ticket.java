package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDate dateEntree;
	
	private LocalDate dateSortie;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payementId", referencedColumnName = "id")
	private Payement payement;
	
	public Ticket() {
		dateEntree = LocalDate.now();
		dateSortie = null;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie() {
		dateSortie = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public Payement getPayement() {
		return payement;
	}

	public void setPayementId(Payement payement) {
		this.payement = payement;
	}
}
