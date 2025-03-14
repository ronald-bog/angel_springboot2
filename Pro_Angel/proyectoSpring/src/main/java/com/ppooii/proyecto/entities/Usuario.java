package com.ppooii.proyecto.entities;

import java.security.SecureRandom;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario", schema = "PPOOII_PF")
public class Usuario implements Serializable {

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getContrasenaGenerada() {
        return contrasenaGenerada;
    }

    public void setContrasenaGenerada(String contrasenaGenerada) {
        this.contrasenaGenerada = contrasenaGenerada;
    }

    @Id
    private Long idPersona;

    @Column( nullable = false, unique = true)
    private String login;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "apikey")
    private String apiKey;

    @OneToOne
    private Persona persona;

    public static String generarContraseniaSegura(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder contrasena = new StringBuilder();
    
        for (int i = 0; i < longitud; i++) {
            int indice = secureRandom.nextInt(caracteres.length());
            contrasena.append(caracteres.charAt(indice));
        }
    
        return contrasena.toString();
    }

    public Usuario() {
    }

    public Usuario(Long idPersona, String login, String contrasenia, String apiKey, String contrasenaGenerada) {
        this.idPersona = idPersona;
        this.login = login;
        this.contrasenia = contrasenia;
        this.apiKey = apiKey;
        this.contrasenaGenerada = contrasenaGenerada;
    }

    String contrasenaGenerada = generarContraseniaSegura(12);

}
