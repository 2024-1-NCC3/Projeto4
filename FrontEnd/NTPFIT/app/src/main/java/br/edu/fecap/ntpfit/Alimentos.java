package br.edu.fecap.ntpfit;

public class Alimentos {
    String nome;
    private String kcal;
    public Alimentos(String nome, String kcal){
        this.nome = nome;
        this.kcal = kcal;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getKcal(){
        return kcal;
    }
    public void setKcal(String  kcal){
        this.kcal = kcal;
    }
}
