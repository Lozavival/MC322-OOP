package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
    AquarioLombriga lombrigaNoAquario;
    String passos;
    int proximoPasso, numPassos;

    Animacao(String animacao) {
        int tamAquario = Integer.parseInt(animacao, 0, 2, 10);
        int tamLombriga = Integer.parseInt(animacao, 2, 4, 10);
        int posLombriga = Integer.parseInt(animacao, 4, 6, 10);

        this.proximoPasso = 0;
        this.passos = animacao.substring(6);
        this.numPassos = this.passos.length();
        
        this.lombrigaNoAquario = new AquarioLombriga(tamAquario, tamLombriga, posLombriga);
        
    }

    String apresenta() {
        return lombrigaNoAquario.apresenta();
    }

    void passo() {
        switch (passos.charAt(proximoPasso)) {
            case 'C':
                lombrigaNoAquario.crescer();
                break;
            case 'M':
                lombrigaNoAquario.mover();
                break;
            case 'V':
                lombrigaNoAquario.virar();
                break;
        }
        proximoPasso++;
    }

}
