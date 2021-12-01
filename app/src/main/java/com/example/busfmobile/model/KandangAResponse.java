package com.example.busfmobile.model;

import java.util.List;

public class KandangAResponse {
    private int kode;
    private String pesan;
    private List<KandangA> kandangA_list;

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

    public List<KandangA> getKandangA_list() {
        return kandangA_list;
    }

    public void setKandangA_list(List<KandangA> kandangA_list) {
        this.kandangA_list = kandangA_list;
    }
}
