package Boletin01.Ej6_EquipoDeBaloncesto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EquipoFileBufferedStream implements Dao<Equipo, String> {
    private static final String RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/BufferedEquipos.dat";

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
        HashSet<Equipo> set = null;
        try (var bis = new BufferedInputStream(new FileInputStream(RUTA))) {
            byte[] byteArray = bis.readAllBytes();
            set = deSerializador(byteArray);
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException in getAll()");
        } catch (IOException e) {
            System.err.println("IOException in getAll()");
        }

        return set;
    }

    /**
     * @param obxeto
     */
    @Override
    public void save(Equipo obxeto) {
        TreeSet<Equipo> set = new TreeSet<>(getAll());
        set.add(obxeto);
        try (var bos = new BufferedOutputStream(new FileOutputStream(RUTA))) {
            set.forEach(e -> {
                try {
                    bos.write(serializador(e));
                } catch (IOException ex) {
                    System.err.println("IOException in save()");
                }
            });
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException in save()");
        } catch (IOException e) {
            System.err.println("IOException in save()");
        }
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

    private byte[] serializador(Equipo e) {
        StringBuilder sb = new StringBuilder();
        sb.append("__Equipo__")
                .append(e.getNombre()).append(";")
                .append(e.getVictorias()).append(";")
                .append(e.getPtnFavor()).append(";")
                .append(e.getPtnFavor()).append(";")
                .append(e.getPtnContra()).append(";");
        return sb.toString().getBytes(StandardCharsets.UTF_16);
    }

    private HashSet deSerializador(byte[] byteArray) {
        char[] charArray = new char[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            charArray[i] = (char) byteArray[i];
        }
        String str = new String(byteArray, StandardCharsets.UTF_16);

        String[] strArray = str.split("__Equipo__");
        HashSet<Equipo> set = new HashSet<>();
        for (String s : strArray) {
            try {
                String[] equipoString = s.split(";");
                set.add(new Equipo(equipoString[0],
                        Integer.parseInt(equipoString[1]),
                        Integer.parseInt(equipoString[2]),
                        Integer.parseInt(equipoString[3]),
                        Integer.parseInt(equipoString[4])));
            } catch (Exception e) {
                System.err.println("Error en deSerializador");
            }
        }
        return set;
    }
}
