import java.util.*;

public class Student extends Osoba{

    Kierunek kierunek;
    Integer rok;
    public static Collection<Student> studenci;

    public Student(String imie, String nazwisko, Plec plec, Integer wiek, Long pesel, String adres, Kierunek kierunek, Integer rok) {
        super(imie, nazwisko, plec, wiek, pesel, adres);
        this.kierunek = kierunek;
        this.rok = rok;
    }

    Student() {
    }


    public String getKierunek() {
        return this.kierunek.toString();
    }

    public Kierunek getKierunekEnum() {
        return this.kierunek;
    }

    public Integer getRok() {
        return this.rok;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public static void zarejestrjStudenta() { //metoda rejestrująca nowego studenta

        Student nowyStudent = new Student();
        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadź nowego studenta:");
        System.out.println("Imię: ");
        nowyStudent.setImie(scan.nextLine());
        System.out.println("Nazwisko: ");
        nowyStudent.setNazwisko(scan.nextLine());
        System.out.println("Plec (M/K): ");
        String plecForEnum = scan.nextLine();
        Plec plecToEnum = Plec.valueOf(plecForEnum); //konwertuje string na enum
        nowyStudent.setPlec(plecToEnum);
        System.out.println("Wiek: ");
        nowyStudent.setWiek(scan.nextInt());
        scan.nextLine(); //czyta enter
        System.out.println("Pesel: ");
        nowyStudent.setPesel(scan.nextLong());
        scan.nextLine(); //czyta enter
        System.out.println("Adres: ");
        nowyStudent.setAdres(scan.nextLine());
        System.out.println("Kierunek - podaj liczbę: (1.Informatyka, 2.Zarzadzanie, 3.Filologia) ");
        int podajKierunek = scan.nextInt();
        scan.nextLine();
        //po podaniu numeru switch dobiera odpowiedni kierunek
        switch (podajKierunek) {
            case 1 -> nowyStudent.setKierunek(Kierunek.Informatyka);
            case 2 -> nowyStudent.setKierunek(Kierunek.Zarzadzanie);
            case 3 -> nowyStudent.setKierunek(Kierunek.Filologia);
        }

        System.out.println("Rok studiów: ");
        nowyStudent.setRok(scan.nextInt());
        scan.nextLine(); //czyta enter
        studenci.add(nowyStudent); //dodaje nowy obiekt student odreślony przez zmienne wprowadzione przez usera do kolekcji
    }

    public static void wyswietlStudentow() {
        int a = 0; // counter, liczy studentow
        if(!studenci.isEmpty()){ //if lista rozna 0
            System.out.println ("Lista studentów na uczelni: ");
            for (Student studenci: studenci){
                System.out.println (studenci);
                a++;
            }
            System.out.println("Ilość studentów na uczekni: " + a); // wykorzystuje counter
        }
        else {
            System.out.println("W sytemie nie ma wprowadzonch studentów!"); //w przypadku kiedy liste jest pusta
        }
    }

    public static void studenciNaKierunku() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Z jakiego kierunu studentów chcesz wyświetlić: ");
        String kierunekFiltr = scan.nextLine();
        int b = 0;
        if (!Student.studenci.isEmpty()) {
            System.out.println("Lista studentów na uczelni, na kierunku " + kierunekFiltr + ": ");

            for (Student studenci : Student.studenci) {
                if (studenci.getKierunek().equals(kierunekFiltr)) {
                    System.out.println(studenci.toString());
                    ++b;
                } else {
                    System.out.println("Nie ma obecnie studentów na tym kierunku");
                }
            }
        }

    }

    public static void studenciNaRoku() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Z jakiego roku studentów chcesz wyświetlić: ");
        int rokFiltr = scan.nextInt();
        int counter = 0;
        if (!Student.studenci.isEmpty()) {
            System.out.println("Lista studentów na " + rokFiltr + " roku studiów:");

            for (Student studenci : Student.studenci) {
                if (studenci.getRok() == rokFiltr) {
                    System.out.println(studenci);
                    ++counter;
                }
            }

            System.out.println("Na " + rokFiltr + " roku znajduje się " + counter + " studentów.");
        } else {
            System.out.println("Lista studentów jest pusta!");
        }

    }

    public static void studenciNaRokuIKierunku() {
        Scanner scan = new Scanner (System.in);

        System.out.println("Podaj kierunek, z którego chcesz wyświetlić studentów: ");
        String kierunekFiltr = scan.nextLine();

        System.out.println("Podaj rok, z którego chesz wyświetlić studentów: ");
        int rokFiltr = scan.nextInt();
        scan.nextLine();

        int counter = 0;

        if(!studenci.isEmpty()){

            for(Student studenci: studenci){
                if(studenci.getKierunek().equals(kierunekFiltr) && studenci.getRok() == rokFiltr){

                    System.out.println(studenci);
                    counter++;

                }

                System.out.println("Na " + rokFiltr + " na kierunku " + kierunekFiltr +
                        " studiuje " + counter + " studentów.");
            }
        } else {System.out.println("Lista studentów jest pusta!");}
    }

    public static void wyszukajPoNazwisku() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwisko szukanego studenta: ");
        String nazwiskoFiltr = scan.nextLine();
        int counter = 0;
        if (!Student.studenci.isEmpty()) { //jezeli lista nie jest pusta

            for (Student studenci : Student.studenci) {
                if (studenci.getNazwusko().equals(nazwiskoFiltr)) {
                    System.out.print(studenci);
                    ++counter;
                }
            }

            if (counter != 0) {
                System.out.println("Na liście jset " + counter + " studentów o nazwisku " + nazwiskoFiltr);
            } else {
                System.out.println("Na liście nie ma studentów o takim nazwisku");
            }
        } else { //jezeli lista jest pusta
            System.out.println("Lista studentów jest pusta");
        }

    }

    public static void wyszukajPoAdresie() { //metoda umozliwaiaiajca szukanie studentow po adresie - porownuje wprowadzo adres z adresem z listy
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj imię szukanego studenta: ");
        String adresFiltr = scan.nextLine();
        int counter = 0;
        if (!studenci.isEmpty()) { //jeseli lista sutdentow nie jest pusta

            for (Student stud : studenci) {
                if (stud.getAdres().equals(adresFiltr)) {
                    System.out.println(stud);
                    ++counter;
                }
            }

            if (counter == 0) { //jezeli nie znaleziono studenta o szukanum adresie
                System.out.println("Nie ma osoby z takim adresem na liście studentów");
            } else {//jezeli znajeziono min 1 studenta o szukanym adresie
                System.out.println("Na liście znajduje się " + counter + " studentów zamieszkałych w " + adresFiltr);
            }
        } else { //jezeli lista studentow jest pusta
            System.out.println("Lista studentów jest pusta");
        }

    }

    public String toString() {
        return "Student{imie = " + this.imie + ", nazwisko = " + this.nazwisko + ", płeć = " + this.plec + ", wiek = " + this.wiek + ", pesel = " + this.pesel + ", adres = " + this.adres + ", kierunek = " + this.kierunek + ", rok studiów = " + this.rok + "}";
    }

    static {
        studenci = new ArrayList(Arrays.asList(
                new Student("Kuba", "Jarek", Plec.M, 18, 71616126626L, "nielany", Kierunek.Informatyka, 2),
                new Student("su", "per", Plec.K, 18, 89548464L, "wwa", Kierunek.Filologia, 2),
                new Student("wa", "krzy", Plec.M, 18, 715418164L, "opole", Kierunek.Zarzadzanie, 2)));
    }
}
