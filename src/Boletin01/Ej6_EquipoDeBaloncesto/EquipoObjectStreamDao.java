package Boletin01.Ej6_EquipoDeBaloncesto;

import java.io.*;
import java.util.*;

public class EquipoObjectStreamDao implements Dao<Equipo, String> {
    private static final String RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/Equipos.dat";

    /**
     * @param id
     * @return
     */
    @Override
    public Equipo get(String id) {
        HashSet<Equipo> list = new HashSet<>(getAll());

        for (Equipo equipo : list)
            if (equipo.equals(new Equipo(id)))
                return equipo;

        return null;
    }

    /**
     * @return
     */
    @Override
    public Set<Equipo> getAll() {
        HashSet<Equipo> set = new HashSet<>();
        try (var ois = new ObjectInputStream(new FileInputStream(RUTA))) {
            while (true) {
                try {
                    Equipo equipo = (Equipo) ois.readObject();
                    set.add(equipo);
                } catch (EOFException e) {
                    break; // Rompe el bucle cuando se llega al final del archivo
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException in getAll()");
        } catch (IOException e) {
            System.err.println("IOException in getAll()");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in getAll()");
        }
        TreeSet sortedSet = sortSet(set);
        saveAll(sortedSet);
        return sortedSet;
    }

    /**
     * @param obxeto
     */
    @Override
    public boolean save(Equipo obxeto) {
        HashSet<Equipo> set = new HashSet<>(getAll());
        if (!set.contains(obxeto))
            System.out.println(set.add(obxeto));
        saveAll(sortSet(set));
        return true;
    }

    /**
     * @param obxeto
     */
    @Override
    public boolean delete(Equipo obxeto) {
        HashSet<Equipo> set = new HashSet<>(getAll());
        set.remove(obxeto);
        saveAll(sortSet(set));
        return true;
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
        HashSet<Equipo> set = (HashSet<Equipo>) getAll();
        set.remove(obxeto);
        set.add(obxeto);
        saveAll(sortSet(set));
    }

    private void saveAll(TreeSet set) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA))) {
            set.forEach(e -> {
                try {
                    oos.writeObject(e);
                } catch (IOException ex) {
                    System.err.println("IOException in Stream()");
                }
            });

        } catch (IOException e) {
            System.err.println("IOException in saveAll()");
        }
    }

    private TreeSet sortSet(Set set){
        return new TreeSet<Equipo>(set);
    }
}