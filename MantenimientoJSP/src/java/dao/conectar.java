/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utilitarios.Conexion;

/**
 *
 * @author Cesar´s
 */
public class conectar extends Conexion{

    public conectar() {
        super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mantenimiento1", "root", "");
    } 
}
