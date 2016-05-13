/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Graficos.UsuarioVisual;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Soporte
 */
public class Algorithimo {

    private ArrayList<Bloque> visitado;
    private Bloque[][] matrix;
    private Coordenada inicio;
    private Movimientos mover;
    UsuarioVisual userGrafica;

    public Algorithimo(Bloque[][] matrix, Coordenada iniCoordenada,UsuarioVisual graficauser) {
        this.matrix = matrix;
        this.inicio = iniCoordenada;
        this.userGrafica = graficauser;
        mover = new Movimientos(inicio, matrix);


    }

    public ArrayList<Bloque> BusquedaProfundida() {
        ArrayList<Bloque> salida = new ArrayList<>();
        boolean movimientos = false;
        /*Este ciclo prueba si ya no hay mas movimientos*/
        do {
                movimientos = recorrido();
                userGrafica.creacionBotones(matrix);        
        } while (movimientos);
        mover.clear();
        return salida;
    }
//Esta funcion sigue la secuencia y ademas retorno si hubo cambios

    private boolean recorrido() {
        boolean salida = false;
        boolean izquierda = mover.izquierda();
        boolean arriba = mover.arriba();
        boolean derecha = mover.derecha();
        boolean abajo = mover.abajo();
        if (izquierda || arriba || derecha || abajo) {
            salida = true;
        }
        return salida;
    }
}
