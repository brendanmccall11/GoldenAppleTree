package org.brendanmccall11.goldenappletree;

import org.bukkit.plugin.java.JavaPlugin;

public class GoldenAppleTree extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Plugin(), this);
    }

    @Override
    public void onDisable() {
        // Do nothing
    }
}
