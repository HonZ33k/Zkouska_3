package org.example;

public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telefonniCislo;

    public Pojistenec(String _jmeno, String _prijmeni, int _vek, int _telefonniCislo) {
        jmeno = _jmeno;
        prijmeni = _prijmeni;
        vek = _vek;
        telefonniCislo = _telefonniCislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public int getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(int telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    public void vypisPojistence() {
        System.out.println("Jméno a příjmení: " + getJmeno() + " " + getPrijmeni());
        System.out.println("Věk: " + getVek());
        System.out.println("Telefonní číslo: " + getTelefonniCislo());
    }
}
