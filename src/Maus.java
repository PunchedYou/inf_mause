public class Maus {
    private int nummer;
    private int staerke;

    public Maus(int nummer, int staerke) {
        this.nummer = nummer;
        this.staerke = staerke;
    }

    public int getNummer() {
        return nummer;
    }

    public int getStaerke() {
        return staerke;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }
}
