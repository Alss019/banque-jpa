package banque.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte {
	/*
	 * Date de fin de l'assurance vie
	 */
	@Column(name = "DATE_FIN", nullable = false)
	private LocalDate dateFin;
	/*
	 * taux de l'assurance vie
	 */
	@Column(name = "TAUX", nullable = false)
	private double taux;
	/*
	 * Constructeur
	 */
	public AssuranceVie() {
		super();
	}
	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
