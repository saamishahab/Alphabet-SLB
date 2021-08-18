package com.guru.alphabetslb;

public class Provider_Alphabet {

    String nama;
    String keyword;
    int alpha_img;

    public Provider_Alphabet(String nama, String keyword, int alpha_img) {
        this.nama = nama;
        this.keyword = keyword;
        this.alpha_img = alpha_img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getAlpha_img() {
        return alpha_img;
    }

    public void setAlpha_img(int alpha_img) {
        this.alpha_img = alpha_img;
    }
}
