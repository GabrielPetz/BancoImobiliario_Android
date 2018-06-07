package project.com.bancoimobiliariointerdisciplinar.Model;

import android.arch.persistence.room.Entity;

/**
 * Created by User on 25/04/2018.
 */
@Entity
public class Propriedade {
    private Integer proid;
    private String prolote;
    private Integer procasa;
    private Integer protipolote;
    private Double provalorcompra;
    private Double provaloraluguel1;
    private Double provaloraluguel2;
    private Double provaloraluguel3;
    private Double provaloraluguel4;
    private Double provaloraluguelhotel;

    public  Propriedade(){
        this.proid = null;
        this.prolote = null;
        this.procasa = null;
        this.protipolote = null;
        this.provalorcompra = null;
        this.provaloraluguel1 = null;
        this.provaloraluguel2 = null;
        this.provaloraluguel3 = null;
        this.provaloraluguel4 = null;
        this.provaloraluguelhotel = null;

    }

    public Propriedade(String prolote, Integer procasa, Integer protipolote, Double provalorcompra, Double provaloraluguel1, Double provaloraluguel2, Double provaloraluguel3, Double provaloraluguel4, Double provaloraluguelhotel) {
        this.prolote = prolote;
        this.procasa = procasa;
        this.protipolote = protipolote;
        this.provalorcompra = provalorcompra;
        this.provaloraluguel1 = provaloraluguel1;
        this.provaloraluguel2 = provaloraluguel2;
        this.provaloraluguel3 = provaloraluguel3;
        this.provaloraluguel4 = provaloraluguel4;
        this.provaloraluguelhotel = provaloraluguelhotel;
    }


    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProlote() {
        return prolote;
    }

    public void setProlote(String prolote) {
        this.prolote = prolote;
    }

    public Integer getProcasa() {
        return procasa;
    }

    public void setProcasa(Integer procasa) {
        this.procasa = procasa;
    }

    public Integer getProtipolote() {
        return protipolote;
    }

    public void setProtipolote(Integer protipolote) {
        this.protipolote = protipolote;
    }

    public Double getProvalorcompra() {
        return provalorcompra;
    }

    public void setProvalorcompra(Double provalorcompra) {
        this.provalorcompra = provalorcompra;
    }

    public Double getProvaloraluguel1() {
        return provaloraluguel1;
    }

    public void setProvaloraluguel1(Double provaloraluguel1) {
        this.provaloraluguel1 = provaloraluguel1;
    }

    public Double getProvaloraluguel2() {
        return provaloraluguel2;
    }

    public void setProvaloraluguel2(Double provaloraluguel2) {
        this.provaloraluguel2 = provaloraluguel2;
    }

    public Double getProvaloraluguel3() {
        return provaloraluguel3;
    }

    public void setProvaloraluguel3(Double provaloraluguel3) {
        this.provaloraluguel3 = provaloraluguel3;
    }

    public Double getProvaloraluguel4() {
        return provaloraluguel4;
    }

    public void setProvaloraluguel4(Double provaloraluguel4) {
        this.provaloraluguel4 = provaloraluguel4;
    }

    public Double getProvaloraluguelhotel() {
        return provaloraluguelhotel;
    }

    public void setProvaloraluguelhotel(Double provaloraluguelhotel) {
        this.provaloraluguelhotel = provaloraluguelhotel;
    }
}
