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
 * @author mao
 */
public class Profundida {

    int contadorid;
    Bloque[][] matrix;
    private int premios;
    private int escudo;
    private Cola cola;
    private ArrayList<Bloque> solucion;
    private Bloque stdinicial;

    public Profundida(Bloque[][] matrix, Bloque Inicial) {
        this.matrix = matrix;
        this.solucion = new ArrayList<>();
        this.cola = new Cola();
        this.stdinicial = new Bloque();
        this.stdinicial = Inicial;
        this.cola.push(Inicial);
        this.contadorid = 0;
    }

    public ArrayList<Bloque> BusquedaProfundida() {
        ArrayList<Bloque> salida = new ArrayList<>();
        cola.push(stdinicial);
        while (premios != 1) {
            if (cola.vacio()) {
                System.out.println("Error");
            }
            Bloque n = cola.pop();
            if (ObtencionObjetos(n)) {
                System.out.println("Encontro Un Objeto");
            }
            System.out.println(" X = " + n.x + " Y " + n.y);
            expandir(n);
        }
        return salida;
    }

    boolean estubeHay(Bloque nodo) {
        for (int i = 0; i < solucion.size(); i++) {
            Bloque[] matrix1 = matrix[i];

        }
        return true;
    }

    void expandir(Bloque entrada) {
        Bloque izq = new Bloque();
        int hice = 0;
        //Comprueba la izquierda
        izq = izquierda(entrada);
        if (izq != null && hice == 0) {
            cola.push(izq);
            hice = 1;
        }
        //Comprueba la arriba
        izq = arriba(entrada);
        if (izq != null && hice == 0) {
            cola.push(izq);
            hice = 1;
        }
        //Comprueba la derecha
        izq = derecha(entrada);
        if (izq != null && hice == 0) {
            cola.push(izq);
            hice = 1;
        }

        //Comprueba la abajo
        izq = bajo(entrada);
        if (izq != null && hice == 0) {
            cola.push(izq);
            hice = 1;
        }
    }

    Bloque izquierda(Bloque entrada) {
        Bloque salida = new Bloque();
        contadorid++;
        salida = null;
        if (entrada.x != 0) {
            salida = matrix[(entrada.x - 1)][entrada.y];
            salida.setPadre(entrada.getIdentificador());
            salida.setIdentificador(contadorid);
        }
        return salida;
    }

    Bloque derecha(Bloque entrada) {
        Bloque p = new Bloque();
        p = entrada;
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.x != 9) {
            salida = matrix[(entrada.x + 1)][entrada.y];
            salida.setPadre(entrada.getIdentificador());
            salida.setIdentificador(contadorid);
        }
        return salida;
    }

    Bloque arriba(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.y != 0) {
            salida = matrix[(entrada.x)][entrada.y - 1];
            salida.setPadre(entrada.getIdentificador());
            salida.setIdentificador(contadorid);
        }
        return salida;
    }

    Bloque bajo(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.y != 9) {
            salida = matrix[(entrada.x)][entrada.y + 1];
            salida.setPadre(entrada.getIdentificador());
            salida.setIdentificador(contadorid);
        }
        return salida;
    }
//Encuentra el objeto

    boolean ObtencionObjetos(Bloque intro) {
        boolean salida = false;
        if (intro.getContenido() == 6) {
            premios += 1;
            matrix[intro.x][intro.y].setContenido(0);
            salida = true;

        }
        if (intro.getContenido() == 3) {
            escudo += 1;
            matrix[intro.x][intro.y].setContenido(0);
            salida = true;
        }

        return salida;
    }

    public int buscarPadre(Bloque nodo) {
        for (int i = 0; i < solucion.size(); i++) {
            if (solucion.get(i).getIdentificador() == nodo.getIdentificador()) {
                System.out.println(" padre " + i);
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Bloque> buscarSolucion(Bloque nodo) {
        Bloque fin = new Bloque();
        Bloque analizis = new Bloque();
        analizis = nodo;
        fin = stdinicial;
        ArrayList<Bloque> camino = new ArrayList<>();
        camino.add(analizis);

        int caminosize = 0;
        for (int i = 0; i < solucion.size(); i++) {
            caminosize = camino.size() - 1;
            int ubicacion = buscarPadre(camino.get(caminosize));
            if (ubicacion != -1) {
                camino.add(solucion.get(ubicacion));
            }
        }
        return camino;

    }

    void print(ArrayList<Bloque> n) {
        // System.out.println("Logica.Amplitud.print() camino encontrado");
        for (int i = 0; i < n.size(); i++) {
            System.out.println("Logica.Amplitud.BusquedaAmplitud() " + " x = " + n.get(i).x + " y = " + n.get(i).y + " padre " + n.get(i).getIdentificador());
        }

    }
}
