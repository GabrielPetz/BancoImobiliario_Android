package project.com.bancoimobiliariointerdisciplinar.ModelIn;

import android.arch.persistence.room.Entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Created by User on 25/04/2018.
 */
@Entity
public class Partida {
    private Integer parid;
    private String parnome;
    private Date pardata;
    private Integer parstatus;

    public Partida(String parnome, Date pardata, Integer parstatus) {
        this.parnome = parnome;
        this.pardata = pardata;
        this.parstatus = parstatus;
    }

    public Partida() {
        this.parid = null;
        this.parnome = null;
        this.pardata = null;
        this.parstatus = null;
    }

    public Integer getParid() {
        return parid;
    }

    public void setParid(Integer parid) {
        this.parid = parid;
    }

    public String getParnome() {
        return parnome;
    }

    public void setParnome(String parnome) {
        this.parnome = parnome;
    }

    public Date getPardata() {
        return pardata;
    }

    public void setPardata(Date pardata) {
        this.pardata = pardata;
    }

    public Integer getParstatus() {
        return parstatus;
    }

    public void setParstatus(Integer parstatus) {
        this.parstatus = parstatus;
    }
}
