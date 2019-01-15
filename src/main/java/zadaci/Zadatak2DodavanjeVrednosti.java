package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak2DodavanjeVrednosti {
    static Dao<Avion, Integer> AvionDao;
    static Dao<Roba, Integer> RobaDao;

    public static void main(String[] args) throws SQLException {

        ConnectionSource connectionSource = null;


        connectionSource = new JdbcConnectionSource();

        AvionDao = DaoManager.createDao(connectionSource, Avion.class);
        RobaDao = DaoManager.createDao(connectionSource, Roba.class);


        Avion a1 = new Avion("Avion1", 34);
        AvionDao.create(a1);

        Avion a2 = new Avion("Avion2", 21);
        AvionDao.create(a2);

        List<Avion> avioni = AvionDao.queryForAll();
        for(Avion a: avioni){
            System.out.println(a);
        }

        Roba r1 = new Roba("Patike", "Duboke patike", 1);
        RobaDao.create(r1);

        Roba r2 = new Roba("Kosulja", "kosulja sa dugim rukavima", 0.4);
        RobaDao.create(r2);

        Roba r3 = new Roba("Voda", "Voda za pice", 1.4);
        RobaDao.create(r3);

        Roba r4 = new Roba("Ploce", "Drvene ploce", 3.4);
        RobaDao.create(r4);

        Roba r5 = new Roba("Stolica", "Plasticna stolica", 2.4);
        RobaDao.create(r5);

        List<Roba> robe = RobaDao.queryForAll();
        for(Roba r: robe){
            System.out.println(r);
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
