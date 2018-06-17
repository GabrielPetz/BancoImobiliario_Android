package project.com.bancoimobiliariointerdisciplinar.JDBC;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteException;

import project.com.bancoimobiliariointerdisciplinar.Factory.DatabaseFactory;
import project.com.bancoimobiliariointerdisciplinar.Interface.IJogador;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Jogador;
import project.com.bancoimobiliariointerdisciplinar.Util.BancoStatitcs;

public class JogadorJDBC implements IJogador {


    private SQLiteDatabase db;
    private DatabaseFactory banco;

    public JogadorJDBC(Context context) {
        banco = new DatabaseFactory(context);
    }



    @Override
    public Jogador getJogador(Integer id) {

        Cursor cur;

        String[] campos = {"jogid", "jognome", "jognick"};
        db = banco.getReadableDatabase();

        String where = "jognome=" + id + " ";

        cur = db.query(BancoStatitcs.TABELA_JOGADOR, campos, where, null, null, null, null);


        Jogador jog = new Jogador();


        if (cur != null) {
            cur.moveToFirst();
            jog.setJogid(cur.getInt(cur.getColumnIndexOrThrow("jogid")));
            jog.setJognick(cur.getString(cur.getColumnIndexOrThrow("jognick")));
            jog.setJognome(cur.getString(cur.getColumnIndexOrThrow("jognome")));
        }
        db.close();

        return jog;

    }

    @Override
    public Jogador getJogador(String nome) {
        Cursor cur;

        String[] campos = {"jogid", "jognome", "jognick"};
        db = banco.getReadableDatabase();

        String where = "jognome like '" + nome + "'";

        cur = db.query(BancoStatitcs.TABELA_JOGADOR, campos, where, null, null, null, null);


        Jogador jog = new Jogador();


        if (cur != null) {
            cur.moveToFirst();
            jog.setJogid(cur.getInt(cur.getColumnIndexOrThrow("jogid")));
            jog.setJognick(cur.getString(cur.getColumnIndexOrThrow("jognick")));
            jog.setJognome(cur.getString(cur.getColumnIndexOrThrow("jognome")));
        }
        db.close();

        return jog;
    }

    @Override
    public Long insertJogador(Jogador jogador) {

        Integer id;

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

    @Override
    public Integer updateJogador(Jogador jogador) {

        ContentValues val = new ContentValues();

        db = banco.getWritableDatabase();

        val.put("jognick", jogador.getJognick());
        val.put("jognome", jogador.getJognome());

        String where  = "jogid=" + jogador.getJogid();

        int res = db.update("jogador", val, where, null);



        db.execSQL("update public.jogador  set jognome='" + jogador.getJognome() + "' " +
                "set jognick='" + jogador.getJognick() + "' " +
                "where jogid=" + jogador.getJogid());

        return res;
    }


    @Override
    public Integer updateSenha(Integer id, String newPassword){

        db = banco.getWritableDatabase();

        ContentValues val = new ContentValues();

        val.put("jogsenha", newPassword);

        int res = db.update("jogador", val, "jogid = "+id, null);

        return res;
    }


    @Override
    public void deleteJogador(Integer id){

        db = banco.getReadableDatabase();

        db.execSQL("delete from jogador where jogid = " + id);

    }
}
