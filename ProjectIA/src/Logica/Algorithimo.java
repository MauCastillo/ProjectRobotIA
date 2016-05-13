/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Graficos.UsuarioVisual;
import java.util.ArrayList;
import Recursos.IcoRecurso;
import javax.swing.JOptionPane;

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
        int numeroPremios = mover.getPremios();
        while(numeroPremios != 2){
        do {
                movimientos = recorrido();
                userGrafica.creacionBotones(matrix);        
        } while (movimientos);
        mover.clear();
        }
        System.out.println("--------------------------Nomeros de Objetivos ------------------- " +numeroPremios);
        JOptionPane.showMessageDialog(userGrafica, this, "Ganaste", numeroPremios, IcoRecurso.ICON_GANADOR);
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
