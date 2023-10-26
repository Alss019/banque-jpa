package banque.entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NOM",length=100, nullable=false)
	private String nom; 
	@Column(name="PRENOM",length=100, nullable=false)
	private String prenom;
	@Column(name="DATE_NAISSANCE")
	private LocalDate dateNaissance;
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;
	@Embedded
	private Adresse adresse;
	@ManyToMany
	@JoinTable(name="COMPTE_CLIENT",
	joinColumns=@JoinColumn(name="ID_CLIENT", referencedColumnName = "ID"),
	inverseJoinColumns=@JoinColumn(name="ID_COMPTE", referencedColumnName = "ID")
	)
	private Set<Compte> comptes;
	
	public Client() {
		comptes = new HashSet<Compte>();
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 * @return the ardesse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param ardesse the ardesse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the compte
	 */
	public Set<Compte> getCompte() {
		return comptes;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Set<Compte> comptes) {
		this.comptes = comptes;
	}
}
