package com.galford.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.galford.modelo.ConsultaLibroImpl;
import com.galford.modelo.IConsultaLibro;
import com.galford.modelo.Libro;

@WebServlet("/ControladorLibro")
public class ControladorLibro extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IConsultaLibro objIConsultaLibro = new ConsultaLibroImpl();
		String redireccion = "";
		String accion = req.getParameter("accion");
		if (accion.equalsIgnoreCase("Principal")) {
			redireccion = "index.jsp";
		}
		if (accion.equalsIgnoreCase("Listar")) {
			redireccion = "com.galford.vista/ListarLibro.jsp";
			req.setAttribute("listLibro", objIConsultaLibro.ListarTodoLibro());
		}
		if (accion.equalsIgnoreCase("Actualizar")) {
			redireccion = "com.galford.vista/EditarLibro.jsp";
			//redireccion = "com.galford.vista/Actualizar.jsp";
			int id = Integer.parseInt(req.getParameter("id"));
			Libro objLibro = objIConsultaLibro.ListarLibroId(id);
			req.setAttribute("libro", objLibro);
		}
		if (accion.equalsIgnoreCase("Agregar")) {
			redireccion = "com.galford.vista/EditarLibro.jsp";
		}
		if(accion.equalsIgnoreCase("Eliminar")) {
			redireccion = "com.galford.vista/ListarLibro.jsp";
			int id = Integer.parseInt(req.getParameter("id"));
			objIConsultaLibro.Eliminar(id);
			req.setAttribute("listLibro", objIConsultaLibro.ListarTodoLibro());
		}
		if(accion.equalsIgnoreCase("Buscar")) {
			redireccion = "com.galford.vista/ListarLibro.jsp";
			String buscar = req.getParameter("buscar");
			req.setAttribute("listLibro", objIConsultaLibro.ListaBusquedaLibro(buscar));
		}
		RequestDispatcher objVista = req.getRequestDispatcher(redireccion);
		objVista.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IConsultaLibro objIConsultaLibro = new ConsultaLibroImpl();
		Libro objLibro = new Libro();
		objLibro.setNombre(req.getParameter("nombre"));
		objLibro.setGenero(req.getParameter("genero"));
		objLibro.setAutor(req.getParameter("autor"));
		String id = req.getParameter("id");
		if (id == null || id.isEmpty()) {
			objIConsultaLibro.Agregar(objLibro);
		} else {
			objLibro.setId(Integer.parseInt(req.getParameter("id")));
			objIConsultaLibro.Actualizar(objLibro);
		}
		req.setAttribute("listLibro", objIConsultaLibro.ListarTodoLibro());
		RequestDispatcher objVista = req.getRequestDispatcher("com.galford.vista/ListarLibro.jsp");
		objVista.forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
