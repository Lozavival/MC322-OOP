package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
    private char posicao[];
    private Tabuleiro tabuleiro;
    
    public Peca(char[] posicao, Tabuleiro tabuleiro) {
    	setTabuleiro(tabuleiro);
        setPosicao(posicao);
    }

    public void setPosicao(char[] posicao) {
        if (tabuleiro.casaValida(posicao[0], Character.getNumericValue(posicao[1])))
            this.posicao = posicao;
    }

    public String getPosicao() {
        return String.valueOf(posicao);
    }
    
    public void setTabuleiro(Tabuleiro tabuleiro) {
    	this.tabuleiro = tabuleiro;
    }

    public String move(char[] destino) {
        int deltaColuna = destino[0] - posicao[0];
        int deltaLinha = destino[1] - posicao[1];

        if ((Math.abs(deltaColuna) == 2 && deltaLinha == 0) || (deltaColuna == 0 && Math.abs(deltaLinha) == 2)) {  // movimento unidimensional
            char casaPecaCapturada[] = {(char) (posicao[0] + deltaColuna/2), (char) (posicao[1] + deltaLinha/2)};

            if (tabuleiro.buscaPeca(String.valueOf(destino)) == null &&  // a casa de destino está vazia
                tabuleiro.buscaPeca(String.valueOf(casaPecaCapturada)) != null) {  // há uma peça para ser comida entre a posição atual e o destino
                setPosicao(destino);
                return String.valueOf(casaPecaCapturada);
            }
        }

        return null;
    }
}
