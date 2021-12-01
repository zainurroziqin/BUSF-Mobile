package com.example.busfmobile.model;

import java.util.List;

public class KandangDResponse {
    private int kode;
    private String pesan;
    private List<KandangD> kandangD_list;

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

    public List<KandangD> getKandangD_list() {
        return kandangD_list;
    }

    public void setKandangD_list(List<KandangD> kandangD_list) {
        this.kandangD_list = kandangD_list;
    }
}
