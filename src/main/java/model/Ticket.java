package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
	private List<Payement> payements;
	
	public Ticket() {
		dateEntree = LocalDateTime.now();
		dateSortie = null;
		payements = new ArrayList<>();
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

	public List<Payement> getPayements() {
		return payements;
	}
	
	public Payement getPayement(int i) {
		return payements.get(i);
	}

	public void addPayement(Payement payement) {
		payements.add(payement);
	}
	
	public double getTotalMontant() {
		double m = 0d;
		for(Payement p : payements) {
			m += p.getMontant();
		}
		return m;
	}
}
