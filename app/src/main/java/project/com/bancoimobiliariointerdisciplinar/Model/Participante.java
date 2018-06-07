package project.com.bancoimobiliariointerdisciplinar.Model;

import android.arch.persistence.room.Entity;

/**
 * Created by User on 25/04/2018.
 */
@Entity
public class Participante extends Jogador {
    private Integer ptrid;
    private Integer ptrjpgadpr;
    private Double ptrsaldo;
    private String ptrpino;

    public Participante(Integer ptrjpgadpr, Double ptrsaldo, String ptrpino) {
        this.ptrjpgadpr = ptrjpgadpr;
        this.ptrsaldo = ptrsaldo;
        this.ptrpino = ptrpino;
    }
    public Participante() {
        this.ptrid = null;
        this.ptrjpgadpr = null;
        this.ptrsaldo = null;
        this.ptrpino = null;
    }


    public Integer getPtrid() {
        return ptrid;
    }

    public void setPtrid(Integer ptrid) {
        this.ptrid = ptrid;
    }

    public Integer getPtrjpgadpr() {
        return ptrjpgadpr;
    }

    public void setPtrjpgadpr(Integer ptrjpgadpr) {
        this.ptrjpgadpr = ptrjpgadpr;
    }

    public Double getPtrsaldo() {
        return ptrsaldo;
    }

    public void setPtrsaldo(Double ptrsaldo) {
        this.ptrsaldo = ptrsaldo;
    }

    public String getPtrpino() {
        return ptrpino;
    }

    public void setPtrpino(String ptrpino) {
        this.ptrpino = ptrpino;
    }
}
