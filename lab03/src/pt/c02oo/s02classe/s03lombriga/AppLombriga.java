package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

public static void main(String[] args) {
    Toolkit tk = Toolkit.start();

    String lombrigas[] = tk.recuperaLombrigas();
    Animacao animacaoAtual;

    for (int l = 0; l < lombrigas.length; l++) {
        animacaoAtual = new Animacao(lombrigas[l]);

        tk.gravaPasso("=====");
        tk.gravaPasso(animacaoAtual.apresenta()); // grava a lombriga no estado inicial
        for (int p = 0; p < animacaoAtual.numPassos; p++) {
            animacaoAtual.passo();
            tk.gravaPasso(animacaoAtual.apresenta());
        }
    }

    tk.stop();
    }

}
