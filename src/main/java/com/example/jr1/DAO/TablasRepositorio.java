package com.example.jr1.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.jr1.model.Tareas;

public class TablasRepositorio {
	
	
	public List<Tareas> getTareas(){
		
		ArrayList<Tareas> tareas=new ArrayList<>();
		try{
			Connection con=ConexionController.getInstance();
			 String sql = "{call getTareas()}";
			 
			 CallableStatement cstmt =con.prepareCall(sql);
			// cstmt.setString(1, "");
			// cstmt.registerOutParameter(4, Types.INTEGER);
			// cstmt.executeQuery();
			 ResultSet rs= cstmt.executeQuery(); 
	         // int  respuesta = cstmt.getInt(4);
		while (rs.next()) {
			Tareas t=new Tareas();
			t.setID(rs.getInt("ID"));
			t.setDescripcion(rs.getString("Descripcion"));
			t.setEstado(rs.getString("Estado"));
			tareas.add(t);
			
		}

		}catch(Exception e) {
			
			System.out.println(e);
		}
		return tareas;
	}
	
	public String createTareas(Tareas t){
		String respuesta="Error en creacion";
		try {
		
		Connection con=ConexionController.getInstance();
		 String sql = "{call createTareas(?,?,?)}";
		 CallableStatement cstmt =con.prepareCall(sql);
		 cstmt.setString(1, t.getDescripcion());
		 cstmt.setString(2, t.getEstado());
		 cstmt.registerOutParameter(3, Types.INTEGER);
		 cstmt.executeQuery();
		 int r=cstmt.getInt(3);
		 cstmt.close();
		 if(r>0)
			 respuesta="Tarea Creada";
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return respuesta;
	}
	
	
	public String updateTareas(Tareas t){
		String respuesta="Error en actualizacion";
		try {
		
		Connection con=ConexionController.getInstance();
		 String sql = "{call updateTareas(?,?,?,?)}";
		 CallableStatement cstmt =con.prepareCall(sql);
		 cstmt.setInt(1, t.getID());
		 cstmt.setString(2, t.getDescripcion());
		 cstmt.setString(3, t.getEstado());
		 cstmt.registerOutParameter(4, Types.INTEGER);
		 cstmt.executeQuery();
		 int r=cstmt.getInt(4);
		 cstmt.close();
		 if(r>0)
			 respuesta="Tarea Actualizada";
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return respuesta;
	}
	
	public String deleteTareas(int id){
		String respuesta="Error en Eliminacion";
		try {
		
		Connection con=ConexionController.getInstance();
		 String sql = "{call deleteTareas(?,?)}";
		 CallableStatement cstmt =con.prepareCall(sql);
		 cstmt.setInt(1, id);
		 cstmt.registerOutParameter(2, Types.INTEGER);
		 cstmt.executeQuery();
		 int r=cstmt.getInt(2);
		 cstmt.close();
		 if(r>0)
			 respuesta="Tarea Eliminada";
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return respuesta;
	}
	
	

}
