package com.galford.modelo;

import java.util.List;

public interface IConsultaLibro {

	public void Agregar(Libro objLibro);
	public void Eliminar(int id);
	public void Actualizar(Libro objLibro);
	public List<Libro> ListarTodoLibro();
	public Libro ListarLibroId(int id);
	public List<Libro> ListaBusquedaLibro(String buscar);
	
} 
