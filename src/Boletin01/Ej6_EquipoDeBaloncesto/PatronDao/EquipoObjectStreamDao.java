package Boletin01.Ej6_EquipoDeBaloncesto.PatronDao;

import Boletin01.Ej6_EquipoDeBaloncesto.Equipo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EquipoObjectStreamDao implements Dao<Equipo, String> {
    private final String ruta;
    private final Path datos;


    public EquipoObjectStreamDao(String ruta){
        datos = Paths.get(ruta);
        this.ruta = ruta;
    }

    /**
     * @param id Nombre del Equipo a recuperar
     * @return  Equipo
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
     * @return Set de Equipos
     */
    @Override
    public Set<Equipo> getAll() {
        HashSet<Equipo> set = new HashSet<>();
        try (var ois = new ObjectInputStream(new FileInputStream(ruta))) {
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
        TreeSet<Equipo> sortedSet = sortSet(set);
        saveAll(sortedSet);
        return sortedSet;
    }

    /**
     * @param obxeto Equipo a gardar
     * @return True si o garda, false si no
     */
    @Override
    public boolean save(Equipo obxeto) {
        boolean append = Files.exists(datos);
        try (FileOutputStream fos = new FileOutputStream(datos.toFile(), append);
             ObjectOutputStream oos = append ? new EquipoOutputStream(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(obxeto);
        } catch (IOException e) {
            System.out.println("Erro de Entrada/Saída");
            return false;
        }
        return true;
    }

    /**
     * @param obxeto Equipo a eliminar
     * @return True si o borra, false si no
     */
    @Override
    public boolean delete(Equipo obxeto) {
        HashSet<Equipo> set = new HashSet<>(getAll());
        if (set.remove(obxeto))
            return saveAll(sortSet(set));
        return false;
    }

    /**
     * @param id Nome do equipo a borrar
     * @return True si o borra, false si no
     */
    @Override
    public boolean deleteById(String id) {
        HashSet<Equipo> set = new HashSet<>(getAll());
        if (set.remove(new Equipo(id)))
            return saveAll(sortSet(set));
        return false;
    }

    /**
     * @return True si borra toda a colección, false si no
     */
    @Override
    public boolean deleteAll() {
        HashSet<Equipo> set = new HashSet<>();
        return saveAll(sortSet(set));
    }

    /**
     * @param obxeto Equipo a actualizar
     */
    @Override
    public void update(Equipo obxeto) {
        HashSet<Equipo> set = (HashSet<Equipo>) getAll();
        set.remove(obxeto);
        set.add(obxeto);
        saveAll(sortSet(set));
    }

    private boolean saveAll(TreeSet<Equipo> set) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
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
        return true;
    }

    private TreeSet<Equipo> sortSet(Set<Equipo> set){
        return new TreeSet<>(set);
    }
}