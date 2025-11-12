package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bestilling {
    private LocalDate dato;
    private Kunde kunde;
    private Forestilling forestilling;
    private List<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
        this.dato = dato;
        this.kunde = kunde;
        this.forestilling = forestilling;

        if (this.kunde != null) {
            this.kunde.addBestilling(this);
        }
        if (this.forestilling != null) {
            this.forestilling.addBestilling(this);
        }
    }

    public LocalDate getDato() {
        return dato;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    public List<Plads> getPladser() {
        return Collections.unmodifiableList(pladser);
    }

    public void addPlads(Plads plads) {
        if (plads != null && !pladser.contains(plads)) {
            pladser.add(plads);
        }
    }

    public void addPladser(List<Plads> flerePladser) {
        if (flerePladser != null) {
            for (Plads p : flerePladser) {
                addPlads(p);
            }
        }
    }

    @Override
    public String toString() {
        return "Bestilling{" + dato + ", " + kunde + ", " + forestilling + ", pladser=" + pladser.size() + "}";
    }
}
