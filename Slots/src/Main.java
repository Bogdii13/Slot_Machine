import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static void startGame() {
        double buget = 100;
        ArrayList<String> posibilitati = new ArrayList<>(Arrays.asList("Diamant", "Cireasa", "Bar"));
        Scanner cititor = new Scanner(System.in);
        Scanner cititorText = new Scanner(System.in);
        Random generator = new Random();

        while (true) {
            System.out.println("Intoruceti miza. Bugetul vostru este de " + buget);
            double miza = cititor.nextDouble();
            if (miza > buget) {
                System.out.println("nu ai atatia bani");
            } else {
                // scad miza din buget
                buget-=miza;
                //O sa tragem de maneta
                System.out.println("Am tras de maneta");
                String rezultat1 = posibilitati.get(generator.nextInt(posibilitati.size()));
                String rezultat2 = posibilitati.get(generator.nextInt(posibilitati.size()));
                String rezultat3 = posibilitati.get(generator.nextInt(posibilitati.size()));

                printeazaRezultatele(rezultat1, rezultat2, rezultat3);

                if (rezultat1.equals(rezultat2) && rezultat2.equals(rezultat3)){
                    System.out.println("JACKPOT");
                    double deAdaugat=(30.0/100.0)+miza;
                    buget+=miza+deAdaugat;
                }else if (rezultat2.equals(rezultat3)){
                    System.out.println("SEMI-JACPOT");
                    double deAdaugat=(90.0/100.0)+miza;
                    buget+=miza+deAdaugat;
                }else {
                    System.out.println("Ai pierdut");
                }

                if (buget<=1){
                    System.out.println("Ai pierdut jocul");
                    break;
                }else if (buget>=1000){
                    System.out.println("Ai facut bani");
                    break;
                }
            }
        }
    }

    private static void printeazaRezultatele(String rezultat1, String rezultat2, String rezultat3) {
        System.out.println("[" + rezultat1 + "] [" + rezultat2 + "] [" + rezultat3 + "]");
    }

    public static void main(String[] args) {


        Scanner cititorText = new Scanner(System.in);

        System.out.println("Doriti sa incepem jocul?");
        String raspuns = cititorText.nextLine();
        if (raspuns.equalsIgnoreCase("da")) {
            startGame();
        } else if (raspuns.equalsIgnoreCase("nu")) {
            System.out.println("Puteai castiga");
        } else {
            System.out.println("Trebuie sa raspunzi cu da sau nu ");
        }
    }
}
