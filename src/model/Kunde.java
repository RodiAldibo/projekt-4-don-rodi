package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kunde {
    private  String navn;
    private  String mobil;
    private  List<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() { return navn; }
    public String getMobil() { return mobil; }

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
        return navn + " (" + mobil + ")";
    }
}
