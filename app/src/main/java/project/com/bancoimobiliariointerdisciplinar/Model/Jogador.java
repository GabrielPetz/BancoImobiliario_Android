package project.com.bancoimobiliariointerdisciplinar.Model;

import android.arch.persistence.room.Entity;

import project.com.bancoimobiliariointerdisciplinar.StaticFunction.GenerateRandomId;

/**
 * Created by User on 25/04/2018.
 */
@Entity
public class Jogador {

    protected Integer jogid;

    private String nome;

    private String senha;

    private String nick;


    public Jogador() {
        this.jogid = null;
        this.nome = null;
        this.senha = null;
        this.nick = null;
    }

    public Jogador(String nome, String senha, String nick) {
        this.nome = nome;
        this.senha = senha;
        this.nick = nick;
    }

    public Integer getJogid() {
        return jogid;
    }

    public void setJogid(Integer jogid) {
        this.jogid = jogid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}