package project.com.bancoimobiliariointerdisciplinar.JDBC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import project.com.bancoimobiliariointerdisciplinar.Factory.DatabaseFactory;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.JogadorPartida;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.JogadorPartidaOut;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.PartidaOut;

public class JogadorPartidaJDBC {

    private SQLiteDatabase db;
    private DatabaseFactory banco;

    public JogadorPartidaJDBC(Context context) {
        banco = new DatabaseFactory(context);
    }

    public Long newPartida(JogadorPartida jogpar){
        db = banco.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put("jpapino", jogpar.getJpapino());
        val.put("jpajogador", jogpar.getJpajogador());
        val.put("jpapartida", jogpar.getJpapartida());

        long res = db.insert("jogadorpartida", null, val);

        db.close();

        return res;

    }

    public JogadorPartida getJogadorPartida(Integer partida){
        db = banco.getReadableDatabase();

        JogadorPartida jogout = new JogadorPartida();

        Cursor cur;

        String[] campos = {"jpajogador", "jpapartida", "jpapino"};
        
        String where = "jpapartida =" + partida;

        cur = db.query("jogadorpartida", campos, where, null, null, null, null, null);

        if(cur.getCount() > 0){
            jogout.setJpajogador(cur.getInt(cur.getColumnIndexOrThrow("jpajogador")));
            jogout.setJpapartida(cur.getInt(cur.getColumnIndexOrThrow("jpapartida")));
            jogout.setJpapino(cur.getInt(cur.getColumnIndexOrThrow("jpapino")));
        }
        db.close();

        return jogout;
    }



    public long checkPino(Integer idjogador, Integer idpartida, Integer idpino){



        return 0;
    }

    public void delete(Integer idjogador, Integer idpartida, Integer idpino){

    }

    public void eraseData(){
        db = banco.getWritableDatabase();

        db.delete("jogadorpartida", null, null);
    }


}
