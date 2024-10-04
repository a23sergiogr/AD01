package patronDao;

import java.util.List;


public interface Dao <T, K> {
    T get(K id);
    List<T> getAll();
    void save(T obxeto);
    void delete(T obxeto);
    void update(T obxeto);
}
