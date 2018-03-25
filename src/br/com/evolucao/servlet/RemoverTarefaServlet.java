package br.com.evolucao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.evolucao.dao.TarefaDao;

@WebServlet("/tarefa/remover")
public class RemoverTarefaServlet extends HttpServlet{

	private static final long serialVersionUID = 6486671492279082669L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idTarefa = Integer.parseInt(req.getParameter("id"));
		TarefaDao dao = new TarefaDao();
		dao.remover(idTarefa);
		
		resp.sendRedirect("consultar");
	}
}
