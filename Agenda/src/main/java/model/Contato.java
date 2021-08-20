package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Contato.
 */
public class Contato {

	/** The idcon. */
	private String idcon;

	/** The nome. */
	private String nome;

	/** The fone. */
	private String fone;

	/** The email. */
	private String email;

	/**
	 * Instantiates a new contato.
	 */
	public Contato() {
		super();

	}

	/**
	 * Instantiates a new contato.
	 *
	 * @param idcon the idcon
	 * @param nome  the nome
	 * @param fone  the fone
	 * @param email the email
	 */
	public Contato(String idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	/**
	 * Gets the idcon.
	 *
	 * @return the idcon
	 */
	public String getIdcon() {
		return idcon;
	}

	/**
	 * Sets the idcon.
	 *
	 * @param idcon the new idcon
	 */
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "JavaBeans [idcon=" + idcon + ", nome=" + nome + ", fone=" + fone + ", email=" + email + "]";
	}

}
