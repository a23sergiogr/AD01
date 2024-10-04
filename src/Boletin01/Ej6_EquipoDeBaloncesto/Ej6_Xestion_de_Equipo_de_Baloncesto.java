package Boletin01.Ej6_EquipoDeBaloncesto;


public class Ej6_Xestion_de_Equipo_de_Baloncesto {
    public static void main(String[] args) {
        EquipoObjectStreamDao eosd = new EquipoObjectStreamDao();
        //String nombre, Integer victorias, Integer derrotas, Integer ptnFavor, Integer ptnContra
        eosd.save(new Equipo("Eq1", 1, 0, 1, 0));
        eosd.save(new Equipo("Eq2", 0, 1, 0, 1));
        eosd.save(new Equipo("Eq3", 2, 1, 2, 1));
        eosd.save(new Equipo("Eq4", 5, 0, 5, 0));
        eosd.save(new Equipo("Eq5", 0, 5, 0, 5));
        eosd.save(new Equipo("Eq3", 3, 2, 3, 2));
        eosd.delete(new Equipo("Eq2", 0, 1, 0, 1));

        eosd.getAll().stream().forEach(equipo -> System.out.println(equipo));

        System.out.println("\nEquipo 4: " + eosd.get("Eq4"));
    }
}

