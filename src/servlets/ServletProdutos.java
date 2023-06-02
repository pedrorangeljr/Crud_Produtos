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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		  
		   
		   if(id == null || id.isEmpty()) {
			   
			   daoProdutos.salvarProdutos(fornecedor);
		   }
		   
		   RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
		   dispatcher.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
