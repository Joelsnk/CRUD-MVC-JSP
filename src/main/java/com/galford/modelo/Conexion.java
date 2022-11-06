package com.galford.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	protected static Connection objConexion;

	public static Connection Conectar() {
		if (objConexion != null) {
			return objConexion;
		}
		try {
			String url = "jdbc:postgresql://localhost:5433/LibrosBD";
			String user = "postgres";
			String password = "password";
			objConexion = DriverManager.getConnection(url, user, password);
			System.out.println("Se conectó a la Base de Datos.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se puedo conectar.");
		}
		return objConexion;
	}

	public static void Desconectar() {
		if (objConexion == null) {
			return;
		}
		try {
			objConexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
