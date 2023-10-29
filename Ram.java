
package paginarelogio;

public class Ram {
    PaginaRelogio[] paginas;
    int tamanho;
    int ponteiroRelogio;

    public Ram(int tamanho) {
        this.tamanho = tamanho;
        paginas = new PaginaRelogio[tamanho];
        ponteiroRelogio = 0;
    }

    public boolean contemPagina(int instrucao) {
        for (PaginaRelogio pagina : paginas) {
            if (pagina != null && pagina.instrucao == instrucao) {
                return true;
            }
        }
        return false;
    }

    public void resetarBitsDeReferencia() {
        for (PaginaRelogio pagina : paginas) {
            if (pagina != null) {
                pagina.bitReferencia = 0;
            }
        }
    }
}