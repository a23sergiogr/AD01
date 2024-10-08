package Boletin01.Ej6_EquipoDeBaloncesto.PatronDao;

import Boletin01.Ej6_EquipoDeBaloncesto.Clasificacion;
import Boletin01.Ej6_EquipoDeBaloncesto.Equipo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class ClasificacionFileDAO implements Dao<Clasificacion, String> {
    private static final String RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/Classification.dat";
    private static final Path datos = Paths.get(RUTA);


    @Override
    public Clasificacion get(String id) {
        return null;
    }

    @Override
    public Set<Clasificacion> getAll() {
        return Set.of();
    }

    @Override
    public boolean save(Clasificacion clasificacion) {
        EquipoDaoFactory equipoDAOFactory = EquipoDaoFactory.getInstance();
        Dao<Equipo, String> equipoFileDao = equipoDAOFactory.getEquipoDAO("FBS");//FBS, OS, RAF

        return true;
    }

    @Override
    public boolean delete(Clasificacion clasificacion) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public void update(Clasificacion clasificacion) {

    }
}
