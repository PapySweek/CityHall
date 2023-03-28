package fr.papysweek.cityhall.managers.data;

import fr.papysweek.cityhall.CityHall;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Manage PlayerStats.json
 */
public class PlayerStatsJson {
    private final String pluginFolder = CityHall.getInstance().getDataFolder().getAbsolutePath();
    private final String fileName = "PlayerStats";

    private Player player;

    public PlayerStatsJson(Player player) {
        this.player = player;
    }

    public void writeStats(){
        JSONObject main = new JSONObject();
        JSONObject playerAll = new JSONObject();
        JSONObject statistics = new JSONObject();
        JSONObject playerKills = new JSONObject();

        playerKills.put("player_kills", player.getStatistic(Statistic.PLAYER_KILLS));
        playerKills.put("mob_kills", player.getStatistic(Statistic.MOB_KILLS));

        statistics.put("kills", playerKills);
        playerAll.put("statistics", statistics);

        playerAll.put("name", player.getName());

        main.put(player.getUniqueId(), playerAll);

        try {
            File file = new File(pluginFolder + File.separator + fileName + ".json");
            File filePath = new File(pluginFolder + File.separator);
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

    public String readStats() {
        try {
            String var;
            JSONParser parser = new JSONParser();

            File file = new File(pluginFolder + File.separator + fileName + ".json");
            Object obj = parser.parse(new FileReader(file));

            JSONObject jsonObject = (JSONObject) obj;

            var = jsonObject.get(player.getUniqueId().toString()).toString();

            JSONObject jsonObject1 = (JSONObject) parser.parse(var);

            CityHall.getInstance().getLogger().info(var);

            var = jsonObject1.get("name").toString();

            CityHall.getInstance().getLogger().info(var);

            return var;
        } catch (Exception e) {}
        return null;
    }


}
