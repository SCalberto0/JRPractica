package com.example.jr1.Service;
import com.example.jr1.DAO.ConexionController;
import com.example.jr1.DAO.TablasRepositorio;
import com.example.jr1.model.Tareas;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TareasService {
	
	public List<Tareas> getTareas(){
		TablasRepositorio repo=new TablasRepositorio();
		return repo.getTareas();
	}
	
	public String createTareas(Tareas t){
		TablasRepositorio repo=new TablasRepositorio();
		if(t.getEstado().equals("pendiente") || t.getEstado().equals("en progreso")
				|| t.getEstado().equals("completada")) {
			return repo.createTareas(t);
		}else {
			return "Parametro de estado incorrecto";
		}
		
	}
	
	public String updateTareas(Tareas t){
		TablasRepositorio repo=new TablasRepositorio();
		if((t.getEstado().equals("pendiente") || t.getEstado().equals("en progreso")
				|| t.getEstado().equals("completada")) && t.getID()>0) {
			return repo.updateTareas(t);
		}else {
			return "Parametro de estado incorrecto o valor de ID no valido";
		}
		
	}
	
	public String deleteTareas(int ID){
		TablasRepositorio repo=new TablasRepositorio();
		if(ID >0) {
		return repo.deleteTareas(ID);
		}else{
			return "Valor de ID no valido";
		}
	}

}
