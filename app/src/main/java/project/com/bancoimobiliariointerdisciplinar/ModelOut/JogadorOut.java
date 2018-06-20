package project.com.bancoimobiliariointerdisciplinar.ModelOut;

/**
 * Created by User on 25/04/2018.
 */

public class JogadorOut {

    protected Integer jogid;
    private String jognome;
    private String jogsenha;
    private String jognick;
    private Integer jogstatus;

    public JogadorOut() {

    }


    public JogadorOut(Integer jogid, String jognome, String jogsenha, String jognick, Integer jogstatus) {
        this.jogid = jogid;
        this.jognome = jognome;
        this.jogsenha = jogsenha;
        this.jognick = jognick;
        this.jogstatus = jogstatus;
    }

    @Override
    public String toString() {
        return "JogadorOut{" +
                "jogid=" + jogid +
                ", jognome='" + jognome + '\'' +
                ", jogsenha='" + jogsenha + '\'' +
                ", jognick='" + jognick + '\'' +
                '}';
    }

    public Integer getJogid() {
        return jogid;
    }

    public void setJogid(Integer jogid) {
        this.jogid = jogid;
    }

    public String getJognome() {
        return jognome;
    }

    public void setJognome(String jognome) {
        this.jognome = jognome;
    }

    public String getJogsenha() {
        return jogsenha;
    }

    public void setJogsenha(String jogsenha) {
        this.jogsenha = jogsenha;
    }

    public String getJognick() {
        return jognick;
    }

    public void setJognick(String jognick) {
        this.jognick = jognick;
    }

    public Integer getJogstatus() {
        return jogstatus;
    }

    public void setJogstatus(Integer jogstatus) {
        this.jogstatus = jogstatus;
    }
}