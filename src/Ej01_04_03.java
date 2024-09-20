import resources.ColeccionPersonas;
import resources.Persona;

import javax.swing.*;
import java.io.*;

public class Ej01_04_03 {
    public static final String ARQUIVO = "src/resources/coleccionPersonas.txt";
    public static void main(String[] args){
        Menu menu = new Menu();
        ColeccionPersonas cP = new ColeccionPersonas();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO));){
            cargarDatos(cP, ois);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))){

                oos.writeObject(cP);

                int opc = 0;
                while(opc != 6){
                    opc = menu.opcionSelector();

                    switch (opc) {
                        case 0:
                            Persona p1 = new Persona("A",1);
                            Persona p2 = new Persona("B",2);
                            Persona p3 = new Persona("C",3);
                            Persona p4 = new Persona("D",4);
                            cP.addPersona(p1);
                            cP.addPersona(p2);
                            cP.addPersona(p3);
                            cP.addPersona(p4);
                            break;
                        case 1:
                            cP.addPersona(menu.introducirPersona());
                            break;
                        case 2:
                            menu.quitarPersona(cP);
                            break;
                        case 3:
                            oos.writeObject(cP);
                            break;
                        case 4:
                            menu.mostrarColección(cP);
                            break;
                        case 5:
                            leerDatos(ois);
                            break;
                        default:
                            opc = 6;
                            break;
                    }
                }
            }
        }
        catch (IOException e){

        }
    }

    public static void cargarDatos(ColeccionPersonas cP, ObjectInputStream ois){
            while(true) {
                ColeccionPersonas p;
                try {
                    p = (ColeccionPersonas) ois.readObject();
                } catch (IOException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    break;
                }
                for(int i = 0; i < p.numPersonas(); i++){
                    cP.addPersona(p.getPersona(i));
                }
            }
    }

    public static void leerDatos(ObjectInputStream ois){
            while(true){
                try{
                    System.out.println(ois.readObject());
                } catch (IOException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    break;
                }
            }
    }
}

class Menu{
    public Menu(){}

    public int opcionSelector(){
        Object[] opcionesBoton = {"Introducir varias personas", "Introducir una Persona", "Quitar una Persona", "Guardar", "Mostrar Colección", "Leer Archivo", "Salir"};

        int resultado = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                "Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesBoton, opcionesBoton[0]); // valor por defecto
        return resultado;
    }

    public Persona introducirPersona(){
        String nome = JOptionPane.showInputDialog("Nome");
        String edad = JOptionPane.showInputDialog("Edad");
        return new Persona(nome,Integer.parseInt(edad));
    }

    public void quitarPersona(ColeccionPersonas cP){
        String i = JOptionPane.showInputDialog("Edad");
        cP.delPersona(Integer.parseInt(i));
    }

    public void mostrarColección(ColeccionPersonas cP){
        Object mensage = cP.toString();
        JOptionPane.showMessageDialog(null, (Object) mensage, "titulo", JOptionPane.PLAIN_MESSAGE);
    }
}
