package org.brendanmccall11.goldenappletree;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Objects;
import java.util.Random;

public class Plugin extends GoldenAppleTree{
    @EventHandler
    public void onLeafBlockBreak(BlockBreakEvent event) {
        blockBreak(event.getBlock(), event.getPlayer());
    }

    @EventHandler
    public void onLeafBlockExplosion(EntityExplodeEvent event) {
        for (Block b : event.blockList()) {
            blockBreak(b, null);
        }
    }

    @EventHandler
    public void onLeafBlockDecay(LeavesDecayEvent event) {
        blockBreak(event.getBlock(), null);
    }

    private boolean isHoldingShears(Player p) {
        return p.getInventory().getItemInMainHand().getType().equals(Material.SHEARS); // Tests if the player is holding shears in their main hand
    }

    private boolean isLeaf(Material m) {
        return m.toString().contains("LEAVES"); // Tests if the material given has "LEAVES" in its name
    }

    private void blockBreak(Block block, Player player) {

        if (!isHoldingShears(player) && isLeaf(block.getType())) { // If the player is not holding shears and the block is a leaf run this code

            Random chance = new Random();
            int number = chance.nextInt(1000);
            if (number < 10) {
                Objects.requireNonNull(block.getLocation().getWorld()).dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLDEN_APPLE, 1)); // 1 in 100 chance to drop a golden apple
            } else if (number == 10) {
                Objects.requireNonNull(block.getLocation().getWorld()).dropItemNaturally(block.getLocation(), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1)); // 1 in 1000 chance to drop an enchanted golden apple
            }
        }
    }
}
