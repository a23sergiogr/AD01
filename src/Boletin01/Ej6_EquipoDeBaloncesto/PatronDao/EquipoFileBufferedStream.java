package Boletin01.Ej6_EquipoDeBaloncesto.PatronDao;

import Boletin01.Ej6_EquipoDeBaloncesto.Equipo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EquipoFileBufferedStream implements Dao<Equipo, String> {
    private static final String RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/FileBufferedEquipos.dat";
    private static final Path datos = Paths.get(RUTA);


    public EquipoFileBufferedStream() throws IOException {
        if (!Files.exists(datos))
            Files.createFile(datos);
    }

    @Override
    public Equipo get(String id) {
        return null;
    }

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

        return sortSet(set);
    }

    @Override
    public boolean save(Equipo obxeto) {
        String str = getString();
        assert str != null;
        if (!str.contains(obxeto.getNombre())){
            try (var bos = new BufferedOutputStream(new FileOutputStream(RUTA, Files.exists(datos)))) {
                bos.write(serializador(obxeto));
                return true;
            } catch (FileNotFoundException e) {
                System.err.println("FileNotFoundException in save()");
            } catch (IOException e) {
                System.err.println("IOException in save()");
            }
        }
        return false;
    }

    @Override
    public boolean delete(Equipo obxeto) {
        HashSet<Equipo> set = new HashSet<>(getAll());

        if (set.remove(obxeto)) {
            try (var bos = new BufferedOutputStream(new FileOutputStream(RUTA))) {
                for (Equipo equipo : set) {
                    bos.write(serializador(equipo));
                }
                return true;
            } catch (FileNotFoundException e) {
                System.err.println("FileNotFoundException in delete()");
            } catch (IOException e) {
                System.err.println("IOException in delete()");
            }
        }

        return false;
    }

    @Override
    public boolean deleteById(String id) {
        HashSet<Equipo> set = new HashSet<>(getAll());

        if (set.remove(new Equipo(id))) {
            try (var bos = new BufferedOutputStream(new FileOutputStream(RUTA))) {
                for (Equipo equipo : set) {
                    bos.write(serializador(equipo));
                }
                return true;
            } catch (FileNotFoundException e) {
                System.err.println("FileNotFoundException in delete()");
            } catch (IOException e) {
                System.err.println("IOException in delete()");
            }
        }

        return false;
    }

    @Override
    public boolean deleteAll() {
        try (var bos = new BufferedOutputStream(new FileOutputStream(RUTA))) {
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException in delete()");
        } catch (IOException e) {
            System.err.println("IOException in delete()");
        }
        return false;
    }


    @Override
    public void update(Equipo obxeto) {

    }

    private byte[] serializador(Equipo e) {
        StringBuilder sb = new StringBuilder();
        sb.append("__Equipo__")
                .append(e.getNombre()).append(";")
                .append(e.getVictorias()).append(";")
                .append(e.getDerrotas()).append(";")
                .append(e.getPtnFavor()).append(";")
                .append(e.getPtnContra()).append(";");
        return sb.toString().getBytes(StandardCharsets.UTF_16);
    }

    private HashSet<Equipo> deSerializador(byte[] byteArray) {
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

    private String getString(){
        try (var bis = new BufferedInputStream(new FileInputStream(RUTA))) {
            byte[] byteArray = bis.readAllBytes();

            char[] charArray = new char[byteArray.length];
            for (int i = 0; i < byteArray.length; i++) {
                charArray[i] = (char) byteArray[i];
            }

            return new String(byteArray, StandardCharsets.UTF_16);

        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException in getAll()");
        } catch (IOException e) {
            System.err.println("IOException in getAll()");
        }
        return null;
    }

    private TreeSet<Equipo> sortSet(Set<Equipo> set){
        return new TreeSet<>(set);
    }
}
