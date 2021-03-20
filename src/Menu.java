import java.util.Scanner;

public class Menu {

    public static void menu() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Wybierz sekcję, do której checesz przejść: ");
            System.out.println("1 - Studenci");
            System.out.println("2 - Wykładowcy - OUT OF ORDER");
            System.out.println("3 - eIndeks");
            System.out.println("");
            System.out.println("Wybierz operację");
            int x = scan.nextInt();
            int y;
            if (x == 1) {
                System.out.println("1 - Podaj ilość studentów na uczelni");
                System.out.println("2 - Podaj ilość studentów na danym kierunku");
                System.out.println("3 - Podaj ilość studentów na danym roku");
                System.out.println("4 - Podaj ilość studentów na danym kierunku i roku");
                System.out.println("5 - Wyszukaj studenta po nazwisku");
                System.out.println("6 - Wyszukaj studenta po adresie");
                System.out.println("7 - Zarejestruj studenta");
                System.out.println("0 - Manu główne");
                System.out.println("");
                System.out.println("Wybierz kolejną operację");
                y = scan.nextInt();
                scan.nextLine();
                switch (y) { //do wybierania operacji z menu podanej przez uzytkowniak
                    case 0:
                        menu();
                        break;
                    case 1:
                        Student.wyswietlStudentow();
                        break;
                    case 2:
                        Student.studenciNaKierunku();
                        break;
                    case 3:
                        Student.studenciNaRoku();
                        break;
                    case 4:
                        Student.studenciNaRokuIKierunku();
                        break;
                    case 5:
                        Student.wyszukajPoNazwisku();
                        break;
                    case 6:
                        Student.wyszukajPoAdresie();
                        break;
                    case 7:
                        Student.zarejestrjStudenta();
                        break;
                    default:
                        System.out.println("Wybiersz poprawną operację!");
                }

                menu(); //porwort to menu glownego
            }

            if (x == 3) {
                System.out.println("1 - Wyświetl wszystkich studentów");
                System.out.println("2 - Wyszukaj oceny i średnią studenta po nazwisku");
                System.out.println("3 - Wyświetl średnią z przedmiotu");
                System.out.println("4 - Wyświetl średnią dla danego roku");
                System.out.println("0 - Powrót do menu głównego");
                System.out.println("");
                System.out.println("Wybierz numer operacji z menu eIndeks: ");
                y = scan.nextInt();
                Dziennik.ocenyStudentowVoid();
                switch (y) {
                    case 0:
                        menu();
                    default: //dla innej wartosci niz przewidziana
                        System.out.println("Podaj właściwy numer operacji!");
                        break;
                    case 1:
                        Dziennik.wyswietlOceny();
                        break;
                    case 2:
                        Dziennik.sredniaStudenta();
                        break;
                    case 3:
                        Dziennik.sredniaZPrzedmiotu();
                        break;
                    case 4:
                        Dziennik.sredniaDlaRoku();
                        break;
                }
                menu();

            } else { //jezeli zostanie wpisana inna wartosc niz z podanych w menu
                System.out.println("Wybierz poprawną operację!");
                menu();
            }
    } catch (java.util.InputMismatchException e){ //catch missmatchexc dla niepoprawnie wpisanego znaku
            System.out.println("Podaj poprawną wartość!");
            menu();
        }

        }
}
