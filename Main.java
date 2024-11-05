// Za Wikipedią: "Liczby zaprzyjaźnione to para różnych liczb naturalnych, takich,
//że suma dzielników każdej z tych liczb równa się drugiej (nie uwzględniając tych dwóch
//liczb jako dzielników)."
//Np. liczba 284 ma dzielniki: 1, 2, 4, 71, 142, których suma daje 220, a
//liczba 220 ma dzielniki: 1, 2, 4, 5, 10,11, 20, 22, 44, 55, 110, których suma daje 284.
//Zatem liczby 220 i 284 tworzą, parę liczb zaprzyjaźnionych.
//Należy napisać program, który dla dowolnej pary różnych liczb naturalnych będzie rozstrzygał,
//czy para ta tworzy liczby zaprzyjaźnione

import java.util.Scanner; //Pobieranie danych od użytkownika
import java.util.ArrayList; //Przechowywanie danych w postaci listy


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Podaj pierwszą liczbę naturalną: ");
        int liczba1 = wczytajLiczbe(scanner);
        if(liczba1 <= 0) {
            do {
                System.out.println("Liczba musi być wieksza od 0 !!!");
                System.out.print("Podaj poprawną liczbę naturalną: ");
                liczba1 = wczytajLiczbe(scanner);
            }while (liczba1 <= 0);
        }

        System.out.print("Podaj drugą liczbę naturalną: ");
        int liczba2 = wczytajLiczbe(scanner);
        if(liczba2 <= 0 || liczba1 == liczba2) {
            do {
                if(liczba2 <= 0){
                    System.out.println("Liczba musi być wieksza od 0 !!!");
                }else if (liczba1 == liczba2){
                    System.out.println("Podane liczby muszą być różne !!!");
                }
                System.out.print("Podaj poprawną liczbę naturalną: ");
                liczba2 = wczytajLiczbe(scanner);
            } while (liczba2 <= 0 || liczba1 == liczba2);
        }
        System.out.println();

        int sumaDzielnikowLiczby1 = sumaDzielnikow(liczba1);
        int sumaDzielnikowLiczby2 = sumaDzielnikow(liczba2);

        System.out.println("Dzielniki pierwszej liczby (" + liczba1 + "): " + wyswietlDzielniki(liczba1));
        System.out.println("Suma dzielników pierwszej liczby (" + liczba1 + ") = " + sumaDzielnikowLiczby1);

        System.out.println();

        System.out.println("Dzielniki drugiej liczby (" + liczba2 + "): " + wyswietlDzielniki(liczba2));
        System.out.println("Suma dzielników drugiej liczby (" + liczba2 + ") = " + sumaDzielnikowLiczby2);

        System.out.println();

        if (czyZaprzyjaznione(liczba1, liczba2)) {
            System.out.println("Liczby " + liczba1 + " i " + liczba2 + " są zaprzyjaźnione.");
        } else {
            System.out.println("Liczby " + liczba1 + " i " + liczba2 + " nie są zaprzyjaźnione.");
        }
    }
    //Metoda sprawdzająca czy podana rzecz jest liczbą
    private static int wczytajLiczbe(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest liczba naturalna! ");
            System.out.println("Podaj poprawną liczbę naturalną: ");
            scanner.next(); // Pobiera błędne dane wejściowe, bez tego pętla ciągle by sie wykonywała
        }
        return scanner.nextInt();
    }

    // Metoda sprawdzająca, czy para liczb tworzy liczby zaprzyjaźnione
    private static boolean czyZaprzyjaznione(int liczba1, int liczba2) {
        return (sumaDzielnikow(liczba1) == liczba2) && (sumaDzielnikow(liczba2) == liczba1);
    }

    // Metoda obliczająca sumę dzielników danej liczby
    private static int sumaDzielnikow(int liczba) {
        int suma = 0;
        for (int i = 1; i <= liczba / 2; i++) {
            if (liczba % i == 0) {
                suma += i;
            }
        }
        return suma;
    }

    // Metoda zwracająca napis z dzielnikami danej liczby
    private static String wyswietlDzielniki(int liczba) {
        ArrayList<String> dzielnikiLista = new ArrayList<>();

        for (int i = 1; i <= liczba / 2; i++) {
            if (liczba % i == 0) {
                dzielnikiLista.add(Integer.toString(i));
            }
        }

        return String.join(" ", dzielnikiLista);
    }
}