package entity;

public class productos {

    private int idproducto;
    private String nombre;
    private double precio;
    private int idcategoria;

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public productos(int idproducto, String nombre, double precio, int idcategoria) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.idcategoria = idcategoria;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
