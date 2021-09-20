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
                x.sendTitle(player.getDisplayName()+" Correct!", "Time: "+(new Date().getTime()-gameTime)+"ms", 1, 5, 1);
            }
            player.sendMessage(ChatColor.BLUE + "Input new TypeGame content with /typegame start command!");
            onGame=false;
        }
    }
}
