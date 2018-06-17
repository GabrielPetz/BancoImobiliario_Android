package project.com.bancoimobiliariointerdisciplinar.Factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import project.com.bancoimobiliariointerdisciplinar.Util.BancoStatitcs;

public class DatabaseFactory extends SQLiteOpenHelper {

    public DatabaseFactory(Context context) {
        super(context, BancoStatitcs.NOME_BANCO, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table jogador (" +
                "jogid numeric(10) not null primary key autoincrement," +
                "jognome varchar(255) not null," +
                "jogsenha varchar(255) not null, " +
                "jognick varchar(255)" +
                ")";
        db.execSQL(sql);

        sql = "create table partida (" +
                "parid numeric(10) not null primary key," +
                "parnome varchar(100)," +
                "pardata timestamp," +
                "parstatus numeric(5)" +
                ")";
        db.execSQL(sql);


        sql = "create table pino (" +
                "pinid numeric(10) not null primary key autoincrement," +
                "pindesc varchar(50) " +
                ")";
        db.execSQL(sql);

        sql = "create table operacao (" +
                "opeid numeric(10) not null primary key autoincrement," +
                "opedesc varchar(100)" +
                ")";
        db.execSQL(sql);

        sql = "create table itemlote(" +
                "itlid numeric(10) not null primary key," +
                "itldesc varchar(255)" +
                ")";

        db.execSQL(sql);


        sql = "create table jogadorpartida(" +
                "jopid numeric(10) not null primary key autoincrement," +
                "joppartida numeric(10) not null ," +
                "jopjogador numeric(10) not null," +
                "jopsaldo numeric(10,2)," +
                "joppino varchar(50)," +
                "foreign key (joppartida) references partida (parid)," +
                "foreign key (jopjogador) references jogador (jogid)," +
                "foreign key (joppino) references pino (pinid))";
        db.execSQL(sql);


        sql = "create table propriedade(" +
                "proid numeric(10) not null primary key autoincrement," +
                "prolote varchar(200), " +
                "pronumerocasa numeric(5)," +
                "protipolote varchar(140)," +
                "provalorcompra numeric(8,2)," +
                "provaloraluguel1 numeric(8,2)," +
                "provaloraluguel2 numeric(8,2)," +
                "provaloraluguel3 numeric(8,2)," +
                "provaloraluguel4 numeric(8,2)," +
                "provalorhipoteca numeric(8,2)," +
                "provaloraluguelhotel numeric(8,2)" +
                ")";
        db.execSQL(sql);

        sql = "create table propriedadejogadorpartida(" +
                "pjpjogadorpartida numeric(10)," +
                "pjppropriedade numeric(10)," +
                "foreign key (pjpjogadorpartida) references jogadorpartida (jopid)," +
                "foreign key (pjppropriedade) references propriedade (proid)" +
                ")";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists jogadorpartida");
        db.execSQL("drop table if exists propriedadejogadorpartida");
        db.execSQL("drop table if exists jogador");
        db.execSQL("drop table if exists partida");
        db.execSQL("drop table if exists propriedade");
        db.execSQL("drop table if exists pino");
        db.execSQL("drop table if exists operacao");
        db.execSQL("drop table if exists itemlote");

        onCreate(db);
    }
}
