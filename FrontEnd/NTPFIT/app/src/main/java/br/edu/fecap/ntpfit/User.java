package br.edu.fecap.ntpfit;

public class User {
    private String nome;
    private String idade;
    private String telefone;
    private String peso;
    private String email;
    private String senha;

    public User(String nome, String idade, String telefone, String peso, String email, String senha){
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.peso = peso;
        this.email = email;
        this.senha = senha;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
