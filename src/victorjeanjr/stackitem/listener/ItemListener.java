package victorjeanjr.stackitem.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import victorjeanjr.stackitem.objects.StackManager;

import java.util.Objects;

public class ItemListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onItemMerge(ItemMergeEvent e) {
        if (e.isCancelled()) return;

        Item originalItem = e.getEntity(), targetItem = e.getTarget();

        double targetAmount = targetItem.hasMetadata(StackManager.getStackMeta())
                ? targetItem.getMetadata(StackManager.getStackMeta()).get(0).asDouble() : targetItem.getItemStack().getAmount();
        double originalAmount = originalItem.hasMetadata(StackManager.getStackMeta())
                ? originalItem.getMetadata(StackManager.getStackMeta()).get(0).asDouble() : originalItem.getItemStack().getAmount();
        StackManager.updateItem(targetItem, targetAmount + originalAmount);
        targetItem.setTicksLived(2);
        originalItem.remove();
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onDropPlayer(PlayerDropItemEvent e) {
        if (e.isCancelled()) return;

        Item targetItem = e.getItemDrop();
        Item originalItem = this.getItem(3, targetItem);

        double targetAmount = targetItem.hasMetadata(StackManager.getStackMeta())
                ? targetItem.getMetadata(StackManager.getStackMeta()).get(0).asDouble() : targetItem.getItemStack().getAmount();

        if(Objects.isNull(originalItem)) {
            StackManager.updateItem(targetItem, targetAmount);
            targetItem.setTicksLived(2);
            return;
        }

        double originalAmount = originalItem.hasMetadata(StackManager.getStackMeta())
                ? originalItem.getMetadata(StackManager.getStackMeta()).get(0).asDouble() : originalItem.getItemStack().getAmount();
        StackManager.updateItem(targetItem, targetAmount + originalAmount);
        targetItem.setTicksLived(2);
        originalItem.remove();
    }

    private Item getItem(double r, Item item) {
        if(!item.getLocation().getWorld().getNearbyEntities(item.getLocation(), r, r, r).isEmpty()) {
            for(Entity entity : item.getLocation().getWorld().getNearbyEntities(item.getLocation(), r, r, r)) {
                if(entity instanceof Item) {
                    Item i = (Item)entity;
                    if(i.getItemStack().equals(item.getItemStack())) return (Item) entity;
                }
            }
        }
        return null;
    }

}
