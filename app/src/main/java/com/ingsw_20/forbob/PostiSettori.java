package com.ingsw_20.forbob;

/**
 * Created by andre on 10/01/2018.
 */

public class PostiSettori {
    private String settore;
    private Integer posti;

    public PostiSettori(String settore, Integer posti) {
        this.settore = settore;
        this.posti = posti;
    }

    public String getSettore() {
        return settore;
    }

    public Integer getPosti() {
        return posti;
    }
}
