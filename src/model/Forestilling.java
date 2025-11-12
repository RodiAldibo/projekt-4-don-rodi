package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private List<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
        }
    }

    public List<Bestilling> getBestillinger() {
        return Collections.unmodifiableList(bestillinger);
    }

    @Override
    public String toString() {
        return navn + " (" + startDato + "–" + slutDato + ")";
    }
}
