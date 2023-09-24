package td1.exo2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Fibbo {
    private static long compteur = 0;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("entrer le nombre: ");
//        int num = sc.nextInt();
        Fibbo fib = new Fibbo();
//        System.out.printf("Fib(%d)=%d en %d appels%n", num, fib.fib(num), compteur);
        fib.rapport("tempsExecution.csv");
    }

    public long fib(int n) {
        compteur++;
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public void rapport(String nomFichier) throws IOException {
        File f = new File(nomFichier);
        try( PrintWriter pw = new PrintWriter(f)){
            pw.println("nombre,temps en seconde,nombre appels");
            for(int i = 0 ; i < 55 ; i++){
                compteur = 0;
                Instant start = Instant.now();
                long nombre = fib(i);
                Instant finish = Instant.now();
                long timeElapsed = Duration.between(start, finish).toSeconds();
                pw.printf("%d,%d,%d%n",nombre, timeElapsed, compteur);
            }
        }
    }
}
