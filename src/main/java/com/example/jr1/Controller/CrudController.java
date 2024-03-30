package com.example.jr1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jr1.Service.TareasService;
import com.example.jr1.model.Tareas;

@RestController
@RequestMapping("/Tareas")
public class CrudController {
	@Autowired
	private TareasService t;
	@GetMapping("/Read")
	public List<Tareas> get() {
		
		return t.getTareas();
	}
	
	@PostMapping("/Update")
public String update(@RequestParam(name = "ID") int ID,
		@RequestParam(name = "Descripcion") String descripcion,
		@RequestParam(name = "Estado") String estado
		) {
		
		Tareas ta=new Tareas();
		ta.setID(ID);
		ta.setDescripcion(descripcion);
		ta.setEstado(estado);
		
		return t.updateTareas(ta);
	}

@PostMapping("/Delete")
public String delete(@RequestParam(name = "ID") int ID) {
	
	return t.deleteTareas(ID);
}

@PostMapping("/Create")
public String create(
		@RequestParam(name = "Descripcion") String descripcion,
		@RequestParam(name = "Estado") String estado) {
	Tareas ta=new Tareas();
	ta.setDescripcion(descripcion);
	ta.setEstado(estado);
	return t.createTareas(ta);
}

}
