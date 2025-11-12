package model;

public class Plads {
    private int raekke;
    private int nr;
    private int pris;
    private PladsType type;

    public Plads(int raekke, int nr, int pris, PladsType type) {
        this.raekke = raekke;
        this.nr = nr;
        this.pris = pris;
        this.type = type;
    }

    public int getRaekke() {
        return raekke;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    public PladsType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("R%s-%s (%s, %skr.)", raekke, nr, type, pris);
    }
}
