package io.github.znemux.util;

import com.google.gson.Gson;
import static java.lang.System.getProperty;
import java.nio.file.Path;
import java.util.Scanner;

public class IOUtils {
    public static final Scanner INPUT = new Scanner(System.in);
    public static final Gson GSON = new Gson();
    public static final Path FOLDER_PATH = getFolderPath();
    public static final Path SAVE_PATH = FOLDER_PATH.resolve("Save.json");
    public static final Path TEMP_PATH = FOLDER_PATH.resolve(".temp.json");
    public static final String APP_NAME = "Chrono";
    public static final String DEV_NAME = "Nemux";
    
    private static Path getFolderPath() {
        boolean isWindows = getProperty("os.name").startsWith("Win");
        Path path = Path.of(getProperty("user.home"));
        path = path.resolve(isWindows ? "AppData\\Local" : ".local/share").resolve(DEV_NAME, APP_NAME);
        return path;
    }
    
}
