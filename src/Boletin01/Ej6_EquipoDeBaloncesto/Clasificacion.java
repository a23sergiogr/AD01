package Boletin01.Ej6_EquipoDeBaloncesto;

import java.io.Serializable;
import java.util.*;

public class Clasificacion implements Serializable {
    private final TreeSet<Equipo> clasificacion;
    private static Clasificacion instancia;
    private String competicion = "ACB";

    private Clasificacion() {
        clasificacion = new TreeSet<>();
    }

    private Clasificacion(Set<Equipo> equipos) {
        clasificacion = new TreeSet<>(equipos);
    }

    public static synchronized Clasificacion getInstance() {
        if (instancia == null) {
            instancia = new Clasificacion();
        }
        return instancia;
    }

    public static synchronized Clasificacion getInstance(Set<Equipo> equipos) {
        if (instancia == null) {
            instancia = new Clasificacion(equipos);
        }
        return instancia;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public boolean addEquipo(Equipo equipo) {
        return clasificacion.add(equipo);
    }

    public boolean removeEquipo(Equipo equipo){
        return clasificacion.remove(equipo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Equipos:\n");
        for (Equipo e : clasificacion)
            sb.append("\n\t").append(e.toString());
        return sb.toString();
    }
}
