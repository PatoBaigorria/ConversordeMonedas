package com.patriciasoft.conversor.modelo;

public class Conversor {
    private String importeD;
    private String importeE;
    private String importeR;
    private boolean dolares;
    private boolean euros;

    public Conversor(String importeD, String importeE, String importeR, boolean dolares, boolean euros) {
        this.importeD = importeD;
        this.importeE = importeE;
        this.importeR = importeR;
        this.dolares = dolares;
        this.euros = euros;
    }

    public String getImporteD() {
        return importeD;
    }

    public void setImporteD(String importeD) {
        this.importeD = importeD;
    }

    public String getImporteE() {
        return importeE;
    }

    public void setImporteE(String importeE) {
        this.importeE = importeE;
    }

    public String getImporteR() {
        return importeR;
    }

    public void setImporteR(String importeR) {
        this.importeR = importeR;
    }

    public boolean isDolares() {
        return dolares;
    }

    public void setDolares(boolean Dolares) {
        this.dolares = Dolares;
    }

    public boolean isEuros() {
        return euros;
    }

    public void setEuros(boolean Euros) {
        this.euros = Euros;
    }
}
