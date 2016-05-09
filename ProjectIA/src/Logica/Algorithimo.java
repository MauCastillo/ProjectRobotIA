/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivo.Leer;
import java.util.ArrayList;

/**
 *
 * @author Soporte
 */
public class Algorithimo {

    private ArrayList<Bloque> visitado;
    private Bloque[][] matrix;
    private Coordenada inicio;
    private Movimientos mover;
    private Bloque[][] tmpMatrix;
    private Bloque[][] inputMatrix;

    public Algorithimo(Bloque[][] matrix,Coordenada iniCoordenada) {
        this.matrix = matrix;
        this.inicio = iniCoordenada;
        mover = new Movimientos(inicio);
        tmpMatrix = new Bloque[10][10];
        inputMatrix = new Bloque[10][10];
        tmpMatrix = matrix;

    }

    public ArrayList<Bloque> BusquedaProfundida() {
        ArrayList<Bloque> salida = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            recorrido();
            
        }

        return salida;
    }

    private boolean recorrido() {
        boolean salida = false;
        inputMatrix = mover.izquierda(matrix);
        inputMatrix = mover.subir(inputMatrix);
        inputMatrix = mover.derecha(inputMatrix);
        inputMatrix = mover.bajar(inputMatrix);
        if (inputMatrix != tmpMatrix) {
            salida = true;
        }

        return salida;
    }

}
