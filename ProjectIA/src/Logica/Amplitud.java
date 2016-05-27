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
        Inicial.raiz = true;
        Inicial.setUltimoMovimiento("raiz");
        Inicial.setPadre(Inicial);
        this.cola.push(Inicial);
        //this.solucion.add(Inicial);

    }

    public ArrayList<Bloque> BusquedaAmplitud() {
        while (premios != 2) {
            if (cola.vacio()) {
                System.out.println("Error");
            }
            Bloque n = new Bloque();
            n = cola.pop();
            if (n.getContenido() != 1) {
                //Para evitar ciclos pendejos

                System.out.println(" <<Padre>> +  X =  " + n.x + " Y = " + n.y + "  -+-+-+-");
                solucion.add(n);
                expandir(n);

            }
        }
        return solucion;
    }

    void expandir(Bloque entrada) {
        //Comprueba la izquierda
        izquierda(entrada);
        derecha(entrada);
        arriba(entrada);
        bajo(entrada);
    }

    Bloque izquierda(Bloque entrada) {

        Bloque salida = new Bloque();
        salida = null;
        if (entrada.x != 0) {

            /* para No realizar la expacion de su padre
             */
            if (!entrada.getUltimoMovimiento().equals("derecha")) {
                salida = matrix[(entrada.x - 1)][entrada.y];
                salida.setUltimoMovimiento("izquierda");
                salida.setPadre(entrada);
                if (!solucion.contains(salida)) {
                    if (salida.getContenido() != 1) {

                        System.out.println("IZQ X = " + salida.x + " Y = " + salida.y + " Padre es: " + salida.getPadre().x);
                        cola.push(salida);
                        ObtencionObjetos(salida);
                        solucion.add(salida);
                    }
                }
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
            /* para No realizar la expacion de su padre
             */
            if (!entrada.getUltimoMovimiento().equalsIgnoreCase("izquierda")) {
                salida = matrix[(entrada.x + 1)][entrada.y];
                salida.setPadre(entrada);
                salida.setUltimoMovimiento("derecha");
                if (!solucion.contains(salida)) {
                    if (salida.getContenido() != 1) {

                        System.out.println("DER X = " + salida.x + " Y = " + salida.y + " Padre es: x " + entrada.x + " y " + entrada.y);
                        cola.push(salida);
                        ObtencionObjetos(salida);
                        solucion.add(salida);
                    }
                }
            }
        }
        return salida;
    }

    Bloque arriba(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.y != 0) {
            /* para No realizar la expacion de su padre
             */
            if (!entrada.getUltimoMovimiento().equalsIgnoreCase("abajo")) {
                salida = matrix[(entrada.x)][(entrada.y - 1)];
                salida.setPadre(entrada);
                salida.setUltimoMovimiento("arriba");
                if (!solucion.contains(salida)) {
                    if (salida.getContenido() != 1) {

                        System.out.println("UP X = " + salida.x + " Y = " + salida.y + " Padre es: " + salida.getPadre());
                        cola.push(salida);
                        ObtencionObjetos(salida);
                        solucion.add(salida);
                    }
                }
            }
        }
        return salida;
    }

    Bloque bajo(Bloque entrada) {
        Bloque salida = new Bloque();
        salida = null;
        if (entrada.y != 9) {
            /* para No realizar la expacion de su padre
             */
            if (!entrada.getUltimoMovimiento().equalsIgnoreCase("arriba")) {
                salida = matrix[(entrada.x)][(entrada.y + 1)];
                salida.setPadre(entrada);
                salida.setUltimoMovimiento("abajo");
                if (!solucion.contains(salida)) {
                    if (salida.getContenido() != 1) {

                        System.out.println("DOWN X = " + salida.x + " Y = " + salida.y + " Padre es: " + salida.getPadre());
                        cola.push(salida);
                        ObtencionObjetos(salida);
                        solucion.add(salida);

                    }
                }
            }
        }
        return salida;
    }
//Encuentra el objeto

    boolean ObtencionObjetos(Bloque intro) {
        boolean salida = false;

        if (intro.getContenido() == 6) {
            premios += 1;
            JOptionPane.showMessageDialog(null, " Encontro Bateria X = " + intro.x + "  Y = " + intro.y + " mi padre es: " + intro.getPadre() + "Ultimo Operador" + intro.getUltimoMovimiento());
            Imprimir(camino(intro));
            matrix[intro.x][intro.y].setContenido(0);
            /*cola.clear();
            Bloque nuevo_inicio = new Bloque();
            nuevo_inicio = intro;
            nuevo_inicio.raiz = true;
            nuevo_inicio.setUltimoMovimiento("raiz");
            cola.push(nuevo_inicio);*/
            salida = true;

        }
        if (intro.getContenido() == 3) {
            escudo += 1;
            JOptionPane.showMessageDialog(null, " Encontro escudo X = " + intro.x + "  Y = " + intro.y);
            matrix[intro.x][intro.y].setContenido(0);
            salida = true;
        }

        return salida;
    }

    void Imprimir(ArrayList<Bloque> n) {
        // System.out.println("Logica.Amplitud.print() camino encontrado");
        for (int i = 0; i < n.size(); i++) {
            System.out.println(" Paso:" + i + " x = " + n.get(i).x + " y = " + n.get(i).y + " padre " + n.get(i).getUltimoMovimiento() + " ID " + n.get(i).getIdentificador());
        }

    }

    public ArrayList<Bloque> camino(Bloque input) {
        ArrayList<Bloque> salida = new ArrayList<>();
        Bloque nuevo = new Bloque();
        nuevo = input;
        salida.add(nuevo);
        int i = 0;
       // while ((!nuevo.raiz) || nuevo.getUltimoMovimiento().equals("raiz")) {
       while (i <12){
            System.out.println("+0+");
            nuevo = nuevo.getPadre();
            //nuevo = buscarPadre(salida.get(index));
            salida.add(nuevo);
            i++;
        }
        return salida;
    }

}
