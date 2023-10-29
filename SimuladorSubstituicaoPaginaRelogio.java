
package paginarelogio;

import java.util.Random;

public class SimuladorSubstituicaoPaginaRelogio {
    public static void main(String[] args) {
        int TAMANHO_RAM = 10;
        Ram ram = new Ram(TAMANHO_RAM);
        Random random = new Random();

        // Preencher a RAM com páginas aleatórias da matriz SWAP
        for (int i = 0; i < TAMANHO_RAM; i++) {
            int indicePaginaAleatoria = random.nextInt(100);
            int tempoEnvelhecimentoAleatorio = random.nextInt(9900) + 100; // Entre 100 e 9999
            PaginaRelogio pagina = new PaginaRelogio(indicePaginaAleatoria, i + 1, random.nextInt(50) + 1, tempoEnvelhecimentoAleatorio);
            pagina.emMemoria = true;
            ram.paginas[i] = pagina;
        }

        // Imprimir MATRIZ RAM no início
        System.out.println("MATRIZ RAM no início:");
        imprimirMatriz(ram);

        int instrucoes = 0;
        while (instrucoes < 1000) {
            int instrucaoAleatoria = random.nextInt(100) + 1;
            if (ram.contemPagina(instrucaoAleatoria)) {
                // Página está na RAM
                for (PaginaRelogio pagina : ram.paginas) {
                    if (pagina != null && pagina.instrucao == instrucaoAleatoria) {
                        pagina.bitReferencia = 1;
                        if (random.nextDouble() < 0.3) {
                            pagina.dado += 1;
                            pagina.bitModificado = 1;
                        }
                    }
                }
            } else {
                // Página não está na RAM, precisa de substituição (Relógio)
                while (true) {
                    PaginaRelogio paginaAtual = ram.paginas[ram.ponteiroRelogio];
                    if (paginaAtual.bitReferencia == 0) {
                        // Esta página pode ser substituída
                        paginaAtual.emMemoria = false;
                        if (paginaAtual.bitModificado == 1) {
                            // Salvar a página em SWAP com M=0
                            // Implemente essa lógica
                        }
                        int indicePaginaAleatoria = random.nextInt(100);
                        int tempoEnvelhecimentoAleatorio = random.nextInt(9900) + 100;
                        PaginaRelogio novaPagina = new PaginaRelogio(indicePaginaAleatoria, instrucaoAleatoria, random.nextInt(50) + 1, tempoEnvelhecimentoAleatorio);
                        novaPagina.emMemoria = true;
                        ram.paginas[ram.ponteiroRelogio] = novaPagina;
                        break;
                    } else {
                        paginaAtual.bitReferencia = 0;
                    }
                    ram.ponteiroRelogio = (ram.ponteiroRelogio + 1) % TAMANHO_RAM;
                }
            }

            instrucoes++;

            if (instrucoes % 10 == 0) {
                ram.resetarBitsDeReferencia();
            }
        }

        // Imprimir MATRIZ RAM no final
        System.out.println("MATRIZ RAM no final:");
        imprimirMatriz(ram);

        // Imprimir MATRIZ SWAP no início e no final
        System.out.println("MATRIZ SWAP no início:");
        imprimirMatrizSwap();
        // Implemente a lógica para preencher a MATRIZ SWAP com dados aleatórios

        System.out.println("MATRIZ SWAP no final:");
        imprimirMatrizSwap();
        // Implemente a lógica para atualizar a MATRIZ SWAP no final
    }

    // Função para imprimir MATRIZ RAM
    public static void imprimirMatriz(Ram ram) {
        for (PaginaRelogio pagina : ram.paginas) {
            if (pagina != null) {
                System.out.println("N: " + pagina.numeroPagina + " I: " + pagina.instrucao + " D: " + pagina.dado + " R: " + pagina.bitReferencia + " M: " + pagina.bitModificado + " T: " + pagina.tempoEnvelhecimento);
            }
        }
    }

    // Função para imprimir MATRIZ SWAP (apenas as 10 primeiras páginas)
    public static void imprimirMatrizSwap() {
        for (int i = 0; i < 10; i++) {
            System.out.println("N: " + i + " I: " + (i + 1) + " D: " + (i + 1) + " R: 0 M: 0 T: " + (i + 100));
        }
    }
}
