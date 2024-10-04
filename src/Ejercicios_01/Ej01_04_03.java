package Ejercicios_01;

import resources.ColeccionPersonas;
import resources.Persona;

import javax.swing.*;
import java.io.*;

public class Ej01_04_03 {
    public static final String ARQUIVO = "src/resources/coleccionPersonas.txt";

    public static void main(String[] args) {
        Menu menu = new Menu();
        ColeccionPersonas coleccionPersonas = new ColeccionPersonas();
        cargarDatos(coleccionPersonas);
        esccribirDatos(coleccionPersonas);

        int opc = 0;
        boolean salir = false;
        while (!salir) {
            opc = menu.opcionSelector();

            switch (opc) {
                case 0:     //Introducir varias personas
                    Persona p1 = new Persona("A", 1);
                    Persona p2 = new Persona("B", 2);
                    Persona p3 = new Persona("C", 3);
                    Persona p4 = new Persona("D", 4);
                    coleccionPersonas.addPersona(p1);
                    coleccionPersonas.addPersona(p2);
                    coleccionPersonas.addPersona(p3);
                    coleccionPersonas.addPersona(p4);
                    break;
                case 1:     //Introducir una Persona
                    Persona p = menu.introducirPersona();
                    if (p != null)
                        coleccionPersonas.addPersona(p);
                    break;
                case 2:     //Quitar una Persona
                    menu.quitarPersona(coleccionPersonas);
                    break;
                case 3:     //Mostrar Colección
                    menu.mostrarColeccion(coleccionPersonas);
                    break;
                case 4:     //Guardar
                    esccribirDatos(coleccionPersonas);
                    break;
                case 5:     //Salir
                    salir = true;
                    break;
                case -1:    //X
                    salir = true;
                    break;
                default:
                    Menu.exceptionMessage(new Exception("Boton inactivo"));
                    break;
            }
        }
    }

    public static void cargarDatos(ColeccionPersonas cP) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            ColeccionPersonas p = null;
            try {
                p = (ColeccionPersonas) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                Menu.exceptionMessage(e);
            }
            if (p != null) {
                for (int i = 0; i < p.numPersonas(); i++) {
                    cP.addPersona(p.getPersona(i));
                }
            }
        } catch (IOException e) {
            Menu.exceptionMessage(e);
        }
    }

    public static void esccribirDatos(ColeccionPersonas cP) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(cP);
            //oos.flush()
        } catch (IOException e) {
            Menu.exceptionMessage(e);
        }
    }
}


class Menu {
    public Menu() {
    }

    public int opcionSelector() {
        Object[] opcionesBoton = {"Introducir varias personas",
                "Introducir una Persona",
                "Quitar una Persona",
                "Mostrar Colección",
                "Guardar",
                "Salir"};

        return JOptionPane
                .showOptionDialog(null,
                        "Que quieres hacer?",
                        "Opciones",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opcionesBoton,
                        opcionesBoton[0]);
    }

    public Persona introducirPersona() {
        String nome = null;
        while(nome == null){
            nome = JOptionPane.showInputDialog("Nome");
        }
        int edad = -1;
        while(edad < 0){
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
            } catch (NumberFormatException e) {
                exceptionMessage(e, "Debes introducir un numero en edad");
                edad = -1;
            }
        }
        return new Persona(nome, edad);
    }

    public void quitarPersona(ColeccionPersonas cP) {
        try {
            int i = Integer.parseInt(JOptionPane.showInputDialog("Número de Persona que quitar"));
            if (i > -1 && i < cP.numPersonas())
                cP.delPersona(i);
            else
                JOptionPane
                        .showMessageDialog(null,
                                "No exista una persona asociada a ese número",
                                "Quitar Persona",
                                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            exceptionMessage(e);
        }
    }

    public void mostrarColeccion(ColeccionPersonas cP) {
        Object mensage = cP.toString();
        JOptionPane
                .showMessageDialog(null,
                        mensage,
                        "Colección",
                        JOptionPane.PLAIN_MESSAGE);
    }

    public static void exceptionMessage(Exception e) {
        JOptionPane
                .showMessageDialog(null,
                        "ERROR: " + e,
                        "Excepción",
                        JOptionPane.INFORMATION_MESSAGE);
    }

    public static void exceptionMessage(Exception e, String opcMessage) {
        JOptionPane
                .showMessageDialog(null,
                        opcMessage + "\nERROR: " + e,
                        "Excepción",
                        JOptionPane.INFORMATION_MESSAGE);
    }
}
