public abstract class Osoba {
    String imie;
    String nazwisko;
    Plec plec;
    Integer wiek;
    Long pesel;
    String adres;

    public Osoba(String imie, String nazwisko, Plec plec, Integer wiek, Long pesel, String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.wiek = wiek;
        this.pesel = pesel;
        this.adres = adres;
    }

    public Osoba() {
    }

    public Osoba(String imie, String nazwisko) {
    }

    public String getImie() {
        return this.imie;
    }

    public String getNazwusko() {
        return this.nazwisko;
    }

    public String getPlec() {
        return this.plec.toString();
    }

    public Integer getWiek() {
        return this.wiek;
    }

    public Long getPesel() {
        return this.pesel;
    }

    public String getAdres() {
        return this.adres;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPlec(Plec plec) {
        this.plec = plec;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Plec getPlecEnum() {
        return this.plec;
    }

    public String toString() {
        return "Osoba {, imie = " + this.imie + ", nazwisko = " + this.nazwisko + ", plec = " + this.plec + ", wiek = " + this.wiek + ", pesel = " + this.pesel + ", adres = " + this.adres + "}";
    }
}
