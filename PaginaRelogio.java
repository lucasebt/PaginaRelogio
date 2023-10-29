
package paginarelogio;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class PaginaRelogio {
    int numeroPagina;
    int instrucao;
    int dado;
    int bitReferencia;
    int bitModificado;
    int tempoEnvelhecimento;
    boolean emMemoria;

    public PaginaRelogio(int numeroPagina, int instrucao, int dado, int tempoEnvelhecimento) {
        this.numeroPagina = numeroPagina;
        this.instrucao = instrucao;
        this.dado = dado;
        this.bitReferencia = 0;
        this.bitModificado = 0;
        this.tempoEnvelhecimento = tempoEnvelhecimento;
        this.emMemoria = false;
    }
}