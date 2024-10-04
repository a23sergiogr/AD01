package Boletin01.Ej6_EquipoDeBaloncesto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clasificacion implements Serializable {
    private List<Equipo> lista;

    public Clasificacion() {
        lista = new ArrayList<Equipo>();
    }

    public Equipo getEquipo(String id) {
        for (Equipo e : lista) {
            if (e.equals(new Equipo(id)))
                return e;
        }
        return null;
    }

    public List<Equipo> getAllEquipos() {
        return lista;
    }

    /**
     * @param equipo
     */
    public void addEquipo(Equipo equipo) {
        for (int i = 0; i < lista.size(); i++) {
            int j = equipo.compareTo(lista.get(i));
            if (j == 2) {
                lista.add(0,equipo);
                break;
            }
            else if (j == 1) {
                lista.add(i++, equipo);
                break;
            }
            else if (j == 0) {
                lista.add(i, equipo);
                break;
            }
            else if (j == -1){
                if (lista.size()-1 == i)
                    lista.addLast(equipo);
            }
            if (lista.size() == i){
                lista.add(equipo);
            }
        }
    }

    public void removeEquipo(Equipo equipo){
        lista.remove(equipo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Equipos:\n");
        for (Equipo e : lista)
            sb.append("\n\t").append(e.toString());
        return sb.toString();
    }
}
