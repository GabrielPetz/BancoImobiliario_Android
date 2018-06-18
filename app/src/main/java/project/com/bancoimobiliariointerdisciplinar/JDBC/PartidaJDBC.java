package project.com.bancoimobiliariointerdisciplinar.JDBC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

import project.com.bancoimobiliariointerdisciplinar.Factory.DatabaseFactory;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Partida;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.PartidaOut;

public class PartidaJDBC {

    private SQLiteDatabase db;
    private DatabaseFactory banco;

    public PartidaJDBC(Context context) {
        banco = new DatabaseFactory(context);
    }

    public PartidaOut getPartida(Integer id){

        PartidaOut partida = new PartidaOut();

        Cursor cur;

        String[] campos = {"parid", "parnome", "pardata", "parstatus"};

        String where = "parid = " + id;

        db = banco.getReadableDatabase();

        cur = db.query("partida", campos, where,null,null,null,null);

        if(cur != null){
            cur.moveToFirst();
            partida.setParid(cur.getInt(cur.getColumnIndexOrThrow("parid")));
            partida.setPardata(cur.getString(cur.getColumnIndexOrThrow("pardata")));
            partida.setParnome(cur.getString(cur.getColumnIndexOrThrow("parnome")));
            partida.setParstatus(cur.getInt(cur.getColumnIndexOrThrow("parstatus")));
        }
        return partida;
    }

    public PartidaOut getPartida(String nome){

        PartidaOut partida = new PartidaOut();

        Cursor cur;

        String[] campos = {"parid", "parnome", "pardata", "parstatus"};

        String where = "parnome = " + nome;

        db = banco.getReadableDatabase();

        cur = db.query("partida", campos, where,null,null,null,null);

        if(cur != null){
            cur.moveToFirst();
            partida.setParid(cur.getInt(cur.getColumnIndexOrThrow("parid")));
            partida.setPardata(cur.getString(cur.getColumnIndexOrThrow("pardata")));
            partida.setParnome(cur.getString(cur.getColumnIndexOrThrow("parnome")));
            partida.setParstatus(cur.getInt(cur.getColumnIndexOrThrow("parstatus")));
        }
        return partida;
    }

    public Long insertPartida(Partida partida){

        ContentValues val = new ContentValues();

        db = banco.getWritableDatabase();

        val.put("pardata", partida.getPardata().toString());
        val.put("parnome", partida.getParnome());

        long res = db.insert("partida",null, val);

        return res;
    }

    public Integer updatePartida (Partida partida){

        ContentValues val = new ContentValues();

        db = banco.getWritableDatabase();

        val.put("parnome", partida.getParnome());
        val.put("pardata", partida.getPardata().toString());

        String where  = "parid = "+ partida.getParid();

        int res = db.update("partida",  val, where, null);

        return res;
    }

    public void deletePartida(Integer id){

        db = banco.getWritableDatabase();

        db.delete("partida" , "parid = " + id, null);


    }

    public void closePartida(Integer id){

        db = banco.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("parstatus", 0);
        db.update("partida", val, "parid = " + id, null);

    }

}
