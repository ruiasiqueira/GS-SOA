package com.example.demo.usuario.dto;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String tipoSanguineo;
    private String alergia;

    public UsuarioDTO() {}

    public UsuarioDTO(String nome, String email, String tipoSanguineo, String alergia) {
        this.nome = nome;
        this.email = email;
        this.tipoSanguineo = tipoSanguineo;
        this.alergia = alergia;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
}
