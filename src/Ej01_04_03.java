import resources.ColeccionPersonas;
import resources.Persona;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class Ej01_04_03 {
    public static void main(String[] args){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/resources/coleccionPersonas.txt"))){

            out.println("Menu:\n\t1: Introducir varias personas\n\t2: Introducir una Persona\n\t3: Quitar una Persona\n\t4: Guardar\n\t5: Salir");

            Menu menu = new Menu();
            int opc = 0;
            while(opc != 4){
                opc = menu.opcionSelector();

                ColeccionPersonas cP = new ColeccionPersonas();
                Persona p1 = new Persona("A",1);
                Persona p2 = new Persona("B",2);
                Persona p3 = new Persona("C",3);
                Persona p4 = new Persona("D",4);

                cP.addPersona(p1);
                cP.addPersona(p2);
                cP.addPersona(p3);
                cP.addPersona(p4);

                oos.writeObject(cP);


                out.println("Menu:\n\t1: Introducir varias personas\n\t2: Introducir una Persona\n\t3: Quitar una Persona\n\t4: Guardar\n\t5: Salir");
            }
        } catch (IOException e){
            System.err.println(e);
        };

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/resources/coleccionPersonas.txt"));){

            while(true){
                try{
                    System.out.println(ois.readObject());
                } catch (IOException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    break;
                }
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }

    public static void introducirPersonas(Scanner sc){
        String nombre = "1";
        nombre = sc.nextLine();
        while(!nombre.equals("-1")){

        }
    }
}

class Menu{
    public Menu(){}

    public int opcionSelector(){
        Object[] opcionesBoton = {"Introducir varias personas", "Introducir una Persona", "Quitar una Persona", "Guardar", "Salir"};

        int resultado = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                "Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesBoton, opcionesBoton[0]); // valor por defecto
        return resultado;
    }
}
