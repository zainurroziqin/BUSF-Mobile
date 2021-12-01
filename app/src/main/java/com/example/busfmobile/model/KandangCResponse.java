package com.example.busfmobile.model;

import java.util.List;

public class KandangCResponse {
    private int kode;
    private String pesan;
    private List<KandangC> kandangC_list;

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

    public List<KandangC> getKandangC_list() {
        return kandangC_list;
    }

    public void setKandangC_list(List<KandangC> kandangC_list) {
        this.kandangC_list = kandangC_list;
    }
}
