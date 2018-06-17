package project.com.bancoimobiliariointerdisciplinar.Interface;

import android.arch.persistence.room.Dao;
import android.content.Context;

import java.util.List;

import project.com.bancoimobiliariointerdisciplinar.JDBC.JogadorJDBC;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Jogador;
@Dao
public interface IJogador {

    Jogador getJogador(Integer id);

    Jogador getJogador(String nome);

    Long insertJogador(Jogador jogador);

    Integer updateJogador(Jogador jogador);

    Integer updateSenha(Integer id, String newPassword);

    void deleteJogador(Integer id);

}
