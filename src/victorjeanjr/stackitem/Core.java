package victorjeanjr.stackitem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import victorjeanjr.stackitem.listener.ItemListener;
import victorjeanjr.stackitem.listener.PlayerListener;

import java.io.File;

public class Core extends JavaPlugin {

    private static Plugin plugin;
    private static Core core;

    @Override
    public void onLoad() {
        File file = new File("plugins/" + this.getDataFolder().getName());
        if(!file.exists()) file.mkdirs();
    }

    @Override
    public void onEnable() {
        plugin = this;
        core = this;

        this.saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemListener(), this);

        Bukkit.getConsoleSender().sendMessage("StackItem | Created by VictorJeanJr -> Enabled with success.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("StackItem | Created by VictorJeanJr -> Disabled with success.");
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static Core getCore() {
        return core;
    }

}
