/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class Movimientos {

    private int premios;
    private int escudo;
    public ArrayList<ArrayList<Coordenada>> busqueda = new ArrayList<>();//#Este vector almacena todos los recorridos
    public ArrayList<Coordenada> recorrido;
    Bloque[][] matrix;

    public Movimientos(Coordenada init, Bloque[][] matrix) {
        premios = 0;
        escudo = 0;
        this.recorrido = new ArrayList();
        this.matrix = new Bloque[10][10];
        this.matrix = matrix;
        recorrido.add(init);

    }

    public boolean izquierda() {

        for (int i = 0; i < recorrido.size(); i++) {
            System.out.println("Logica.Movimientos.estubeHay()" + " x = " + recorrido.get(i).getIniciox() + " y = " + recorrido.get(i).getInicioy() + "Tamaño " + recorrido.size());

        }
        int x = 0;
        int y = 0;
        boolean estubehay = false;
        Coordenada ubicacion = new Coordenada();
        boolean salida = false;
        boolean desbordamiento = false;
        int posicion = recorrido.size() - 1;
        boolean compruebarMovimiento = false;
        boolean muro = false;
        Coordenada ultima = recorrido.get(posicion);
        x = ultima.getIniciox();
        y = ultima.getInicioy();
        Bloque partida = matrix[x][y];
        Bloque llegada = new Bloque();

        //Condicion que prueba si ya se aplico esta operacion
        if (x > 0) {
            desbordamiento = true;
            llegada = matrix[(x - 1)][y];
            ubicacion.setIniciox((x - 1));
            ubicacion.setInicioy(y);
            estubehay = estubeHay(ubicacion);
        }
        if (partida.getUltimoMovimiento() == 0) {
            compruebarMovimiento = true;
        }
        //Condicion para probar que no es un muro
        if (llegada.getContenido() != 1) {
            muro = true;
        }

        //Condicion para evitar desbordamiento
        System.out.println("Logica.Movimientos.izquierda() " + desbordamiento + compruebarMovimiento + muro + !estubehay);
        if (desbordamiento && compruebarMovimiento && muro && !estubehay) {
            partida.setUltimoMovimiento(1);
            partida.setContenido(0);
            //#Compruebo si hay un objeto en ese punto
            ObtencionObjetos(llegada);
            llegada.setContenido(2);
            matrix[x][y] = partida;
            matrix[(x - 1)][y] = llegada;
            recorrido.add(ubicacion);
            salida = true;
            print();
        }
        return salida;
    }

    public boolean arriba() {
        int x = 0;
        int y = 0;
        Coordenada ubicacion = new Coordenada();
        boolean salida = false;
        boolean estubehay = false;
        boolean desbordamiento = false;
        int posicion = recorrido.size() - 1;
        boolean compruebarMovimiento = false;
        boolean muro = false;
        Coordenada ultima = recorrido.get(posicion);
        x = ultima.getIniciox();
        y = ultima.getInicioy();
        Bloque partida = matrix[x][y];
        Bloque llegada = new Bloque();
//Control de desbordamieto
        if (y > 0) {
            llegada = matrix[(x)][y - 1];
            desbordamiento = true;
            ubicacion.setIniciox(x);
            ubicacion.setInicioy((y - 1));
            estubehay = estubeHay(ubicacion);
        }
        //Condicion que prueba si ya se aplico esta operacion
        if (partida.getUltimoMovimiento() < 2) {
            compruebarMovimiento = true;
        }
        //Condicion para probar que no es un muro
        if (llegada.getContenido() != 1) {
            muro = true;
        }
        System.out.println("Logica.Movimientos.arriba() " + desbordamiento + compruebarMovimiento + muro + !estubehay);
        if (desbordamiento && compruebarMovimiento && muro && !estubehay) {
            partida.setUltimoMovimiento(2);
            partida.setContenido(0);
            //#Compruebo si hay un objeto en ese punto
            ObtencionObjetos(llegada);
            llegada.setContenido(2);
            matrix[x][y] = partida;
            matrix[(x)][y - 1] = llegada;
            recorrido.add(ubicacion);
            salida = true;

        }

        return salida;
    }

    public boolean derecha() {
        int x = 0;
        int y = 0;
        Coordenada ubicacion = new Coordenada();
        boolean salida = false;
        boolean estubehay = false;
        boolean desbordamiento = false;
        int posicion = recorrido.size() - 1;
        boolean compruebarMovimiento = false;
        boolean muro = false;
        Coordenada ultima = recorrido.get(posicion);
        x = ultima.getIniciox();
        y = ultima.getInicioy();
        Bloque partida = matrix[x][y];
        Bloque llegada = new Bloque();
        if (x < 9) {
            llegada = matrix[(x + 1)][y];
            desbordamiento = true;
            ubicacion.setIniciox((x + 1));
            ubicacion.setInicioy(y);
            estubehay = estubeHay(ubicacion);
        }

        //Condicion que prueba si ya se aplico esta operacion
        if (partida.getUltimoMovimiento() < 3) {
            compruebarMovimiento = true;
        }
        //Condicion para probar que no es un muro
        if (llegada.getContenido() != 1) {
            muro = true;
        }
        //Condicion para evitar desbordamiento
        System.out.println("Logica.Movimientos.derecha() " + desbordamiento + compruebarMovimiento + muro + !estubehay);
        if (desbordamiento && compruebarMovimiento && muro && !estubehay) {
            partida.setUltimoMovimiento(3);
            partida.setContenido(0);
            //#Compruebo si hay un objeto en ese punto
            ObtencionObjetos(llegada);
            //Pongo robot en la pocision de llegada
            llegada.setContenido(2);

            matrix[x][y] = partida;
            matrix[(x + 1)][y] = llegada;
            recorrido.add(ubicacion);
            salida = true;
            print();
        }

        return salida;
    }

    public boolean abajo() {
        int x = 0;
        int y = 0;
        Coordenada ubicacion = new Coordenada();
        boolean desbordamiento = false;
        boolean salida = false;
        int posicion = recorrido.size() - 1;
        boolean compruebarMovimiento = false;
        boolean muro = false;
        boolean estubehay = false;
        Coordenada ultima = recorrido.get(posicion);
        x = ultima.getIniciox();
        y = ultima.getInicioy();
        Bloque partida = matrix[x][y];
        Bloque llegada = new Bloque();

        //Condicion que prueba si ya se aplico esta operacion
        if (partida.getUltimoMovimiento() < 4) {
            compruebarMovimiento = true;
        }
        //Control de desbordamieto
        if (y < 9) {
            desbordamiento = true;
            llegada = matrix[(x)][y + 1];
            ubicacion.setIniciox(x);
            ubicacion.setInicioy((y + 1));
            estubehay = estubeHay(ubicacion);
        }
        //Condicion para probar que no es un muro
        if (llegada.getContenido() != 1) {
            muro = true;
        }
        //Condicion para evitar desbordamiento
        System.out.println("Logica.Movimientos.abajo() " + desbordamiento + compruebarMovimiento + muro + !estubehay);
        if (desbordamiento && compruebarMovimiento && muro && !estubehay) {
            partida.setUltimoMovimiento(1);
            partida.setContenido(0);
            //#Compruebo si hay un objeto en ese punto
            ObtencionObjetos(llegada);
            llegada.setContenido(2);
            matrix[x][y] = partida;
            matrix[(x)][y + 1] = llegada;
            recorrido.add(ubicacion);
            salida = true;
            print();
        }

        return salida;
    }

    void print() {
        //Columnas}
        System.out.println("Pintando Matrix");
        for (int i = 0; i < 10; i++) {
            //Filas
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + matrix[j][i].getContenido() + " |");

            }
            System.out.println("-");
        }
    }

    void clear() {
        //Columnas}
        System.out.println("Limpiando Matrix");
        for (int i = 0; i < 10; i++) {
            //Filas
            for (int j = 0; j < 10; j++) {
                matrix[i][j].setUltimoMovimiento(0);
            }
        }
        Coordenada nuevoPrinciopio = new Coordenada();

        int ultimo = recorrido.size() - 1;
        nuevoPrinciopio = recorrido.get(ultimo);
        busqueda.add(recorrido);
        recorrido.clear();
        recorrido.add(nuevoPrinciopio);
        System.out.println("-");
    }
