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
public class Amplitud {

    Bloque[][] matrix;
    private int premios;
    private int escudo;
    private Cola cola;
    private ArrayList<Bloque> solucion;
    private Bloque stdinicial;

    public Amplitud(Bloque[][] matrix, Bloque Inicial) {
        this.matrix = matrix;
        this.solucion = new ArrayList<>();
        this.cola = new Cola();
        this.stdinicial = new Bloque();
        this.stdinicial = Inicial;
        this.cola.push(Inicial);
    }

    public ArrayList<Bloque> BusquedaAmplitud() {
        ArrayList<Bloque> salida = new ArrayList<>();
        while (premios < 2) {
            if (cola.vacio()) {
                System.out.println("Error");
            }
            Bloque n = new Bloque();
            n = cola.pop();
            if (ObtencionObjetos(n)) {
                buscardolucion(n);
                printf(solucion);
                JOptionPane.showMessageDialog(null, "Encontro Algo");
            }
            if (n.getContenido() != 1) {
                expandir(n);
                solucion.add(n);
            }
        }
        return salida;
    }

    void expandir(Bloque entrada) {
        Bloque izq = new Bloque();
        //Comprueba la izquierda
        izq = izquierda(entrada);
        if (izq != null) {
            cola.push(izq);
        }
        //Comprueba la derecha
        izq = derecha(entrada);
        if (izq != null) {
            cola.push(izq);
        }
        //Comprueba la arriba
        izq = arriba(entrada);
        if (izq != null) {
            cola.push(izq);
        }
        //Comprueba la abajo
        izq = bajo(entrada);
        if (izq != null) {
            cola.push(izq);
        }
    }

    Bloque izquierda(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.x > 0 && entrada.getContenido() != 1) {
            salida = matrix[(entrada.x - 1)][entrada.y];
            salida.setPadre(entrada.getIdentificador());
        }
        return salida;
    }

    Bloque derecha(Bloque entrada) {
        Bloque p = new Bloque();
        p = entrada;
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.x < 9 && entrada.getContenido() != 1) {
            salida = matrix[(entrada.x + 1)][entrada.y];
            salida.setPadre(entrada.getIdentificador());
        }
        return salida;
    }

    Bloque arriba(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.y > 0 && entrada.getContenido() != 1) {
            salida = matrix[(entrada.x)][entrada.y - 1];
            salida.setPadre(entrada.getIdentificador());
        }
        return salida;
    }

    Bloque bajo(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.y < 9 && entrada.getContenido() != 1) {
            salida = matrix[(entrada.x)][entrada.y + 1];
            salida.setPadre(entrada.getIdentificador());
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

    public int buscarPadre(Bloque nodo) {
        for (int i = 0; i < solucion.size(); i++) {
            if (solucion.get(i).getIdentificador() == nodo.getIdentificador()) {
                System.out.println(" padre " + i);
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Bloque> buscardolucion(Bloque nodo) {
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
        printf(camino);
        return camino;
    }

    void printf(ArrayList<Bloque> n) {
        System.out.println("Logica.Amplitud.print() camino encontrado");
        for (int i = 0; i < n.size(); i++) {
            System.out.println("Logica.Amplitud.BusquedaAmplitud() " + " x = " + n.get(i).x + " y = " + n.get(i).y + " padre " + n.get(i).getIdentificador());

        }

    }
}
