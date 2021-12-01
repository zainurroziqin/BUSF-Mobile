package com.example.busfmobile.model;

import java.util.List;

public class KandangBResponse {
    private int kode;
    private String pesan;
    private List<KandangB> kandangB_list;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<KandangB> getKandangB_list() {
        return kandangB_list;
    }

    public void setKandangB_list(List<KandangB> kandangB_list) {
        this.kandangB_list = kandangB_list;
    }
}