//Pregunta si ha estado ya en esa casilla

    private boolean estubeHay(Coordenada entrada) {
        boolean salida = false;
        int x = entrada.getIniciox();
        int y = entrada.getInicioy();
        for (int i = 0; i < recorrido.size(); i++) {
            if (x == recorrido.get(i).getIniciox() && y == recorrido.get(i).getInicioy()) {
                salida = true;
            }
            if (9 == recorrido.get(i).getIniciox() && 0 == recorrido.get(i).getInicioy()) {
                JOptionPane.showConfirmDialog(null, i);
            }
            System.out.println("Logica.Movimientos.estubeHay()" + " x = " + recorrido.get(i).getIniciox() + " y = " + recorrido.get(i).getInicioy() + "Tamaño " + recorrido.size());
        }
        return salida;
    }

    boolean ObtencionObjetos(Bloque intro) {
        boolean salida = false;
        if (intro.getContenido() == 6) {
            premios += 1;
            salida = true;
        }
        if (intro.getContenido() == 3) {
            escudo += 1;
            salida = true;
        }

        return salida;
    }

    public int getPremios() {
        return premios;
    }

    public int getEscudo() {
        return escudo;
    }

    public ArrayList<ArrayList<Coordenada>> getBusqueda() {
        return busqueda;
    }

    public ArrayList<Coordenada> getRecorrido() {
        return recorrido;
    }

    public Bloque[][] getMatrix() {
        return matrix;
    }

}
