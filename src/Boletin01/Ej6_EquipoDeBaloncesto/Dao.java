package Boletin01.Ej6_EquipoDeBaloncesto;

import java.util.HashSet;
import java.util.Set;

public interface Dao <T, K> {
    T get(K id);
    Set<T> getAll();
    void save(T obxeto);
    void delete(T obxeto);
    void update(T obxeto);
}
