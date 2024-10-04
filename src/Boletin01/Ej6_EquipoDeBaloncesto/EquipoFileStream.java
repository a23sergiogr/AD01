package Boletin01.Ej6_EquipoDeBaloncesto;

import java.util.Set;

public class EquipoFileStream implements Dao<Equipo,String>{
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
    public void save(Equipo obxeto) {

    }

    /**
     * @param obxeto
     */
    @Override
    public void delete(Equipo obxeto) {

    }

    /**
     * @param obxeto
     */
    @Override
    public void update(Equipo obxeto) {

    }
}
