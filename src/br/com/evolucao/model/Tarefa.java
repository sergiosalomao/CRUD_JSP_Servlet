package br.com.evolucao.model;

import java.sql.Date;

public class Tarefa {
	
	private int id;
	private String data;
	private String tarefa;
	private String prioridade;
	private String obs;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}




	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getTarefa() {
		return tarefa;
	}



	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}



	public String getPrioridade() {
		return prioridade;
	}



	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}



	public String getObs() {
		return obs;
	}



	public void setObs(String obs) {
		this.obs = obs;
	}



	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", data=" + data + ", tarefa=" + tarefa + ", prioridade=" + prioridade + ", obs=" + obs +"]";
	}




}
