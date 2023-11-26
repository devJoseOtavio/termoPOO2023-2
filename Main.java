import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("java");
        palavras.add("poo");
        palavras.add("univille");
        palavras.add("sexta");

        Random random = new Random();
        String palavraChave = palavras.get(random.nextInt(palavras.size()));

        String letraUsada = "";
        StringBuilder palavraAdivinhada = new StringBuilder();

        int MAX_TENTATIVAS = 10;

        for (int i = 0; i < palavraChave.length(); i++) {
            palavraAdivinhada.append("_");
        }

        int tentativas = 0;

        while (tentativas < MAX_TENTATIVAS) {
            System.out.printf("Rodada %d. Até agora adivinhada: %s. Qual a sua próxima letra?%n", tentativas + 1, palavraAdivinhada);

            char letraTentada = new Scanner(System.in).next().charAt(0);

            if (letraUsada.indexOf(letraTentada) >= 0) {
                System.out.printf("Você já tentou a letra %c.%n", letraTentada);
            } else {
                letraUsada += letraTentada;

                if (palavraChave.indexOf(letraTentada) >= 0) {
                    boolean todasLetrasDescobertas = true;

                    for (int j = 0; j < palavraChave.length(); j++) {
                        if (letraUsada.indexOf(palavraChave.charAt(j)) >= 0) {
                            palavraAdivinhada.setCharAt(j, palavraChave.charAt(j));
                        } else {
                            todasLetrasDescobertas = false;
                        }
                    }

                    if (todasLetrasDescobertas) {
                        System.out.printf("Parabéns! A palavra adivinhada era '%s'%n", palavraAdivinhada);
                        System.exit(0);
                    } else {
                        System.out.printf("Muito bom! %c existe na palavra, digite as próximas letras%n", letraTentada);
                    }
                } else {
                    System.out.printf("A letra %c não existe na palavra.%n", letraTentada);
                }

                tentativas++;
            }
        }

        System.out.printf("Você excedeu o número de tentativas, a palavra era %s%n", palavraChave);
    }
}