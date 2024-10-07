package Boletin01.Ej6_EquipoDeBaloncesto.PatronDao;

import Boletin01.Ej6_EquipoDeBaloncesto.Equipo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class EquipoRandomAccesFileDao implements Dao<Equipo, String>{
    private static final String RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/EquiposRAF.dat";
    private static final Path datos = Paths.get(RUTA);


    public EquipoRandomAccesFileDao() throws IOException {
        if (!Files.exists(datos))
            Files.createFile(datos);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Equipo get(String id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Set<Equipo> getAll() {
        return Set.of();
    }

    /**
     * @param obxeto
     */
    @Override
    public boolean save(Equipo obxeto) {
        return false;
    }

    /**
     * @param obxeto
     */
    @Override
    public boolean delete(Equipo obxeto) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean deleteAll() {
        return false;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(String id) {
        return false;
    }

    /**
     * @param obxeto
     */
    @Override
    public void update(Equipo obxeto) {

    }
}
