import java.util.*;

public class Dziennik extends Student {

    public static int[] oceny = new int[3];
    public Przedmiot[] przedmiot = new Przedmiot[3];
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

    public static void ocenyStudentowVoid() {
        Iterator var0 = studenci.iterator();

        while(var0.hasNext()) {
            Student stud = (Student)var0.next();
            Dziennik newDziennik = new Dziennik();
            newDziennik.setImie(stud.getImie());
            newDziennik.setNazwisko(stud.getNazwusko());
            newDziennik.setKierunek(stud.getKierunekEnum());
            newDziennik.setRok(stud.getRok());
            String var3 = newDziennik.getKierunek();
            byte var4 = -1;
            switch(var3.hashCode()) {
                case -658483053:
                    if (var3.equals("Informatyka")) {
                        var4 = 0;
                    }
                    break;
                case 751406225:
                    if (var3.equals("Zarzadzanie")) {
                        var4 = 1;
                    }
                    break;
                case 985832822:
                    if (var3.equals("Filologia")) {
                        var4 = 2;
                    }
            }

            switch(var4) {
                case 0:
                    newDziennik.przedmiot[0] = Przedmiot.Analiza;
                    newDziennik.przedmiot[1] = Przedmiot.Informatyka;
                    newDziennik.przedmiot[2] = Przedmiot.Podstawy_Programownia;
                    break;
                case 1:
                    newDziennik.przedmiot[0] = Przedmiot.Astronomia;
                    newDziennik.przedmiot[1] = Przedmiot.Polski;
                    newDziennik.przedmiot[2] = Przedmiot.Zarzadzanie;
                    break;
                case 2:
                    newDziennik.przedmiot[0] = Przedmiot.Angielski;
                    newDziennik.przedmiot[1] = Przedmiot.Analiza;
                    newDziennik.przedmiot[2] = Przedmiot.Matematyka;
            }

            for(int i = 0; i < oceny.length; ++i) {
                Random r = new Random();
                int max = 5;
                int min = 2;
                int random = r.nextInt(max - min) + min;
                oceny[i] = random;
            }

            ocenyStudentow.add(newDziennik);
        }

    }

    public static void sredniaStudenta() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwisko studenta, dla którego chcesz wyświetlić średnią ocen: ");
        String nazwiskoFiltr = scan.nextLine();
        double srednia = 0.0D;
        if (!ocenyStudentow.isEmpty()) {
            Iterator var4 = ocenyStudentow.iterator();

            label25:
            while(true) {
                Dziennik oceny;
                do {
                    if (!var4.hasNext()) {
                        break label25;
                    }

                    oceny = (Dziennik)var4.next();
                } while(!oceny.getNazwusko().equals(nazwiskoFiltr));

                System.out.println(oceny.imie + " " + oceny.nazwisko);

                for(int i = 0; i < oceny.getOceny().length; ++i) {
                    Przedmiot var10001 = oceny.przedmiot[i];
                    System.out.println(var10001 + " = " + Dziennik.oceny[i]);
                    srednia += (double)Dziennik.oceny[i];
                }
            }
        }

        srednia /= (double)Dziennik.oceny.length;
        System.out.println("Średnia dla studenta " + nazwiskoFiltr + " wynosi " + srednia);
    }

    public static void sredniaZPrzedmiotu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Z jakiego przedmiotu chcesz wyświetlić średnią: ");
        String przedmiotFiltr = scan.nextLine();
        double srednia = 0.0D;
        int counter = 0;
        if (!ocenyStudentow.isEmpty()) {
            Iterator var5 = ocenyStudentow.iterator();

            while(var5.hasNext()) {
                Dziennik oceny = (Dziennik)var5.next();

                for(int i = 0; i < oceny.przedmiot.length; ++i) {
                    if (oceny.przedmiot[i].toString().equals(przedmiotFiltr)) {
                        srednia += (double)Dziennik.oceny[i];
                        ++counter;
                    }
                }
            }
        }

        srednia /= (double)counter;
        System.out.print("Średnia z przedmiotu " + przedmiotFiltr + " wynosi " + srednia);
    }

    public static void sredniaDlaRoku() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj rok studiów, dla którego chesz wyświetlić średnią: ");
        int rokFiltr = scan.nextInt();
        scan.nextLine();
        double srednia = 0.0D;
        int counter = 0;
        if (!ocenyStudentow.isEmpty()) {
            Iterator var5 = ocenyStudentow.iterator();

            label25:
            while(true) {
                Dziennik oceny;
                do {
                    if (!var5.hasNext()) {
                        break label25;
                    }

                    oceny = (Dziennik)var5.next();
                } while(oceny.getRok() != rokFiltr);

                for(int i = 0; i < Dziennik.oceny.length; ++i) {
                    srednia += (double)Dziennik.oceny[i];
                    ++counter;
                }
            }
        }

        srednia /= (double)counter;
        System.out.println("Średnia ocen dla " + rokFiltr + " roku studiów wynosi" + srednia);
    }

    public String toString() {
        String var10000 = this.imie;
        return "{Imię = " + var10000 + ", nazwisko = " + this.nazwisko + ", kierunek = " + this.kierunek + ", rok = " + this.rok + ", przedmioty = " + Arrays.toString(this.przedmiot) + ", oceny = " + Arrays.toString(oceny) + "}";
    }

    public static void wyswietlOceny() {
        Iterator var0 = ocenyStudentow.iterator();

        while(var0.hasNext()) {
            Dziennik dz = (Dziennik)var0.next();
            if (ocenyStudentow.size() != 0) {
                System.out.println(dz);
            } else {
                System.out.println("Lista jest pusta!");
            }
        }

    }

}
