package project.com.bancoimobiliariointerdisciplinar.JDBC;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import android.content.Context;

import project.com.bancoimobiliariointerdisciplinar.Factory.DatabaseFactory;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Jogador;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.JogadorOut;
import project.com.bancoimobiliariointerdisciplinar.Util.BancoStatitcs;

public class JogadorJDBC {


    private SQLiteDatabase db;
    private DatabaseFactory banco;

    public JogadorJDBC(Context context) {
        banco = new DatabaseFactory(context);
    }


    public JogadorOut getJogador(Integer id) {

        Cursor cur;

        String[] campos = {"jogid", "jognome", "jognick"};
        db = banco.getReadableDatabase();

        String where = "jognome=" + id + " and jogstatus = 1";

        cur = db.query(BancoStatitcs.TABELA_JOGADOR, campos, where, null, null, null, null);


        JogadorOut jog = new JogadorOut();


        if (cur != null) {
            cur.moveToFirst();
            jog.setJogid(cur.getInt(cur.getColumnIndexOrThrow("jogid")));
            jog.setJognick(cur.getString(cur.getColumnIndexOrThrow("jognick")));
            jog.setJognome(cur.getString(cur.getColumnIndexOrThrow("jognome")));
        }
        db.close();

        return jog;

    }

    public JogadorOut getJogador(String nome) {
        Cursor cur;

        String[] campos = {"jogid", "jognome", "jognick"};
        db = banco.getReadableDatabase();

        String where = "jognome like '" + nome + "'";

        cur = db.query(BancoStatitcs.TABELA_JOGADOR, campos, where, null, null, null, null);


        JogadorOut jog = new JogadorOut();


        if (cur != null) {
            cur.moveToFirst();
            jog.setJogid(cur.getInt(cur.getColumnIndexOrThrow("jogid")));
            jog.setJognick(cur.getString(cur.getColumnIndexOrThrow("jognick")));
            jog.setJognome(cur.getString(cur.getColumnIndexOrThrow("jognome")));
        }
        db.close();

        return jog;
    }

    public Long insertJogador(Jogador jogador) {

        long res;

        ContentValues val;

        db = banco.getWritableDatabase();
        val = new ContentValues();

        val.put("jognome", jogador.getJognome());
        val.put("jogsenha", jogador.getJogsenha());
        val.put("jognick", jogador.getJognick());
        val.put("jogstatus", 1);

        res = db.insert(BancoStatitcs.TABELA_JOGADOR, null, val);
        db.close();

        return res;
    }

    public Integer updateJogador(Jogador jogador) {

        ContentValues val = new ContentValues();

        db = banco.getWritableDatabase();

        val.put("jognick", jogador.getJognick());
        val.put("jognome", jogador.getJognome());

        String where = "jogid=" + jogador.getJogid();

        int res = db.update("jogador", val, where, null);

        return res;
    }

    public Integer updateSenha(Integer id, String newPassword) {

        db = banco.getWritableDatabase();

        ContentValues val = new ContentValues();

        val.put("jogsenha", newPassword);

        int res = db.update("jogador", val, "jogid = " + id, null);

        return res;
    }

    public void deleteJogador(Integer id) {

        db = banco.getWritableDatabase();

        db.delete("jogador" , "jogid = " + id, null);

    }
}
