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
    int padre;
    private ArrayList<Bloque> solucion;
    private Bloque stdinicial;

    public Amplitud(Bloque[][] matrix, Bloque Inicial) {
        this.matrix = matrix;
        this.solucion = new ArrayList<>();
        this.cola = new Cola();
        this.stdinicial = new Bloque();
        this.stdinicial = Inicial;
        Inicial.raiz = true;
        this.cola.push(Inicial);
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
                System.out.println("-+-+-+-+- " + "Padre " + " X =  " + n.x + " Y = " + n.y + "  -+-+-+-");
                padre = solucion.size() - 1;
                solucion.add(n);
                expandir(n);
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

        Bloque salida = new Bloque();
        salida = null;
        if (entrada.x != 0) {
            salida = matrix[(entrada.x - 1)][entrada.y];
            salida.setPadre(padre);
            if (salida.getContenido() != 1) {
                ObtencionObjetos(salida);
                System.out.println("IZQ X = " + salida.x + " Y = " + salida.y + " Padre es: " + salida.getPadre());
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
            salida.setPadre(padre);
            if (salida.getContenido() != 1) {
                ObtencionObjetos(salida);
                System.out.println("DER X = " + salida.x + " Y = " + salida.y + " Padre es: " + salida.getPadre());
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
            salida.setPadre(padre);
            if (salida.getContenido() != 1) {
                ObtencionObjetos(salida);
                System.out.println("UP X = " + salida.x + " Y = " + salida.y + " Padre es: " + salida.getPadre());
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
            salida.setPadre(padre);
            if (salida.getContenido() != 1) {
                ObtencionObjetos(salida);
                System.out.println("DOWN X = " + salida.x + " Y = " + salida.y + " Padre es: " + salida.getPadre());
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
            JOptionPane.showMessageDialog(null, " Encontro Bateria X = " + intro.x + "  Y = " + intro.y + " mi padre es: " + intro.getPadre());
            //print(solucion);
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

    void print(ArrayList<Bloque> n) {
        // System.out.println("Logica.Amplitud.print() camino encontrado");
        for (int i = 0; i < n.size(); i++) {
            System.out.println(" Paso:" + i + " x = " + n.get(i).x + " y = " + n.get(i).y + " padre " + n.get(i).getPadre() + " ID " + n.get(i).getIdentificador());
        }

    }

    public Bloque buscarPadre(Bloque nodo) {
        Bloque salida = new Bloque();
        salida = solucion.get(nodo.getPadre());
        return salida;
    }

    public ArrayList<Bloque> camino(Bloque input) {
        ArrayList<Bloque> salida = new ArrayList<>();
        Bloque nuevo = new Bloque();
        nuevo = input;
        salida.add(nuevo);
        for (int i = 0; i < solucion.size(); i++) {
            System.out.println("+++");
            nuevo = buscarPadre(salida.get(salida.size() - 1));
            salida.add(nuevo);
        }
        return salida;
    }

}
