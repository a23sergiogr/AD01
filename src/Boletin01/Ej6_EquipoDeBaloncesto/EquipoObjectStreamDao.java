package Boletin01.Ej6_EquipoDeBaloncesto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EquipoObjectStreamDao implements Dao<Equipo, String>{
    private static final String RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/Equipos.dat";

    /**
     * @param id
     * @return
     */
    @Override
    public Equipo get(String id) {
        Set<Equipo> list = getAll();

        for (Equipo equipo : list)
            if(equipo.equals(new Equipo(id)))
                return equipo;

        return null;
    }

    /**
     * @return
     */
    @Override
    public Set<Equipo> getAll() {
        Set<Equipo> set = new HashSet<>();
        try(var ois = new ObjectInputStream(new FileInputStream(RUTA))){
            while (true)
                set.add((Equipo) ois.readObject());
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException in getAll()");
        } catch (IOException e) {
            System.err.println("IOException in getAll()");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in getAll()");
        }
        saveAll(set);
        return set;
    }

    /**
     * @param obxeto
     */
    @Override
    public void save(Equipo obxeto) {
        Set<Equipo> set = getAll();
        List<Equipo> list = new ArrayList<>();
        list.addAll(set);

        if (set.size()==0)
            set.add(obxeto);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(obxeto)){
                System.out.println("Undate Equipo: " + obxeto.getNombre());
                update(obxeto);
                break;
            }
            else if (i == list.size()-1) {
                System.out.println("Añadindo Equipo: " + obxeto.getNombre());
                list.add(obxeto);
                saveAll(new HashSet<>(list));
                break;
            }
        }
    }

    /**
     * @param obxeto
     */
    @Override
    public void delete(Equipo obxeto) {
        Set<Equipo> set = getAll();
        set.remove(obxeto);
        saveAll(set);
    }

    /**
     * @param obxeto
     */
    @Override
    public void update(Equipo obxeto) {
        Set<Equipo> set = getAll();
        List<Equipo> list = new ArrayList<>();
        list.addAll(set);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(obxeto)){
                list.remove(i);
                list.add(i,obxeto);
                saveAll(new HashSet<>(list));
                break;
            }
            else if (i == list.size()-1) {
                System.err.println("No existe el objeto Equipo");
            }
        }
    }

    private void saveAll(Set set){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA))) {
            set.stream().forEach(e -> {
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
}