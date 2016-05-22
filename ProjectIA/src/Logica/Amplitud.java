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

    int contadorid;
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
        this.contadorid = 0;
    }

    public ArrayList<Bloque> BusquedaAmplitud() {
        while (premios != 2) {
            if (cola.vacio()) {
                System.out.println("Error");
            }
            Bloque n = new Bloque();
            n = cola.pop();
            if (n.getContenido() != 1) {
                // JOptionPane.showMessageDialog(null, "Nodo a expandir " + " X =  " + n.x + " Y = " + n.y);
                System.out.println("-+-+-+-+- " + "Padre " + " X =  " + n.x + " Y = " + n.y + "-+-+-+-+-");
                if (!solucion.contains(n)) {
                    expandir(n);
                    solucion.add(n);
                }
            }
        }
        return solucion;
    }

    void expandir(Bloque entrada) {
        Bloque izq = new Bloque();
        //Comprueba la izquierda

        izq = izquierda(entrada);
        izq = derecha(entrada);
        izq = arriba(entrada);
        izq = bajo(entrada);
    }

    Bloque izquierda(Bloque entrada) {
        contadorid++;
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.x != 0) {
            salida = matrix[(entrada.x - 1)][entrada.y];
            salida.setPadre(entrada.getIdentificador());
            salida.setIdentificador(contadorid);
            if (salida.getContenido() != 1) {
                System.out.println("Izquierda X = " + salida.x + " Y = " + salida.y);
                ObtencionObjetos(salida);
                cola.push(salida);
            }
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
            if (salida.getContenido() != 1) {
                System.out.println("Derecha X = " + salida.x + " Y = " + salida.y);
                ObtencionObjetos(salida);
                cola.push(salida);

            }
        }
        return salida;
    }

    Bloque arriba(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;

        if (entrada.y != 0) {
            salida = matrix[(entrada.x)][(entrada.y - 1)];
            salida.setPadre(entrada.getIdentificador());
            salida.setIdentificador(contadorid);
            if (salida.getContenido() != 1) {
                System.out.println("ARRIBA X = " + salida.x + " Y = " + salida.y);
                ObtencionObjetos(salida);
                cola.push(salida);
            }
        }
        return salida;
    }

    Bloque bajo(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;

        if (entrada.y != 9) {
            salida = matrix[(entrada.x)][(entrada.y + 1)];
            salida.setPadre(entrada.getIdentificador());
            salida.setIdentificador(contadorid);
            if (salida.getContenido() != 1) {
                System.out.println("ABAJO X = " + salida.x + " Y = " + salida.y);
                ObtencionObjetos(salida);
                cola.push(salida);
            }

        }
        return salida;
    }
//Encuentra el objeto

    boolean ObtencionObjetos(Bloque intro) {
        boolean salida = false;

        if (intro.getContenido() == 6 && intro != null) {
            premios += 1;
            JOptionPane.showMessageDialog(null, " Encontro escudo X = " + intro.x + "  Y = " + intro.y);
            print(camino(intro));
            JOptionPane.showMessageDialog(null, " Fin Camino X = " + intro.x + "  Y = " + intro.y);
            matrix[intro.x][intro.y].setContenido(0);
            salida = true;

        }
        if (intro.getContenido() == 3 && intro != null) {
            escudo += 1;
            JOptionPane.showMessageDialog(null, " Encontro escudo X = " + intro.x + "  Y = " + intro.y);
            matrix[intro.x][intro.y].setContenido(0);
            salida = true;
        }

        return salida;
    }

    /*
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
    }*/
    void print(ArrayList<Bloque> n) {
        // System.out.println("Logica.Amplitud.print() camino encontrado");
        for (int i = 0; i < n.size(); i++) {
            System.out.println("Logica solucion" + " x = " + n.get(i).x + " y = " + n.get(i).y + " padre " + n.get(i).getPadre() + " ID " + n.get(i).getIdentificador());
        }

    }

    public Bloque buscarPadre(Bloque nodo) {
        for (int i = 0; i < solucion.size(); i++) {
            if (nodo.getPadre() == solucion.get(i).getIdentificador()) {
                return solucion.get(i);
            }
        }
        return null;
    }

    public ArrayList<Bloque> camino(Bloque input) {
        ArrayList<Bloque> salida = new ArrayList<>();
        Bloque nuevo = new Bloque();
        Bloque padre = new Bloque();
        nuevo = input;
        salida.add(nuevo);

        while (!nuevo.raiz) {

            padre = buscarPadre(nuevo);
            salida.add(padre);
            nuevo = padre;
            System.out.println("Tamaño Solucion "+salida.size());
        }

        return salida;
    }

}
