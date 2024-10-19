package io.github.znemux.chrono;

import static io.github.znemux.chrono.IOUtils.FOLDER_PATH;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import static io.github.znemux.chrono.IOUtils.GSON;
import static io.github.znemux.chrono.IOUtils.SAVE_PATH;

public class Chronos extends ArrayList<Chrono> {
        
    public void load() throws IOException {
        if (!Files.exists(SAVE_PATH)) return;
        this.addAll(GSON.fromJson(Files.readString(SAVE_PATH), this.getClass()));
    }
    
    public void save() throws IOException {
        Files.createDirectories(FOLDER_PATH);
        Files.writeString(SAVE_PATH, GSON.toJson(this));
    }
    
    public void print() {
        for (Chrono t : this) {
            System.out.println(t);
        }
    }
    
}
