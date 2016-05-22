/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Mauro
 */
public class Bloque {

   private  int contenido;
   private int ultimoMovimiento;
   private  int padre;
   private int identificador;
   public int x = 0;
   public int y = 0;

    public Bloque() {
        this.contenido = 0;
        this.ultimoMovimiento = 0;
       // this.padre = new Bloque();
    }

    public int getUltimoMovimiento() {
        return ultimoMovimiento;
    }

    public void setUltimoMovimiento(int ultimoMovimiento) {
        this.ultimoMovimiento = ultimoMovimiento;
    }

    public Bloque(int contenido) {
        this.contenido = contenido;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

}
