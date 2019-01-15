package model;

import com.j256.ormlite.field.DatabaseField;

public class Avion {


    private static final String POLJE_OZNAKA = "oznaka";
    private static final String POLJE_RASPON_KRILA = "raspno_krila";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_OZNAKA, canBeNull = false)
    private String getOznaka;

    @DatabaseField(columnName = POLJE_RASPON_KRILA, canBeNull = false)
    private int rasponKrila;

    public Avion(){

    }

    public Avion(String oznaka, int rasponKrila){
        this.getOznaka = oznaka;
        this.rasponKrila = rasponKrila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGetOznaka() {
        return getOznaka;
    }

    public void setGetOznaka(String getOznaka) {
        this.getOznaka = getOznaka;
    }

    public int getRasponKrila() {
        return rasponKrila;
    }

    public void setRasponKrila(int rasponKrila) {
        this.rasponKrila = rasponKrila;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", getOznaka='" + getOznaka + '\'' +
                ", rasponKrila=" + rasponKrila +
                '}';
    }
}
