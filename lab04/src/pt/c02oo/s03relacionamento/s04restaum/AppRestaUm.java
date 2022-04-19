package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

    public static void main(String[] args) {
        AppRestaUm.executaJogo(null, null);
    }

    public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
        Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);

        String commands[] = tk.retrieveCommands();
        Tabuleiro tabuleiro = new Tabuleiro();

        tk.writeBoard("Tabuleiro inicial", tabuleiro.apresenta());
        for (int l = 0; l < commands.length; l++) {
            String movimento[] = commands[l].split(":");

            if (tabuleiro.movePeca(movimento))  // se houve movimento, imprime o novo estado do tabuleiro
                tk.writeBoard(String.format("source: %s; target: %s", movimento[0], movimento[1]),
                              tabuleiro.apresenta());
        }

        tk.stop();
    }

}
