package Boletin01.Ej6_EquipoDeBaloncesto;

import java.util.HashSet;
import java.util.Set;

public interface Dao <T, K> {
    T get(K id);
    Set<T> getAll();
    boolean save(T obxeto);
    boolean delete(T obxeto);
    boolean deleteAll();
    boolean deleteById(K id);
    void update(T obxeto);
}
