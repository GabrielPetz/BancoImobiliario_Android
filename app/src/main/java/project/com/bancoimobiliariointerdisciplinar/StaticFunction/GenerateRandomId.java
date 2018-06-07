package project.com.bancoimobiliariointerdisciplinar.StaticFunction;

import java.util.Random;

/**
 * Created by User on 25/04/2018.
 */

public class GenerateRandomId {

    public static Integer generateId(){
        Integer id = 0;
        Random randomizer = new Random();
        randomizer.setSeed(00000000);
        id = randomizer.nextInt();
        return id;
    }
}
