package controller;

import model.Forestilling;
import model.Kunde;
import model.Plads;
import model.PladsType;
import storage.Storage;

import java.time.LocalDate;

public class Controller {

    public static Forestilling opretForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling f = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(f);
        return f;
    }

    public static Kunde opretKunde(String navn, String mobil) {
        Kunde k = new Kunde(navn, mobil);
        Storage.addKunde(k);
        return k;
    }

    public static Plads opretPlads(int raekke, int nr, int pris, PladsType type) {
        Plads p = new Plads(raekke, nr, pris, type);
        Storage.addPlads(p);
        return p;
    }
}
