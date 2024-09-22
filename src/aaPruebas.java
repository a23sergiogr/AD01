import resources.ColeccionPersonas;
import resources.Persona;

import java.io.*;

public class aaPruebas {
    public static final String ARQUIVO = "src/resources/coleccionPersonas.txt";

    public static void main(String[] args) {
        ColeccionPersonas cP = new ColeccionPersonas();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))){

            Persona p1 = new Persona("A",1);
            Persona p2 = new Persona("B",2);
            Persona p3 = new Persona("C",3);
            Persona p4 = new Persona("D",4);
            cP.addPersona(p1);
            cP.addPersona(p2);
            cP.addPersona(p3);
            cP.addPersona(p4);
            oos.writeObject(cP);
            while(true){
                try{
                    System.out.println(ois.readObject());
                } catch (IOException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
