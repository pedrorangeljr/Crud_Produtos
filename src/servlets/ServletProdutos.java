package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoProdutos;
import model.Fornecedor;

@WebServlet("/ServletProdutos")
public class ServletProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoProdutos daoProdutos = new DaoProdutos();

	public ServletProdutos() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String acao = request.getParameter("acao");
			String fornecedor = request.getParameter("fornecedor");

			if (acao.equalsIgnoreCase("delete")) {

				daoProdutos.deletar(fornecedor);

				RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
				request.setAttribute("fornecedores", daoProdutos.listar());
				dispatcher.forward(request, response);
				
			} else if (acao.equalsIgnoreCase("editar")) {

				Fornecedor fornecedores = daoProdutos.consultar(fornecedor);

				RequestDispatcher dispatcher = request.getRequestDispatcher("adicionarProdutos.jsp");
				request.setAttribute("fornecedores", fornecedores);
				dispatcher.forward(request, response);
			}

			else if (acao.equalsIgnoreCase("listarTodos")) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
				request.setAttribute("fornecedores", daoProdutos.listar());
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String id = request.getParameter("id");
			String produto = request.getParameter("produto");
			String categoria = request.getParameter("categoria");
			float valor = Float.parseFloat(request.getParameter("valor"));

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			fornecedor.setProduto(produto);
			fornecedor.setCategoria(categoria);
			fornecedor.setValor(valor);
			
			if(id == null || id.isEmpty() && !daoProdutos.validarProdutos(produto)) {
				
				request.setAttribute("mensagem", "Já existe produto com o mesmo nome");
			}
			
			else if (id == null || id.isEmpty()) {

				daoProdutos.salvarProdutos(fornecedor);
			}
			
			
			
			else if(id != null && !id.isEmpty() ) {
				
				daoProdutos.atualizar(fornecedor);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
			request.setAttribute("fornecedores", daoProdutos.listar());
			dispatcher.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
