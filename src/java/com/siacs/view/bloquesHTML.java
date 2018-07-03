/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siacs.view;

import static java.lang.System.out;

/**
 *
 * @author mdcarrion7
 */
public class bloquesHTML {

    public bloquesHTML() {
    }

    public String cabecerahtml() {
        String cabecera = "<header>\n <h1>SIACS</h1>\n </header>";
        return cabecera;
    }

    public String piepaginahtml() {
        String piepagina = "<div class=\"piepagina\">\n"
                + "            <footer>Área de Ciencias de la Salud</footer>\n"
                + "        </div>";
        return piepagina;
    }
    
    public String codigoIns(){
        String codigo = "CSCQI" ;
        return codigo;
    }

}
