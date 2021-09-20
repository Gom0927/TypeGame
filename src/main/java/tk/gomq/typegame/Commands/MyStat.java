package tk.gomq.typegame.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static tk.gomq.typegame.TypeGame.List;
import static tk.gomq.typegame.TypeGame.onGame;

public class MyStat implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command need to executed by Human!");
            return false;
        }

        if(args.length==1) {
            String w_h_a_t = args[0];
            if(w_h_a_t.equalsIgnoreCase("add") || w_h_a_t.equalsIgnoreCase("remove")) {
                if(onGame) {
                    sender.sendMessage(ChatColor.RED + "The game is currently in progress. Please try again later.");
                    return false;
                }

                if(w_h_a_t.equalsIgnoreCase("add")) {
                    List.add((Player)sender);
                    sender.sendMessage(ChatColor.GREEN + "Successfully added you to Player List!");
                } else {
                    List.remove((Player)sender);
                    sender.sendMessage(ChatColor.GREEN + "Successfully removed you from Player List!");
                }

                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /mystat [add/remove]");
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /mystat [add/remove]");
            return false;
        }
    }
}
