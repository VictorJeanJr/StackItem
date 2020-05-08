package victorjeanjr.stackitem.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import victorjeanjr.stackitem.objects.StackManager;

import java.util.Objects;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerPickupItemEvent(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        Item item = event.getItem();
        if(Objects.isNull(item)) return;
        if(Objects.isNull(item.getItemStack())) return;
        if(item.isCustomNameVisible() && item.hasMetadata(StackManager.getStackMeta())) {
            double metadata = item.getMetadata(StackManager.getStackMeta()).get(0).asDouble();
            event.setCancelled(true);
            if(!this.fullInventory(player)) {
                ItemStack itemStack = item.getItemStack();
                int amount = metadata > 64 ? 64 : Double.valueOf(metadata).intValue();
                itemStack.setAmount(amount);
                double result = (metadata - amount);
                player.getInventory().addItem(itemStack);
                if(result > 0) StackManager.updateItem(item, result);
                else item.remove();
                player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1.0f, 1.0f);
            }
        }
    }

    private boolean fullInventory(Player player) {
        return player.getInventory().firstEmpty() == -1;
    }

}
