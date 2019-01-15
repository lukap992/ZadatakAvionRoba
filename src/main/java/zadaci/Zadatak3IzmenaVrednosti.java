package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.util.List;

public class Zadatak3IzmenaVrednosti {
    static Dao<Avion, Integer> avionDao;
    static Dao<Roba, Integer> robaDao;


    public static void main(String[] args) {

        try{
            ConnectionSource connectionSource = null;
            avionDao = DaoManager.createDao(connectionSource, Avion.class);
            robaDao = DaoManager.createDao(connectionSource, Roba.class);

            List<Roba> robaZaIzmenu = robaDao.queryForEq(Roba.POLJE_OPIS, "PLasticna stolica");
            robaZaIzmenu.get(0).setOpis("Drvena stolica");
            robaDao.update(robaZaIzmenu.get(0));

            List<Roba> lista = robaDao.queryForAll();
            for(Roba r: lista){
                System.out.println(r);
            }

        }catch (Exception e){
            e.printStackTrace();
        }












        try{
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connectionSource != null){
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

