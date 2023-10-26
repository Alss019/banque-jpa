package banque.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPTE")
@Inheritance(strategy = InheritanceType. JOINED)
public class Compte{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NUMERO",length=100)
	private String numero;
	@Column(name="SOLDE",length=100)
	private double solde;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> client;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	public Compte() {
		operations = new HashSet<Operation>();
		client = new HashSet<Client>();
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", client=" + client + ", operation="
				+ operations + "]";
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/** Getter
	 * @return the compte
	 */
	public Set<Client> getClient() {
		return client;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setClient(Set<Client> client) {
		this.client = client;
	}

	/** Getter
	 * @return the operation
	 */
	public Set<Operation> getOperation() {
		return operations;
	}

	/** Setter
	 * @param operation the operation to set
	 */
	public void setOperation(Set<Operation> operations) {
		this.operations = operations;
	}
}
