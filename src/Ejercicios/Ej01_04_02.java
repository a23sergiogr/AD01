package Ejercicios;

import resources.Persona;

import java.io.*;

public class Ej01_04_02 {
    public static void main(String[] args){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/resources/persona.txt"))){

            Persona p1 = new Persona("A",1);
            Persona p2 = new Persona("B",2);
            Persona p3 = new Persona("C",3);
            Persona p4 = new Persona("D",4);

            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
            oos.writeObject(p4);

        } catch (IOException e){
            System.err.println(e);
        };

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/resources/persona.txt"));){

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
}
