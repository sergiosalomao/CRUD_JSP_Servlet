package br.com.evolucao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.evolucao.model.Tarefa;

public class TarefaDao {
	
	public void salvar(Tarefa tarefa) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "insert into tb_tarefa (data,tarefa,prioridade,obs) values (?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, tarefa.getData());
			ps.setString(2, tarefa.getTarefa());
			ps.setString(3, tarefa.getPrioridade());
			ps.setString(4, tarefa.getObs());
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Erro ao salvar o registro!");
		}
	}
	
	public void editar(Tarefa tarefa) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "update tb_tarefa set data=?, tarefa=?, prioridade=?, obs=? where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, tarefa.getData());
			ps.setString(2, tarefa.getTarefa());
			ps.setString(3, tarefa.getPrioridade());
			ps.setString(4, tarefa.getObs());
			
			ps.setInt(2, tarefa.getId());
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Erro ao salvar o registro!");
		}
	}
	
	public void remover(Integer idtarefa) {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "delete from tb_tarefa where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idtarefa);
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Erro ao remover registro!");
		}
	}

	public List<Tarefa> getTarefas(){
		List<Tarefa> tarefas = new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_tarefa";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String data =  resultSet.getString("data");
				String tarefaNome = resultSet.getString("tarefa");
				String prioridade = resultSet.getString("prioridade");
				String obs = resultSet.getString("obs");
				
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(id);
				tarefa.setData(data);
				tarefa.setTarefa(tarefaNome);
				tarefa.setPrioridade(prioridade);
				tarefa.setObs(obs);
				
				tarefas.add(tarefa);
			}
			connection.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao pegar a lista registros!");
		}
		
		return tarefas;
	}
	
}
