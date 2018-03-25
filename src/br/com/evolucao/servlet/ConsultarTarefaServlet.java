package br.com.evolucao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.evolucao.dao.TarefaDao;
import br.com.evolucao.model.Tarefa;

@WebServlet("/tarefa/consultar")
public class ConsultarTarefaServlet extends HttpServlet {

	private static final long serialVersionUID = 7170283008736693083L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TarefaDao dao = new TarefaDao();
		PrintWriter pw = resp.getWriter();
		pw.append("<html>");
		
		pw.append("<head>");
		pw.append("<title>");
		pw.append("JSPTask");
		pw.append("</title>");
		pw.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
		pw.append("</head>");

		pw.append("<body>");
		pw.append("<div  class='container'>");
		pw.append("<br />");
		pw.append("<div class='alert alert-success' role='alert'>");
		pw.append("	<h4 class='alert-heading'>JSP TASK 1.0 - Sistema de Cadastro de tarefas WEB.</h4>");
		pw.append("	<hr>");
		pw.append("	<p class='mb-0'>Organize suas tarefas diárias com JSP Task!</p>");
		pw.append("</div>");
		
		pw.append("<h4> Listagem de Tarefas </h4>");
		
		pw.append("<br>");
		
		pw.append("<button type=\"button\" class=\"btn btn-warning btn-sm\" >");
		pw.append("<a href=\"http://localhost:8080/JSPTask/frmTarefas.html\">Nova tarefa</a>");
		pw.append("</button>");
		
		pw.append("<br>");
		pw.append("<br>");
		
		pw.append("<table class='table table-sm'>");
		
		pw.append("<thead>");
		pw.append("<tr>");
		pw.append("<th scope='col'>#</th>");
		pw.append("<th scope='col'>DATA</th>");
		pw.append("<th scope='col'>TAREFA</th>");
		pw.append("<th scope='col'>PRIORIDADE</th>");
		pw.append("<th scope='col'>OBSERVAÇÕES</th>");
		pw.append("<th scope='col'>MENU DE AÇÕES</th>");
		pw.append("</tr>");
		pw.append("</thead>");
		pw.append("<tbody>");
		for (Tarefa tarefa: dao.getTarefas()) {
			pw.append("<tr>");
			pw.append("<td>"+tarefa.getId()+"</td>");
			pw.append("<td>"+tarefa.getData()+"</td>");
			pw.append("<td>"+tarefa.getTarefa()+"</td>");
			pw.append("<td>"+tarefa.getPrioridade()+"</td>");
			pw.append("<td>"+tarefa.getObs()+"</td>");
			pw.append("<td>"
					+ "<button type=\\\"button\\\" class=\\\"btn btn-warning btn-sm\\\" ><a href=\"http://localhost:8080/JSPTask/tarefa/remover?id="+tarefa.getId()+"\">Excluir</a></button>"
					+ "&nbsp;"
					+ "<button type=\\\"button\\\" class=\\\"btn btn-warning btn-sm\\\" ><a href=\"http://localhost:8080/JSPTask/tarefa/visualizar?data="+tarefa.getData()+
					"&tarefa=" + tarefa.getTarefa()+
					"&prioridade=" + tarefa.getPrioridade()+
					"&obs=" + tarefa.getObs()+
					"&id="+tarefa.getId()
					+"\">Alterar</a></button>"
					+ "</td>");
			pw.append("</tr>");
		}
		pw.append("</tbody>");
		pw.append("</table>");
		
		pw.append("</div'>");		
		
		pw.append("<p><span style='font-size:12px'>Developer Sergio Salomão.</span></p>");	
		
		pw.append("</body>");
		
		pw.append("</html>");
	}
}
