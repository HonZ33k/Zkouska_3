package org.example;

import java.util.ArrayList;

public class Databaze {

    private ArrayList<Pojistenec> pojistenciList;


    public Databaze() {
        pojistenciList = new ArrayList<>();
    }

    //přidá pojištěnce

    public void pridejPojistence(String jmeno, String prijmeni, int vek, int telefonniCislo) {
        pojistenciList.add(new Pojistenec(jmeno, prijmeni, vek, telefonniCislo));
    }

    //najde pojištěnce podle jména nebo příjmení
    public ArrayList<Pojistenec> najdiPojistencePodleJmenaNeboPrijmeni(String hledaneSlovo) {
        ArrayList<Pojistenec> nalezenPojistenec = new ArrayList<>();
        for (Pojistenec p : pojistenciList) {
            if (p.getJmeno().contains(hledaneSlovo)) {
                nalezenPojistenec.add(p);
            } else if (p.getPrijmeni().contains(hledaneSlovo)) {
                nalezenPojistenec.add(p);
            }
        }
        return nalezenPojistenec;
    }

    //odebere pojištěnce podle jména
    public void odeberPojistencePodleCisla(String cislo) {
        ArrayList<Pojistenec> nalezen = najdiPojistencePodleJmenaNeboPrijmeni(cislo);
        for (Pojistenec p : nalezen) {
            pojistenciList.remove(p);
        }
    }


    public void vypisPojistence() {
        for (Pojistenec p : pojistenciList) {
            p.vypisPojistence();
            System.out.println("");
        }
    }
}