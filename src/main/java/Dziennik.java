import java.util.*;

public class Dziennik extends Student1 {

    public static int[] oceny = new int[3]; //tablica z ocenami
    public Przedmiot[] przedmiot = new Przedmiot[3]; //tabilica z przedmiotami
    public static Collection<Dziennik> ocenyStudentow = new ArrayList();

    public Dziennik() {
    }

    public Dziennik(String imie, String nazwisko, Kierunek kierunek, Integer rok, Przedmiot[] przedmiot, int[] oceny) {
        super();
        this.przedmiot = przedmiot;
        Dziennik.oceny = oceny;
    }

    public int[] getOceny() {
        return oceny;
    }

    public static void ocenyStudentowVoid() { //metoda dodająca pozycje do collection oceny studentow

        Random r = new Random();
        int max = 5;
        int min = 2;

        for (Student1 stud : studenci) {
            Dziennik newDziennik = new Dziennik();
            newDziennik.setImie(stud.getImie());
            newDziennik.setNazwisko(stud.getNazwusko());
            newDziennik.setKierunek(stud.getKierunekEnum());
            newDziennik.setRok(stud.getRok());

            switch (newDziennik.getKierunek()) { //przypisywanie przedmiotow do kierunkow
                case "Informatyka":
                    newDziennik.przedmiot[0] = Przedmiot.Analiza;
                    newDziennik.przedmiot[1] = Przedmiot.Informatyka;
                    newDziennik.przedmiot[2] = Przedmiot.Podstawy_Programownia;
                    break;
                case "Zarzadzanie":
                    newDziennik.przedmiot[0] = Przedmiot.Astronomia;
                    newDziennik.przedmiot[1] = Przedmiot.Polski;
                    newDziennik.przedmiot[2] = Przedmiot.Zarzadzanie;
                    break;
                case "Filologia":
                    newDziennik.przedmiot[0] = Przedmiot.Angielski;
                    newDziennik.przedmiot[1] = Przedmiot.Analiza;
                    newDziennik.przedmiot[2] = Przedmiot.Matematyka;
                    break;
            }

            //losowanie liczb dla przedmiotow - nie działa poprawnie - te same wartosci przypisują się oceny[i] dla kazdego studenta
            for (int i = 0; i < oceny.length; ++i) {
//                Random r = new Random();
//                int max = 5;
//                int min = 2;
                int random = r.nextInt(max - min) + min;
                oceny[i] = random;
            }

            ocenyStudentow.add(newDziennik);
        }

    }

    public static void sredniaStudenta() { //metoda liczaca srednia dla studetna po nazwisku
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwisko studenta, dla którego chcesz wyświetlić średnią ocen: ");
        String nazwiskoFiltr = scan.nextLine();
        double srednia = 0.0D;
        if(!ocenyStudentow.isEmpty()){
            for(Dziennik oceny: ocenyStudentow){
                if(oceny.getNazwusko().equals(nazwiskoFiltr)){
                    System.out.println(oceny.imie + " " + oceny.nazwisko);
                    for(int i = 0; i < oceny.getOceny().length ; i++){

                        System.out.println(oceny.przedmiot[i] + " = " + oceny.oceny[i]);

                        srednia += (double) oceny.oceny[i];
                    }

                }
            }
        }

        srednia /= oceny.length;

        System.out.println("Średnia dla studenta " + nazwiskoFiltr + " wynosi " + srednia);
    }

    public static void sredniaZPrzedmiotu() { //srednia z przediotu dla wszystkich studentow
        Scanner scan = new Scanner(System.in);
        System.out.println("Z jakiego przedmiotu chcesz wyświetlić średnią: ");
        String przedmiotFiltr = scan.nextLine();
        double srednia = 0.0D;
        int counter = 0;
        if (!ocenyStudentow.isEmpty()) {

            for (Dziennik oceny : ocenyStudentow) {
                for (int i = 0; i < oceny.przedmiot.length; ++i) {
                    if (oceny.przedmiot[i].toString().equals(przedmiotFiltr)) {
                        srednia += (double) Dziennik.oceny[i];
                        ++counter;
                    }
                }
            }
        }

        srednia /= (double)counter;
        System.out.print("Średnia z przedmiotu " + przedmiotFiltr + " wynosi " + srednia);
    }

    public static void sredniaDlaRoku() { //srednia ocen dla calego roku
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj rok studiów, dla którego chesz wyświetlić średnią: ");
        int rokFiltr = scan.nextInt();
        scan.nextLine();
        double srednia = 0.0D;
        int counter = 0;
        if(!ocenyStudentow.isEmpty()){
            for(Dziennik oceny: ocenyStudentow){
                if(oceny.getRok() == rokFiltr){
                    for(int i = 0; i < oceny.oceny.length; i++){
                        srednia += (double) oceny.oceny[i];
                        counter++;
                    }
                }

            }
        }
        srednia = (double) srednia / counter;
        System.out.println ("Średnia ocen dla " + rokFiltr + " roku studiów wynosi" + srednia);
    }

    public String toString() {
        return "{Imię = " + this.imie + ", nazwisko = " + this.nazwisko + ", kierunek = " + this.kierunek + ", rok = " + this.rok + ", przedmioty = " + Arrays.toString(this.przedmiot) + ", oceny = " + Arrays.toString(oceny) + "}";
    }

    public static void wyswietlOceny() { //metoda wyswietlajaca colelection oceny

        for (Dziennik dz : ocenyStudentow) {
            if (ocenyStudentow.size() != 0) {
                System.out.println(dz);
            } else {//jezeli zbior jest pusty
                System.out.println("Lista jest pusta!");
            }
        }

    }

}
