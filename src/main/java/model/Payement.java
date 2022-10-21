package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private PayementType payementType;
	private LocalDate date;
	private double montant;
	
	public Payement() {}
	
	public Payement(PayementType payementType,double montant) {
		this.payementType = payementType;
		this.date = LocalDate.now();
		this.montant = montant;
	}

	public PayementType getPayementType() {
		return payementType;
	}

	public void setPayementType(PayementType payementType) {
		this.payementType = payementType;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}
	
	
}
