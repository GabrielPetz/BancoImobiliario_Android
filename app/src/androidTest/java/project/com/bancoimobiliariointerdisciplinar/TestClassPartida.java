package project.com.bancoimobiliariointerdisciplinar;

import android.content.ContentValues;
import android.content.Context;
import android.provider.Telephony;
import android.support.test.InstrumentationRegistry;

import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import project.com.bancoimobiliariointerdisciplinar.Factory.DatabaseFactory;
import project.com.bancoimobiliariointerdisciplinar.JDBC.PartidaJDBC;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Partida;

public class TestClassPartida {


    private static Context appContext = InstrumentationRegistry.getTargetContext();

    private static PartidaJDBC partidaJDBC = new PartidaJDBC(appContext);
    @Ignore
    @Test
    public void test_insertpartida() {
        Partida partida = new Partida();
        Date dt = new Date();
        partida.setParnome("Partida teste");
        partida.setPardata(dt);
        partidaJDBC.insertPartida(partida);
    }
    @Ignore
    @Test
    public void test_getpartidaid(){
        partidaJDBC.getPartida(1);
    }
    @Ignore
    @Test
    public void test_getpartidanome(){
        partidaJDBC.getPartida("Partida teste");
    }
    @Ignore
    @Test
    public void test_alterpartida(){

        Partida partida = new Partida();
        Date dt = new Date();
        partida.setParnome("Partidao do caralho");
        partida.setPardata(dt);

        partidaJDBC.updatePartida(partida);
    }
    @Ignore
    @Test
    public void test_closepartida(){
        partidaJDBC.closePartida(1);
    }
    @Ignore
    @Test
    public void test_deletepartida(){
        partidaJDBC.deletePartida(1);
    }
}
