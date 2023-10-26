package banque.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte{
	/*
	 * taux du livret A
	 */
	@Column(name = "TAUX", nullable = false)
	private double taux;
	/*
	 * Constructeur
	 */
	public LivretA() {
		super();

	}
	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}
	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
