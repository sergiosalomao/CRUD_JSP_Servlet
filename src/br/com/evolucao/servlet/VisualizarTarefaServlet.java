package br.com.evolucao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tarefa/visualizar")
public class VisualizarTarefaServlet extends HttpServlet{

	private static final long serialVersionUID = 6486671492279082669L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); 
		Integer id = Integer.parseInt(req.getParameter("id"));

		String data = req.getParameter("data");
		String tarefaNome = req.getParameter("tarefa");
		String prioridade = req.getParameter("prioridade");
		String obs = req.getParameter("obs");
		
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
		
		pw.append("<h4> Edita Tarefa </h4>");
		
	
		pw.append("<form action=\"editar\">");
		
		pw.append("<input type=\"hidden\" value="+id+" name=\"id\">");
		
		pw.append("<output for='data'>Data:</output>");
		pw.append("<input id='data' type=\"text\" value=\""+data+"\" class=\"form-control\" name=\"data\"> <br />");
		
		pw.append("<output for='tarefa'>Tarefa:</output>");
		pw.append("<input id='tarefa' type=\"text\" value=\""+tarefaNome+"\" class=\"form-control\" name=\"tarefa\"> <br />");
		
		pw.append("<output for='prio'>Prioridade:</output>");
		pw.append("<select id='prio' class='custom-select' name='prioridade'>");
		pw.append("<option selected value=\"\"+prioridade+\"\">Selecione a prioridade da	Tarefa</option>");
		pw.append("<option value='BAIXA'>BAIXA</option>");
		pw.append("<option value='MEDIA'>MEDIA</option>");
		pw.append("<option value='ALTA'>ALTA</option>");
		pw.append("</select>");
		pw.append("<br/><br/>");
		
		/*pw.append("<input type=\"text\" value=\""+prioridade+"\" class=\"form-control\" name=\"prioridade\"> <br />");*/
		
		pw.append("<output for='obs'>Observações:</output>");
		pw.append("<input id='obs' type=\"text\" value=\""+obs+"\"class=\"form-control\" name=\"obs\"> <br />");
		pw.append("<br/><br/>");
		pw.append("<button type=\"button\">");
		pw.append("<a href=\"http://localhost:8080/JSPTask/tarefa/consultar\">Voltar</a>");
		pw.append("</button>");
		pw.append("<button type=\"submit\">Editar</button>");
		pw.append("</form>");

	}
}
