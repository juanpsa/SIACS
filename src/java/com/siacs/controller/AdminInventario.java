/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siacs.controller;

import com.siacs.dao.InsumoDAO;
import com.siacs.dao.MaterialDAO;
import com.siacs.model.Insumo;
import com.siacs.model.Material;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mdcarrion7
 */
public class AdminInventario extends HttpServlet {

    private static final long serialVersionUID = 1L;
    InsumoDAO insumoDAO;
    MaterialDAO materialDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

            insumoDAO = new InsumoDAO(jdbcURL, jdbcUsername, jdbcPassword);
            materialDAO = new MaterialDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInventario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "indexInv":
                    indexInv(request, response);
                    break;
                //CASOS PARA MODIFICAR INSUMOS
                case "nuevo":
                    nuevo(request, response);
                    break;
                case "register":
                    System.out.println("entro");
                    registrar(request, response);
                    break;
                case "mostrar":
                    mostrar(request, response);
                    break;
                case "showedit":
                    showEditar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                //CASOS  PARA MODIFICAR MATERIALES   
                case "nuevoMat":
                    nuevoMat(request, response);
                    break;
                case "registerMat":
                    System.out.println("entro");
                    registrarMat(request, response);
                    break;
                case "mostrarMat":
                    mostrarMat(request, response);
                    break;
                case "showeditMat":
                    showEditarMat(request, response);
                    break;
                case "editarMat":
                    editarMat(request, response);
                    break;
                case "eliminarMat":
                    eliminarMat(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        doGet(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/funcionalidades.jsp");
        dispatcher.forward(request, response);
    }

    private void indexInv(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/inventarioMenu.jsp");
        dispatcher.forward(request, response);
    }

    //BLOQUE DE CONTROL PARA INSUMOS
    //Método para consultar y cargar todos los insumos del inventario 
    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer indice = insumoDAO.obtenerIndex();
        request.setAttribute("indexInsumo", indice);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mostrar.jsp");
        List<Insumo> listaInsumos = insumoDAO.listarInsumos();
        request.setAttribute("lista", listaInsumos);
        System.out.println("retornado");
        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se hace la llamada a la pantalla de registro
    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Integer indice = insumoDAO.obtenerIndex();
        request.setAttribute("indexInsumo", indice);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vistaSIACS/register.jsp");
        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se hace el registro de inventario
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Insumo insumo = new Insumo(0, request.getParameter("codigo"), request.getParameter("nombre"),
                request.getParameter("descripcion"), Integer.parseInt(request.getParameter("cantidad")),
                request.getParameter("ubicacion"), request.getParameter("observaciones"));
        if (insumoDAO.insertar(insumo)) {
            mostrar(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mensajeerror.jsp");
            dispatcher.forward(request, response);
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/funcionalidades.jsp");
//        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se muestra la pantalla para la modificación del inventario
    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Insumo insumo = insumoDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("insumo", insumo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/editar.jsp");
        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se hace la modificación del inventario
    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Insumo insumo = new Insumo(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"), request.getParameter("nombre"),
                request.getParameter("descripcion"), Integer.parseInt(request.getParameter("cantidad")),
                request.getParameter("ubicacion"), request.getParameter("observaciones"));
        if (insumoDAO.actualizar(insumo)) {
            mostrar(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mensajeerror.jsp");
            dispatcher.forward(request, response);
        }
        index(request, response);
    }

    //Método del Servlet desde el cual se hace la eliminación del inventario
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Insumo insumo = insumoDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        if (insumoDAO.eliminar(insumo)) {
            mostrar(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mensajeerror.jsp");
            dispatcher.forward(request, response);
        }
    }

    //BLOQUE DE CONTROL PARA MATERIALES
    private void mostrarMat(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer indiceMat = materialDAO.obtenerIndex();
        request.setAttribute("indexMaterial", indiceMat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mostrarMat.jsp");
        List<Material> listaMateriales = materialDAO.listarMateriales();
        request.setAttribute("listaMat", listaMateriales);
        System.out.println("retornado");
        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se hace la llamada a la pantalla de registro
    private void nuevoMat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Integer indiceMat = materialDAO.obtenerIndex();
        request.setAttribute("indexMaterial", indiceMat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vistaSIACS/registerMat.jsp");
        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se hace el registro de inventario
    private void registrarMat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Insumo insumo = new Insumo(0, request.getParameter("codigo"), request.getParameter("nombre"),
                request.getParameter("descripcion"), Integer.parseInt(request.getParameter("cantidad")),
                request.getParameter("ubicacion"), request.getParameter("observaciones"));
        if (insumoDAO.insertar(insumo)) {
            mostrar(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mensajeerror.jsp");
            dispatcher.forward(request, response);
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/funcionalidades.jsp");
//        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se muestra la pantalla para la modificación del inventario
    private void showEditarMat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Insumo insumo = insumoDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("insumo", insumo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/editar.jsp");
        dispatcher.forward(request, response);
    }

    //Método del Servlet desde el cual se hace la modificación del inventario
    private void editarMat(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Insumo insumo = new Insumo(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"), request.getParameter("nombre"),
                request.getParameter("descripcion"), Integer.parseInt(request.getParameter("cantidad")),
                request.getParameter("ubicacion"), request.getParameter("observaciones"));
        if (insumoDAO.actualizar(insumo)) {
            mostrar(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mensajeerror.jsp");
            dispatcher.forward(request, response);
        }
        index(request, response);
    }

    //Método del Servlet desde el cual se hace la eliminación del inventario
    private void eliminarMat(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Insumo insumo = insumoDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        if (insumoDAO.eliminar(insumo)) {
            mostrar(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaSIACS/mensajeerror.jsp");
            dispatcher.forward(request, response);
        }
    }

}
