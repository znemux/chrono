package io.github.znemux.chrono;

import static io.github.znemux.chrono.IOUtils.FOLDER_PATH;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.SECONDS;
import static io.github.znemux.chrono.IOUtils.GSON;
import static io.github.znemux.chrono.IOUtils.TEMP_PATH;

public class Chrono {

    String name;
    Long start, stop;

    public void start() {
        start = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    public void stop() {
        stop = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    public void load() throws IOException {
        if (!Files.exists(TEMP_PATH)) return;
        Chrono temp = GSON.fromJson(Files.readString(TEMP_PATH), this.getClass());
        this.name = temp.name;
        this.start = temp.start;
    }

    public void save() throws IOException {
        Files.createDirectories(FOLDER_PATH);
        Files.writeString(TEMP_PATH, GSON.toJson(this));
    }

    public void clean() throws IOException {
        Files.delete(TEMP_PATH);
    }
    
    public boolean existsSave() {
        return Files.exists(TEMP_PATH);
    }
    
    public void setName(String name) {
        this.name = name.trim();
    }
    
    public String getFormattedStart() {
        if (start == null) return null;
        LocalDateTime dt = LocalDateTime.ofEpochSecond(start, 0, ZoneOffset.UTC);
        return dt.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + dt.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public String getFormattedStop() {
        if (start == null) return null;
        LocalDateTime dt = LocalDateTime.ofEpochSecond(stop, 0, ZoneOffset.UTC);
        return dt.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + dt.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public String getFormattedDuration() {
        if (start == null || stop == null) return null;
        Duration duration = Duration.of(stop - start, SECONDS);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": began at " + getFormattedStart()+ ", ended at " + getFormattedStop() + ". Lasted " + getFormattedDuration() + ".";
    }

}
