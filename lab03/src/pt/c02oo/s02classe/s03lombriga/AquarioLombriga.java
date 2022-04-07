package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamAquario, tamLombriga, posLombriga;
    boolean paraDireita;
	
	AquarioLombriga(int tamAquario, int tamLombriga, int posLombriga) {
        if (tamAquario > 15)
            this.tamAquario = 15;
        else
		    this.tamAquario = tamAquario;

        if (tamLombriga > tamAquario)
            this.tamLombriga = tamAquario;
        else
            this.tamLombriga = tamLombriga;
        
        if (posLombriga > tamAquario || posLombriga + tamLombriga > tamAquario)
            this.posLombriga = 1;
        else
            this.posLombriga = posLombriga;
        
        this.paraDireita = false;
	}
	
	void crescer() {
		if ((paraDireita && posLombriga - tamLombriga > 0) ||
            (!paraDireita && posLombriga + tamLombriga - 1 < tamAquario))
            tamLombriga++;
	}

    void mover() {
        if (paraDireita && posLombriga < tamAquario)
            posLombriga++;
        else if (!paraDireita && posLombriga > 1)
            posLombriga--;
        else
            virar();
    }

    void virar() {
    	if (paraDireita)
    		posLombriga -= tamLombriga - 1;
    	else
    		posLombriga += tamLombriga - 1;
        paraDireita = !paraDireita;
    }

    String apresenta() {
        // cria um aquário vazio
        char aquario[] = new char[tamAquario];
        for (int i = 0; i < tamAquario; i++)
            aquario[i] = '#';

        // cabeça da lombriga
        aquario[posLombriga - 1] = 'O';
        
        // corpo da lombriga
        if (paraDireita) {
            for (int i = posLombriga - 2; i > posLombriga - tamLombriga - 1; i--)
                aquario[i] = '@';
        } else
            for (int i = posLombriga; i < posLombriga + tamLombriga - 1; i++)
                aquario[i] = '@';
        
        return String.valueOf(aquario);
    }

}
