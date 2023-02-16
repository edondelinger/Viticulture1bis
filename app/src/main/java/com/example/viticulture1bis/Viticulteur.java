package com.example.viticulture1bis;


public class Viticulteur {
    private long idV;
    private String nomV;
    private int niveauV;

    public Viticulteur(long idV, String nomV, int niveauV) {
        this.idV = idV;
        this.nomV = nomV;
        this.niveauV = niveauV;
    }

    public Viticulteur(String nomV, int niveauV) {
        this.idV = -1;
        this.nomV = nomV;
        this.niveauV = niveauV;
    }

    public long getIdV() {
        return idV;
    }

    public void setIdV(long idV) {
        this.idV = idV;
    }

    public String getNomV() {
        return nomV;
    }

    public void setNomV(String nomV) {
        this.nomV = nomV;
    }

    public int getNiveauV() {
        return niveauV;
    }

    public void setNiveauV(int niveauV) {
        this.niveauV = niveauV;
    }

    public String toString(){
        return "idV="+idV+",nomV="+nomV+",niveauV="+niveauV;
    }
}
