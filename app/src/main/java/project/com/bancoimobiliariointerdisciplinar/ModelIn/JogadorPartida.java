package project.com.bancoimobiliariointerdisciplinar.ModelIn;

import android.content.Intent;
import android.content.IntentFilter;

public class JogadorPartida {
    private Integer jpajogador;
    private Integer jpapartida;
    private Integer jpapino;

    public JogadorPartida() {
    }

    public Integer getJpajogador() {
        return jpajogador;
    }

    public void setJpajogador(Integer jpajogador) {
        this.jpajogador = jpajogador;
    }

    public Integer getJpapartida() {
        return jpapartida;
    }

    public void setJpapartida(Integer jpapartida) {
        this.jpapartida = jpapartida;
    }

    public Integer getJpapino() {
        return jpapino;
    }

    public void setJpapino(Integer jpapino) {
        this.jpapino = jpapino;
    }
}
