import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            //System.out.println("Informe um numero: ");
            numero = sc.nextInt();

            if (!(numero >= 0)) {
                System.out.println("Informe um valor maior que 0");
            }

        } while (!(numero >= 0));

        HashSet<Integer> numeros = new HashSet<>();
        boolean repetido = false;

        while (numero != 1 && !repetido) {

            int[] digitos = retornaDigitos(numero);


            int soma = 0;
            for (int i = 0; i < digitos.length; i++) {
                soma += Math.pow(digitos[i], 2);
            }

            // Si esta repetido, lo marcamos
            if (!numeros.add(numero)) {
                repetido = true;
            }
            numero = soma;
        }

        if (numero == 1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static int[] retornaDigitos(int numero) {

        if (numero == 0) {
            int digitos[] = {0};
            return digitos;
        }
        int digitos[] = new int[conta(numero)];
        int digito;
        int numeroOriginal = Math.abs(numero);
        for (int i = 0, j = digitos.length - 1, copiaNumero = numeroOriginal; numeroOriginal > 0; i++, j--) {

            copiaNumero /= 10;
            digito = numeroOriginal - (copiaNumero * 10);
            digitos[j] = digito;
            numeroOriginal = copiaNumero;
        }
        return digitos;
    }

    public static int conta(int num) {

        int contador = 0;
        if (num == 0) {
            contador = 1;
        } else {
            for (int i = Math.abs(num); i > 0; i /= 10) {
                contador++;
            }
        }
        return contador;
    }

}

