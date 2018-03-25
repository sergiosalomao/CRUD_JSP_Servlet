package br.com.evolucao.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.evolucao.dao.TarefaDao;

import br.com.evolucao.model.Tarefa;

@WebServlet("/tarefa/cadastrar")
public class CadastrarTarefaServlet extends HttpServlet{

	private static final long serialVersionUID = 6486671492279082669L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String data = request.getParameter("data");
		String tarefaNome = request.getParameter("tarefa");
		String prioridade = request.getParameter("prioridade");
		String obs = request.getParameter("obs");
		
		
		
		TarefaDao dao = new TarefaDao();
		Tarefa tarefa = new Tarefa();
		
		tarefa.setData(data);
		tarefa.setTarefa(tarefaNome);
		tarefa.setPrioridade(prioridade);
		tarefa.setObs(obs);
		
		dao.salvar(tarefa);
		
		resp.sendRedirect("consultar");
	}
}
