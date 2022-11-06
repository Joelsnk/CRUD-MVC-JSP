package com.galford.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaLibroImpl implements IConsultaLibro {

	private Connection objConexion;

	public ConsultaLibroImpl() {
		objConexion = Conexion.Conectar();
	}

	@Override
	public void Agregar(Libro objLibro) {
		String sqlAgregar = "INSERT INTO libro(nombre, genero, autor) VALUES (?,?,?)";
		try {
			PreparedStatement objPreparedStatement = objConexion.prepareStatement(sqlAgregar);
			objPreparedStatement.setString(1, objLibro.getNombre());
			objPreparedStatement.setString(2, objLibro.getGenero());
			objPreparedStatement.setString(3, objLibro.getAutor());
			objPreparedStatement.execute();
			objPreparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Eliminar(int id) {
		String sqlEliminar = "DELETE FROM libro WHERE id = ?";
		try {
			PreparedStatement objPreparedStatement = objConexion.prepareStatement(sqlEliminar);
			objPreparedStatement.setInt(1, id);
			objPreparedStatement.execute();
			objPreparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Actualizar(Libro objLibro) {
		String sqlActualizar = "UPDATE libro SET nombre = ?, genero = ?, autor = ? WHERE id = ?";
		try {
			PreparedStatement objPreparedStatement = objConexion.prepareStatement(sqlActualizar);
			objPreparedStatement.setString(1, objLibro.getNombre());
			objPreparedStatement.setString(2, objLibro.getGenero());
			objPreparedStatement.setString(3, objLibro.getAutor());
			objPreparedStatement.setInt(4, objLibro.getId());
			objPreparedStatement.execute();
			objPreparedStatement.close();
		} catch (Exception e) {
		}
	}

	@Override
	public List<Libro> ListarTodoLibro() {
		List<Libro> listLibro = new ArrayList<>();
		String sqlListaCompleta = "SELECT * FROM libro ORDER BY id ASC";
		try {
			Statement objStatement = objConexion.createStatement();
			ResultSet objResultSet = objStatement.executeQuery(sqlListaCompleta);
			while(objResultSet.next()) {
				Libro objLibro = new Libro();
				objLibro.setId(objResultSet.getInt("id"));
				objLibro.setNombre(objResultSet.getString("nombre"));
				objLibro.setGenero(objResultSet.getString("genero"));
				objLibro.setAutor(objResultSet.getString("autor"));
				listLibro.add(objLibro);
				}
			objStatement.close();
			objResultSet.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listLibro;
	}

	@Override
	public Libro ListarLibroId(int id) {
		String sqlListarId = "SELECT * FROM libro WHERE id = ?";
		Libro objLibro = new Libro();
		try {
			PreparedStatement objPreparedStatement = objConexion.prepareStatement(sqlListarId);
			objPreparedStatement.setInt(1, id);
			ResultSet objResultSet = objPreparedStatement.executeQuery();
			while(objResultSet.next()) {
				objLibro.setId(objResultSet.getInt("id"));
				objLibro.setNombre(objResultSet.getString("nombre"));
				objLibro.setGenero(objResultSet.getString("genero"));
				objLibro.setAutor(objResultSet.getString("autor"));
			}
			objPreparedStatement.close();
			objResultSet.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return objLibro;
	}

	@Override
	public List<Libro> ListaBusquedaLibro(String buscar) {
		List<Libro> listLibro = new ArrayList<>();
		String sqlBuscar = "SELECT * FROM libro WHERE nombre LIKE '?' OR genero LIKE '?' OR autor LIKE '?'";
		try {
			PreparedStatement objPreparedStatement = objConexion.prepareStatement(sqlBuscar);
			objPreparedStatement.setString(1,buscar);
			objPreparedStatement.setString(2,buscar);
			objPreparedStatement.setString(3,buscar);
			ResultSet objResultSet = objPreparedStatement.executeQuery();
			while(objResultSet.next()) {
				Libro objLibro = new Libro();
				objLibro.setId(objResultSet.getInt("id"));
				objLibro.setNombre(objResultSet.getString("nombre"));
				objLibro.setGenero(objResultSet.getString("genero"));
				objLibro.setAutor(objResultSet.getString("autor"));
				listLibro.add(objLibro);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listLibro;
	}

}
