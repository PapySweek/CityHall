package fr.papysweek.cityhall.managers;

import fr.papysweek.cityhall.CityHall;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Logger;

public class MCFile {

    public static ArrayList<MCFile> defaultFiles = new ArrayList<>();
    public static MCFile BASE_CONFIG = registerDefault(new MCFile("config.yml"));

    private static MCFile registerDefault(MCFile file) {
        defaultFiles.add(file);
        return file;
    }

    private final String fileName;
    private final File dataFolder;

    private MCFile(String fileName) {
        this.fileName = fileName;
        this.dataFolder = CityHall.getInstance().getDataFolder();
    }

    private MCFile(String fileName, String path) {
        this.fileName = fileName;
        this.dataFolder = new File(CityHall.getInstance().getDataFolder().getPath() + File.separator + path);
    }

    private MCFile(String fileName, String path, Boolean pluginsFolder) {

        this.fileName = fileName;

        if (pluginsFolder)
            this.dataFolder = new File(CityHall.getInstance().getDataFolder().getParent() + File.separator + path);
        else
            this.dataFolder = new File(CityHall.getInstance().getDataFolder().getPath() + File.separator + path);
    }

    public File getFile() {
        return new File(dataFolder, fileName);
    }

    public String getFileName() {
        return fileName;
    }

    // YAML --------------------
    public Boolean isYamlConfiguration() {
        return fileName.toLowerCase().endsWith(".yml");
    }

    public YamlConfiguration getYamlConfig() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public void save(FileConfiguration config) {
        try {
            config.save(getFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(Logger logger) {
        if (fileName == null || fileName.isEmpty())
            throw new IllegalArgumentException("Ressource name cannot be null or empty");

        InputStream in = CityHall.getInstance().getResource(getFileName());

        if (in == null)
            throw new IllegalArgumentException("The ressource " + getFileName() + " cannot be found in plugin.jar");

        if (!dataFolder.exists() && !dataFolder.mkdir()) {
            logger.severe("Failed to make directory");
            return;
        }

        File outFile = getFile();

        try {
            if (!outFile.exists()) {
                logger.info("The file " + getFileName() + " was not found, creation in progress...");

                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int n;

                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }

                out.close();
                in.close();

                if (!outFile.exists())
                    logger.severe("Unable to copy file");
                else
                    logger.info("The file " + getFileName() + " has been created.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}