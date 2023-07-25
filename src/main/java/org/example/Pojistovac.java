package org.example;

import java.util.Scanner;

// made by Jan Hajn
public class Pojistovac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Zapisnik zapisnik = new Zapisnik();
        zapisnik.vypisUvitaciHlasku();
        zapisnik.vypisMoznostiVolby();
    }
}