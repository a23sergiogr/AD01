package Boletin01.Ej6_EquipoDeBaloncesto;

import java.util.Set;

public class EquipoRandomAccesFileDao implements Dao<Equipo, String>{
    private static final String RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/EquiposRAF.dat";

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
