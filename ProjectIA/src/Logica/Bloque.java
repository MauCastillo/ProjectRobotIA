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

    public Bloque() {
        this.contenido = 0;
        this.ultimoMovimiento = 0;
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

}
