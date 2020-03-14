package dao;

import utilitarios.Conexion;

public class conectar extends Conexion {

    public conectar() {
        super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mantenimiento1", "root", "");
    }
}
