package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.DAO;

/**
 * The Class Controller.
 */
//Recebe as requisições pelo nome da ação do formulário.
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dao. */
	DAO dao = new DAO();

	/** The contato. */
	Contato contato = new Contato();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	/* Método principal */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		// String que conterá o caminho
		String action = request.getServletPath();
		// Teste de recebimento de requisições
//		System.out.println(action);

		// Se o caminho for /main, chama a página contatos;
		if (action.equals("/main")) {

			contatos(request, response);

		} else if (action.equals("/insert")) {
			adicionarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			deletarContato(request, response);
		} else {
			// Se for qualquer coisa, vai pra index.
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Contatos.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	/* Método que chama a página "agenda.jsp" */
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Contato> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);

		// Trabalha com requisições e respostas.
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		// Encaminha a lista ao documento agenda.jsp
		rd.forward(request, response);
	}

	/**
	 * Adicionar contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	/* Seta contato e redireciona para agenda. */
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.inserirContato(contato);
		response.sendRedirect("main");

	}

	/**
	 * Listar contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	/* LIstar contatos */
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setIdcon(request.getParameter("idcon"));
		dao.selecionarContato(contato);

		// Setando os campos com os atributos do contato
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());

		// Encaminha os dados da classe ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	/**
	 * Editar contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.alterarContato(contato);
		// Redirecionando para o documento o documento agenda.jsp atualizando as
		// alterações
		response.sendRedirect("main");
	}

	/**
	 * Deletar contato.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void deletarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recebendo idcon do arquivo confirmador.js
		contato.setIdcon(request.getParameter("idcon"));
		dao.deleteContato(contato);
		// Em vez de chamar a página agenda.jsp, chamamos o caminho main, pois esse
		// caminho chama "listarContatos", fazendo a atualização dos contatos.
		response.sendRedirect("main");
	}

}
