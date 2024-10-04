package Boletin01.Ej6_EquipoDeBaloncesto;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Equipo implements Serializable, Comparable<Equipo> {
    private String nombre;
    private Integer victorias;
    private Integer derrotas;
    private Integer ptnFavor;
    private Integer ptnContra;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, Integer victorias, Integer derrotas, Integer ptnFavor, Integer ptnContra) {
        this.nombre = nombre;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.ptnFavor = ptnFavor;
        this.ptnContra = ptnContra;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * @return Puntos
     */
    public Integer getPuntos() {
        return ptnFavor + ptnContra;
    }

    /**
     * @return Partidos jugados
     */
    public Integer getpartidosJugados() {
        return victorias + derrotas;
    }

    /**
     * @return Diferencia de puntos
     */
    public Integer getdifPtn() {
        return ptnFavor - ptnContra;
    }


    /**
     * @param eq the object to be compared.
     * @return
     */
    @Override
    public int compareTo(@NotNull Equipo eq) {
        if (this.getPuntos() > eq.getPuntos())
            return 2;
        else if (this.getPuntos().equals(eq.getPuntos())) {
            if (this.ptnFavor >= eq.ptnFavor)
                return 1;
            return 0;
        }
        return -1;
    }

    /**
     * @return super.hashCode()
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @param obj the object to be compared
     * @return true if the name is the same, falso if else
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof Equipo equipo)) return false;
        return this.nombre.equalsIgnoreCase(((Equipo) obj).nombre);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", victorias=" + victorias +
                ", derrotas=" + derrotas +
                ", ptnFavor=" + ptnFavor +
                ", ptnContra=" + ptnContra +
                '}';
    }
}