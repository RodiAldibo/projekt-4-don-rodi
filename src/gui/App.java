package gui;

import controller.Controller;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import model.PladsType;
import storage.Storage;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        initStorage();
        testPrint();
    }

    public static void initStorage() {
        Controller.opretForestilling("Evita",
                LocalDate.of(2023, 8, 10),
                LocalDate.of(2023, 8, 20));

        Controller.opretForestilling("Lykke Per",
                LocalDate.of(2023, 9, 1),
                LocalDate.of(2023, 9, 10));

        Controller.opretForestilling("Chess",
                LocalDate.of(2023, 8, 21),
                LocalDate.of(2023, 8, 30));

        Controller.opretKunde("Anders Hansen", "11223344");
        Controller.opretKunde("Peter Jensen", "12345678");
        Controller.opretKunde("Niels Madsen", "12341234");

        for (int raekke = 1; raekke <= 15; raekke++) {
            int pris;
            if (raekke <= 5) pris = 500;
            else if (raekke <= 10) pris = 450;
            else pris = 400;

            for (int nr = 1; nr <= 20; nr++) {
                PladsType type = PladsType.STANDARD;

                if (raekke == 10 && nr >= 6 && nr <= 10) {
                    type = PladsType.KORESTOL;
                } else if (raekke == 11 && nr >= 6 && nr <= 10) {
                    type = PladsType.EKSTRA_BENPLADS;
                }

                Controller.opretPlads(raekke, nr, pris, type);
            }
        }
    }

    public static void testPrint() {
        System.out.println("=== Forestillinger ===");
        for (Forestilling f : Storage.getForestillinger()) {
            System.out.println(" - " + f.getNavn() + " (" + f.getStartDato() + " til " + f.getSlutDato() + ")");
        }

        System.out.println("\n=== Kunder ===");
        for (Kunde k : Storage.getKunder()) {
            System.out.println(" - " + k.getNavn() + " / " + k.getMobil());
        }

        System.out.println("\n=== Pladser (samlet) ===");
        System.out.println("Antal pladser i alt: " + Storage.getPladser().size());

        int antalStandard = 0, antalK = 0, antalEB = 0;
        for (Plads p : Storage.getPladser()) {
            switch (p.getType()) {
                case STANDARD -> antalStandard++;
                case KORESTOL -> antalK++;
                case EKSTRA_BENPLADS -> antalEB++;
            }
        }
        System.out.println(" - Standard: " + antalStandard);
        System.out.println(" - Kørestol (K): " + antalK + " (række 10, nr 6-10)");
        System.out.println(" - Ekstra benplads (EB): " + antalEB + " (række 11, nr 6-10)");
        System.out.println("\n=== Alle pladser ===");
        int i = 0;
        for (Plads p : Storage.getPladser()) {
            System.out.printf(" - R%02d-%02d  %-17s  %d kr.%n",
                    p.getRaekke(), p.getNr(), p.getType(), p.getPris());
            i++;
        }
        System.out.println("Antal pladser i alt: " + i);

    }
}
