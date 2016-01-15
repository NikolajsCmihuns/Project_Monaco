package com.monaco.entities;

/**
 * Created by maksimspuskels on 15/12/15.
 */

public class Health {
    private String status;

    protected Health() {
    }

    public Health(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
