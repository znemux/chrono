package io.github.znemux.chrono;

import java.io.IOException;

public class Main {
    
    public static final Chronos CHRONOS = new Chronos();
    public static final Chrono CHRONO = new Chrono();
    
    public static void main(String[] args) throws IOException {
        CHRONOS.load();
        CHRONO.load();
        GUI.main();
    }
    
    public static void start(String name) throws IOException {
        CHRONO.name = name;
        CHRONO.start();
        CHRONO.save();
    }
    
    public static void stop() throws IOException {
        CHRONO.stop();
        CHRONOS.add(CHRONO);
        CHRONOS.save();
        CHRONO.clean();
    }
    
}
