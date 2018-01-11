package com.ingsw_20.forbob;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by andre on 11/01/2018.
 */

class ModelPezzotto extends Observable {
    private static final ModelPezzotto ourInstance = new ModelPezzotto();

    static ModelPezzotto getInstance() {
        return ourInstance;
    }

    private ModelPezzotto() {}

    public void addObservers(Observer observer){
        addObserver(observer);
    }

    private String risultato;

    public void setRisultato(String risultato) {
        this.risultato = risultato;
        setChanged();
        notifyObservers();
    }

    public String getRisultato() {
        return risultato;
    }
}
