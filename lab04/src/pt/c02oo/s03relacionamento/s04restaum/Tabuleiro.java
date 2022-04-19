package pt.c02oo.s03relacionamento.s04restaum;

import java.util.HashMap;

public class Tabuleiro {
    private HashMap<String, Peca> tabuleiro = new HashMap<String, Peca>();

    public Tabuleiro() {
        for (char coluna = 'a'; coluna <= 'g'; coluna++)
            for (int linha = 1; linha <= 7; linha++)
                if (casaValida(coluna, linha))
                    colocaPeca(coluna, linha, null);
        removePeca("d4");  // remove a peça central
    }

    public boolean casaValida(char coluna, int linha) {
        return ((linha < 3 || linha > 5) && (coluna > 'b' && coluna < 'f')) ||
               (linha > 2 && linha < 6);
    }

    private void colocaPeca(char coluna, int linha, Peca peca) {
        if (casaValida(coluna, linha)) {
            char casa[] = {coluna, (char) (linha + 48)};
            if (peca == null) peca = new Peca(casa, this);
            tabuleiro.put(String.valueOf(casa), peca);
        }
    }

    private void removePeca(String casa) {
        tabuleiro.remove(casa);
    }

    public Peca buscaPeca(String casa) {
        return tabuleiro.get(casa);
    }

    public boolean movePeca(String movimento[]) {
        String origem = movimento[0];
        char[] destino = movimento[1].toCharArray();
        Peca pecaMovida = buscaPeca(origem);
        String casaPecaCapturada = null;
        
        if (pecaMovida != null && casaValida(destino[0], Character.getNumericValue(destino[1]))) {
            // se a peça a ser movida existe e o destino está dentro dos limites do tabuleiro
            casaPecaCapturada = pecaMovida.move(destino);
            if (casaPecaCapturada != null) {  // se movimento possível, atualiza o tabuleiro
                removePeca(casaPecaCapturada);
                colocaPeca(destino[0], Character.getNumericValue(destino[1]), pecaMovida);
                removePeca(origem);
            }
        }

        return casaPecaCapturada != null;  // retorna se houve ou não sucesso em mover a peça
    }

    public char[][] apresenta() {
        char tabuleiro[][] = new char[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
            	char casa[] = {(char) (j+97), (char) (i+49)};
                if (!casaValida(casa[0], i + 1))
                    tabuleiro[i][j] = ' ';
                else if (buscaPeca(String.valueOf(casa)) != null)
                    tabuleiro[i][j] = 'P';
                else
                	tabuleiro[i][j] = '-';
            }
        }

        return tabuleiro;
    }
}
