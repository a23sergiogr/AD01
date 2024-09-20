package resources;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class ColeccionPersonas implements Serializable {
    ArrayList<Persona> sP;

    public ColeccionPersonas(ArrayList<Persona> sP) {
        this.sP = sP;
    }

    public ColeccionPersonas(){
        sP = new ArrayList<Persona>();
    }
    public int numPersonas(){
        return sP.size();
    }

    public void addPersona(Persona p){
        sP.add(p);
    }

    public Persona getPersona(int i){
        return sP.get(i);
    }

    public void delPersona(int i){
        sP.remove(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Colección de Personas:\n");

        for (Persona p : sP){
            sb.append("\n").append(p.toString());
        }

        return sb.toString();
    }
}
