import java.util.Random;  // Importando a classe Random

public class App {
    static int[] tamanhosTesteGrande =  { 125_000, 250_000, 500_000, 1_000_000, 2_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    static Random aleatorio = new Random(42);  // Agora a classe Random foi importada corretamente

    // Código de teste 1
    static int codigo1(int[] vetor) {
        int resposta = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
        }
        return resposta;
    }

    // Código de teste 2
    static int codigo2(int[] vetor) {
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
            }
        }
        return contador;
    }

    // Código de teste 3 (ordenação por seleção)
    static void codigo3(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    }

    // Código de teste 4 (recursivo Fibonacci)
    static int codigo4(int n) {
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1) + codigo4(n - 2);
    }

    // Gerador de vetores aleatórios de tamanho pré-definido
    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        }
        return vetor;
    }

    // Método principal para realizar os testes
    public static void main(String[] args) {
        // Teste para o código 1 (Teste Grande)
        System.out.println("Teste para Código 1 (Teste Grande):");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);

            // Testando o Código 1
            long startTime = System.nanoTime();
            int resultado1 = codigo1(vetor);
            long endTime = System.nanoTime();
            long duration1 = endTime - startTime;
            System.out.println("Código 1, Tamanho " + tamanho + ": Tempo " + duration1 + " ns, Resultado " + resultado1);
        }

        // Teste para o código 2 (Teste Grande)
        System.out.println("\nTeste para Código 2 (Teste Grande):");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);

            // Testando o Código 2
            long startTime = System.nanoTime();
            int resultado2 = codigo2(vetor);
            long endTime = System.nanoTime();
            long duration2 = endTime - startTime;
            System.out.println("Código 2, Tamanho " + tamanho + ": Tempo " + duration2 + " ns, Operações " + resultado2);
        }

        // Teste para o código 3 (Teste Médio)
        System.out.println("\nTeste para Código 3 (Teste Médio):");
        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);

            // Testando o Código 3
            long startTime = System.nanoTime();
            codigo3(vetor);
            long endTime = System.nanoTime();
            long duration3 = endTime - startTime;
            System.out.println("Código 3, Tamanho " + tamanho + ": Tempo " + duration3 + " ns");
        }

        // Teste para o código 4 (Teste Pequeno)
        System.out.println("\nTeste para Código 4 (Teste Pequeno):");
        for (int tamanho : tamanhosTestePequeno) {
            long startTime = System.nanoTime();
            int resultado4 = codigo4(tamanho);
            long endTime = System.nanoTime();
            long duration4 = endTime - startTime;
            System.out.println("Código 4, Tamanho " + tamanho + ": Tempo " + duration4 + " ns, Resultado " + resultado4);
        }
    }
}
