package victorjeanjr.stackitem.objects;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import victorjeanjr.stackitem.Core;
import victorjeanjr.stackitem.api.Config;

public class StackManager {

    private static final String STACK_META = "stackItem";
    private static Config config = new Config("config.yml");

    public static void updateItem(Item item, double amount) {
        if(item.hasMetadata(STACK_META)) item.removeMetadata(STACK_META, Core.getPlugin());
        item.setMetadata(STACK_META, new FixedMetadataValue(Core.getPlugin(), amount));
        item.getItemStack().setAmount(1);
        item.setCustomName(config.getString("Item.hologram")
                .replace("{amount}", DoubleFormat.format(amount))
                .replace("{nameItem}", StackManager.getFriendlyName(item.getItemStack())));
        if(!item.isCustomNameVisible()) item.setCustomNameVisible(true);
    }

    private static String getFriendlyName(ItemStack itemStack) {
       if(itemStack.hasItemMeta() && itemStack.getItemMeta().getDisplayName() != null)
           return itemStack.getItemMeta().getDisplayName();
       else return format(itemStack.getType().name());
    }

    private static String format(String s) {
        if (!s.contains("_")) {
            return capitalize(s);
        }
        String[] j = s.split("_");

        StringBuilder c = new StringBuilder();

        for (String f : j) {
            f = capitalize(f);
            c.append(c.toString().equalsIgnoreCase("") ? f : " " + f);
        }
        return c.toString();
    }

    private static String capitalize(String text) {
        String firstLetter = text.substring(0, 1).toUpperCase();
        String next = text.substring(1).toLowerCase();

        return (firstLetter + next);
    }

    public static String getStackMeta() {
        return STACK_META;
    }
}
