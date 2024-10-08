package Boletin01.Ej6_EquipoDeBaloncesto.PatronDao;

import Boletin01.Ej6_EquipoDeBaloncesto.Equipo;

import java.io.IOException;


public class EquipoDaoFactory {
    private static final String FBS_RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/FileBufferedEquipos.dat";
    private static final String OS_RUTA = "src/Boletin01/Ej6_EquipoDeBaloncesto/Datos/ObjectStreamEquipos.dat";
    private static EquipoDaoFactory instancia;
    private Dao<Equipo,String> dao;

    private EquipoDaoFactory() {}

    //Sigelton
    public static synchronized EquipoDaoFactory getInstance() {
        if (instancia == null) {
            instancia = new EquipoDaoFactory();
        }
        return instancia;
    }

    public Dao<Equipo,String> getEquipoDAO(String tipo) {
        try{
            if (dao == null) {
                switch (tipo) {
                    case "FBS":
                        dao = new EquipoFileBufferedStream(FBS_RUTA);
                        break;
                    case "OS":
                        dao = new EquipoObjectStreamDao(OS_RUTA);
                        break;
                    case "RAF":
                        dao = new EquipoRandomAccesFileDao();
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de DAO no soportado");
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el Archivo");
            System.exit(1);
        }
        return dao;
    }

    public Dao<Equipo,String> getEquipoDAO(String tipo, String ruta) {
        try{
            if (dao == null) {
                switch (tipo) {
                    case "FBS":
                        dao = new EquipoFileBufferedStream(ruta);
                        break;
                    case "OS":
                        dao = new EquipoObjectStreamDao(ruta);
                        break;
                    case "RAF":
                        dao = new EquipoRandomAccesFileDao();
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de DAO no soportado");
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el Archivo");
            System.exit(1);
        }
        return dao;
    }
}