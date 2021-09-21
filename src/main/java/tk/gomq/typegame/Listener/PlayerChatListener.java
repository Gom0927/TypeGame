package tk.gomq.typegame.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static tk.gomq.typegame.TypeGame.*;

public class PlayerChatListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void playerChatListener (AsyncPlayerChatEvent event) {
        if (!onGame) return;
        Player player = event.getPlayer();

        if (!List.contains(player)) return;

        String msg = event.getMessage();
        if (msg.equals(Content)) {
            for(Player x : List) {
                x.resetTitle();
                x.sendTitle(
                        ChatColor.GREEN+player.getDisplayName()+" Correct!",
                        ChatColor.BLUE+"Time: "+ChatColor.YELLOW+(((new Date().getTime()-gameTime))/1000)+"s",
                        1, 50, 1);
            }
            player.sendMessage(ChatColor.BLUE + "Input new TypeGame content with /typegame start command!");
            onGame=false;
        } else {
            player.sendMessage(ChatColor.RED + "Wrorg!");
        }
    }
}
