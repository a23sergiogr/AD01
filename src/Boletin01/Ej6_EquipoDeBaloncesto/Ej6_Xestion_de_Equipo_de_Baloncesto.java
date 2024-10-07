package Boletin01.Ej6_EquipoDeBaloncesto;


import Boletin01.Ej6_EquipoDeBaloncesto.PatronDao.Dao;
import Boletin01.Ej6_EquipoDeBaloncesto.PatronDao.EquipoDaoFactory;
import Boletin01.Ej6_EquipoDeBaloncesto.PatronDao.EquipoFileBufferedStream;
import Boletin01.Ej6_EquipoDeBaloncesto.PatronDao.EquipoObjectStreamDao;

public class Ej6_Xestion_de_Equipo_de_Baloncesto {
    public static void main(String[] args) {
         EquipoDaoFactory equipoDAOFactory = EquipoDaoFactory.getInstance();
         Dao<Equipo, String> equipoDao = equipoDAOFactory.getEquipoDAO("FBS");//FBS, OS, RAF

        //String nombre, Integer victorias, Integer derrotas, Integer ptnFavor, Integer ptnContra
        equipoDao.save(new Equipo("Eq1", 1, 0, 1, 0));
        equipoDao.save(new Equipo("Eq2", 0, 1, 0, 1));
        equipoDao.save(new Equipo("Eq3", 2, 1, 2, 1));
        equipoDao.save(new Equipo("Eq4", 5, 0, 5, 0));
        equipoDao.save(new Equipo("Eq5", 0, 5, 0, 5));

        equipoDao.getAll().forEach(System.out::println);

        System.out.println(equipoDao.delete(new Equipo("Eq1")));
        System.out.println(equipoDao.deleteById("Eq2"));
        equipoDao.getAll().forEach(System.out::println);

        System.out.println(equipoDao.deleteAll());
        equipoDao.getAll().forEach(System.out::println);

    }
}

