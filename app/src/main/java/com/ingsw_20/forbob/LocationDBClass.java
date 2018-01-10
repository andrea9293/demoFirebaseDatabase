package com.ingsw_20.forbob;

import java.util.List;

/**
 * Created by andre on 10/01/2018.
 */

public class LocationDBClass {
    private String name;
    private List<PostiSettori> settori_posti;
    private String indirizzo;
    private String id;

    public LocationDBClass(String id, String name, List<PostiSettori> settori_posti, String indirizzo) {
        this.id = id;
        this.name = name;
        this.settori_posti = settori_posti;
        this.indirizzo = indirizzo;
    }

    public String getName() {
        return name;
    }

    public List<PostiSettori> getSettori_posti() {
        return settori_posti;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getId() {
        return id;
    }
}



