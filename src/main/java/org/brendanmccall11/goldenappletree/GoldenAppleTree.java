package org.brendanmccall11.goldenappletree;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class GoldenAppleTree extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Do nothing
    }
}
