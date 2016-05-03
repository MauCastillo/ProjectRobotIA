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
public class Movimientos {

    Coordernada ubicacion = new Coordernada();

    public Movimientos(Coordernada ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Bloque[][] subir(Bloque[][] entrada) {
        /*Donde xy de entrada es al pocision del robot en ese momento*/
        //Verifico la disponibilidad de espacion
        int x = ubicacion.getIniciox();
        int y = ubicacion.getInicioy();
        Bloque[][] salida = new Bloque[10][10];
        salida = entrada;
        if (y <= 10 && y > 0) {
            int subida = y - 1;
            Bloque llegada = entrada[x][subida];
            System.out.println("Logica.Movimientos.subir() " + llegada.getContenido() );
            if (llegada.getContenido() != 1 && llegada.getUltimoMovimiento() < 2) {
                salida[x][subida].setContenido(2);
                salida[x][y].setContenido(0);
                salida[x][subida].setUltimoMovimiento(2);
                ubicacion.setIniciox(x);
                ubicacion.setInicioy(subida);
            }
        }
        print(salida);
        return salida;
    }

    public Bloque[][] bajar(Bloque[][] entrada) {
        /*Donde xy de entrada es al pocision del robot en ese momento*/
        int x = ubicacion.getIniciox();
        int y = ubicacion.getInicioy();
        //Verifico la disponibilidad de espacion
        Bloque[][] salida = new Bloque[10][10];
        salida = entrada;
        if (y < 10 && y >= 0) {
            //impido que se desvorde
            int bajada = y + 1;
            Bloque llegada = entrada[x][bajada];
            System.out.println("Logica.Movimientos.bajar() " + llegada.getContenido() );
            if (llegada.getContenido() != 1 && llegada.getUltimoMovimiento() < 4) {
                salida[x][bajada].setContenido(2);
                salida[x][y].setContenido(0);
                salida[x][bajada].setUltimoMovimiento(4);
                ubicacion.setIniciox(x);
                ubicacion.setInicioy(bajada);
            }
        }
        print(salida);
        return salida;
    }

    public Bloque[][] derecha(Bloque[][] entrada) {
        /*Donde xy de entrada es al pocision del robot en ese momento*/
        int x = ubicacion.getIniciox();
        int y = ubicacion.getInicioy();
        //Verifico la disponibilidad de espacion
        Bloque[][] salida = new Bloque[10][10];
        salida = entrada;
        if (x < 10 && x >= 0) {
            //impido que se desvorde
            int derecha = x + 1;
           
            Bloque llegada = entrada[derecha][y];
             System.out.println("Logica.Movimientos.derecha() " + llegada.getContenido() );
            if (llegada.getContenido() != 1 && llegada.getUltimoMovimiento() < 3) {
                salida[derecha][y].setContenido(2);
                salida[x][y].setContenido(0);
                salida[derecha][y].setUltimoMovimiento(3);
                ubicacion.setIniciox(derecha);
                ubicacion.setInicioy(y);
            }
        }
        print(salida);
        return salida;
    }

    public Bloque[][] izquierda(Bloque[][] entrada) {
        /*Donde xy de entrada es al pocision del robot en ese momento*/
        int x = ubicacion.getIniciox();
        int y = ubicacion.getInicioy();
        //Verifico la disponibilidad de espacion
        Bloque[][] salida;
        salida = entrada;
        if (x <= 10 && x > 0) {
            //impido que se desvorde
            int izquierda = x - 1;
            Bloque llegada = entrada[izquierda][y];
            System.out.println("Logica.Movimientos.izquierda()" + llegada.getContenido());
            if (llegada.getContenido() != 1 && llegada.getUltimoMovimiento() < 1) {
                System.out.println("Logica.Movimientos.izquierda()");
                salida[izquierda][y].setContenido(2);
                salida[x][y].setContenido(0);
                salida[izquierda][y].setUltimoMovimiento(1);
                ubicacion.setIniciox(izquierda);
                ubicacion.setInicioy(y);
            }
        }
        print(salida);
        return salida;
    }

    public void print(Bloque[][] matriz) {
        System.out.println("Logica.Movimientos.print()");
        for (int i = 0; i < matriz.length; i++) {
            //Filas
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(" " + matriz[j][i].getContenido() + " |");

            }
            System.out.println("-");
        }
    }
}
