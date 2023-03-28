package fr.papysweek.cityhall.managers.data;

import fr.papysweek.cityhall.CityHall;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JSONStorage {
    private static String pluginFolder = CityHall.getInstance().getDataFolder().getAbsolutePath();

    public static void writeJSON(String fileName, String subPath, String object, String value) {
        JSONObject main = new JSONObject();

        main.put(object, value);

        try {
            File file = new File(pluginFolder + File.separator + subPath + fileName + ".json");
            File filePath = new File(pluginFolder + File.separator + subPath);
            filePath.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(main.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {}
    }

    public static String readJSON(String fileName, String subPath, String object) {
        String var = null;
        try {
            JSONParser parser = new JSONParser();

            File file = new File(pluginFolder + File.separator + subPath + fileName + ".json");
            Object obj = parser.parse(new FileReader(file));

            JSONObject jsonObject = (JSONObject) obj;

            var = (String) jsonObject.get(object);

        } catch (Exception e) {}
        return var;
    }
}
