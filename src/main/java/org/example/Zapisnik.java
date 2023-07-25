package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Zapisnik {
    private Databaze databaze;
    private Scanner scanner = new Scanner(System.in, "Windows-1250");

    public Zapisnik() {
        databaze = new Databaze();
    }


    public String vyhledejPojistence() {
        System.out.print("Zadej jméno nebo příjmení a provede se Vámi vybraná volba: \n");
        String vstup = scanner.nextLine();
        return vstup;
    }

    private String upravaVstupu(String _vstup) {
        String[] rozdeleniVstupu = _vstup.split(" ");
        String vystup = "";
        for (String slovo : rozdeleniVstupu) {
            slovo = slovo.trim().toLowerCase();
            slovo = slovo.substring(0, 1).toUpperCase() + slovo.substring(1);
            vystup = String.join(" ", vystup, slovo);
        }
        return vystup;
    }

    public void vypisPojistence(String vstup) {
        ArrayList<Pojistenec> pojistenciList = databaze.najdiPojistencePodleJmenaNeboPrijmeni(vstup);
        for (Pojistenec p : pojistenciList) {
            p.vypisPojistence();
            System.out.println("");
        }
    }

    //přidá pojištěnce do databáze podle vstupu
    public void pridejPojistence() {
        System.out.println("Zadej jméno pojištěnce: ");
        String jmeno = upravaVstupu(scanner.nextLine());
        System.out.println("Zadej příjmení pojištěnce: ");
        String prijmeni = upravaVstupu(scanner.nextLine());
        System.out.println("Zadej věk pojištěnce: ");
        int vek = Integer.parseInt(scanner.nextLine());
        System.out.println("Zadej telefonní číslo pojištěnce: ");
        int telefonniCislo = Integer.parseInt(scanner.nextLine());
        databaze.pridejPojistence(jmeno, prijmeni, vek, telefonniCislo);
    }

    //vyhledá pojištěnce podle vstupu
    public void najdiVsechnyPojistence() {
        //uživatel zadá hledaného pojištěnce
        String vstup = upravaVstupu(vyhledejPojistence());

        ArrayList<Pojistenec> pojistenciList = databaze.najdiPojistencePodleJmenaNeboPrijmeni(vstup);

        if (pojistenciList.size() > 0) {
            System.out.println("Nalezeni tito pojištěnci: ");
            for (Pojistenec p : pojistenciList) {
                p.vypisPojistence();
                System.out.println("");
            }
        } else {
            System.out.println("Žádný pojištěnec neodpovídá Vámi zadanému zadání!");
        }
    }

    //odstranění pojištěnce podle telefonního čísla
    public void odstranPojistence() {
        System.out.println("Pro odstranění => ");
        String cislo = upravaVstupu(vyhledejPojistence());
        databaze.odeberPojistencePodleCisla(String.valueOf(cislo));
    }

    //vypíše všechny pojištěnce
    public void vypisVsechnyPojistence() {
        System.out.println("Seznam všech pojištěnců: \n");
        databaze.vypisPojistence();
    }

    //výpis úvodní obrazovky
    public void vypisUvitaciHlasku() {
        System.out.println("\n" +
                " ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" +
                "▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" +
                " ▀▀▀▀█░█▀▀▀▀ ▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ \n" +
                "     ▐░▌     ▐░▌▐░▌    ▐░▌▐░▌          ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌          ▐░▌          \n" +
                "     ▐░▌     ▐░▌ ▐░▌   ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▌   ▐░▌▐░▌          ▐░█▄▄▄▄▄▄▄▄▄ \n" +
                "     ▐░▌     ▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░▌          ▐░░░░░░░░░░░▌\n" +
                "     ▐░▌     ▐░▌   ▐░▌ ▐░▌ ▀▀▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░█▀▀▀▀█░█▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▐░▌ ▐░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀ \n" +
                "     ▐░▌     ▐░▌    ▐░▌▐░▌          ▐░▌▐░▌       ▐░▌▐░▌     ▐░▌  ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌          ▐░▌          \n" +
                " ▄▄▄▄█░█▄▄▄▄ ▐░▌     ▐░▐░▌ ▄▄▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌      ▐░▌ ▐░▌       ▐░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ \n" +
                "▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" +
                " ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀         ▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ \n" +
                "                                                                                                                     \n");
        System.out.println();
        System.out.println("Vítejte v pojištovacím zápisníku!");
    }

    public void vypisMoznostiVolby() {
        String volba = "";

        while (!volba.equals("5")) {
            System.out.println("\nVyberte si možnost: ");
            System.out.println("1 - Přidat pojištěnce");
            System.out.println("2 - Vyhledat pojištěnce");
            System.out.println("3 - Vymazat pojištěnce");
            System.out.println("4 - Vypsat všechny pojištěnce");
            System.out.println("5 - Konec");
            volba = scanner.nextLine();
            System.out.println();
            // reakce na volbu
            switch (volba) {
                case "1":
                    pridejPojistence();
                    break;
                case "2":
                    najdiVsechnyPojistence();
                    break;
                case "3":
                    odstranPojistence();
                    break;
                case "4":
                    vypisVsechnyPojistence();
                    break;
                case "5":
                    System.out.println("Děkujeme za použití našeho pojišťovacího systému!");
                    System.out.println("\n" +
                            " ▄▄▄▄▄▄▄▄▄▄   ▄         ▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄   ▄         ▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" +
                            "▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌\n" +
                            "▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀ \n" +
                            "▐░▌       ▐░▌▐░▌       ▐░▌▐░▌               ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          \n" +
                            "▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ \n" +
                            "▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" +
                            "▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ \n" +
                            "▐░▌       ▐░▌     ▐░▌     ▐░▌               ▐░▌       ▐░▌     ▐░▌     ▐░▌          \n" +
                            "▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ \n" +
                            "▐░░░░░░░░░░▌      ▐░▌     ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░▌      ▐░▌     ▐░░░░░░░░░░░▌\n" +
                            " ▀▀▀▀▀▀▀▀▀▀        ▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀        ▀       ▀▀▀▀▀▀▀▀▀▀▀ \n" +
                            "                                                                                   \n");
                    break;
                default:
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                    break;
            }
        }
    }
}

















