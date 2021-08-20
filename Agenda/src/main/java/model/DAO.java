package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";

	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbagenda";

	/** The user. */
	private String user = "root";

	/** The password. */
	private String password = "Tm@836405";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 * @throws ClassNotFoundException the class not found exception
	 */
	private Connection conectar() throws ClassNotFoundException {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}
		return null;

	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(Contato contato) {

		String sql = "insert into contatos (nome, fone, email) values (?,?,?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			pst.close();
			con.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<Contato> listarContatos() {

		String sql = "select * from contatos order by nome;";
		ArrayList<Contato> lista = new ArrayList<>();
		try {
			Connection con = conectar();
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				lista.add(new Contato(rs.getString("idcon"), rs.getString("nome"), rs.getString("fone"),
						rs.getString("email")));
			}

			return lista;

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(Contato contato) {
		String sql = "select * from contatos where idcon = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcon(rs.getString("idcon"));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				contato.setEmail(rs.getString("email"));
			}

			con.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(Contato contato) {
		String sql = "update contatos set nome=?, fone=?, email=? where idcon=?;";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Delete contato.
	 *
	 * @param contato the contato
	 */
	public void deleteContato(Contato contato) {

		String sql = "delete from contatos where idcon = ?;";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
