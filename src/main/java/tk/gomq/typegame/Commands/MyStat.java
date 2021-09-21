package tk.gomq.typegame.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static tk.gomq.typegame.TypeGame.List;
import static tk.gomq.typegame.TypeGame.onGame;

public class MyStat implements CommandExecutor, TabCompleter {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command need to executed by Human!");
            return false;
        }

        if(args.length==1) {
            String w_h_a_t = args[0];
            if(w_h_a_t.equalsIgnoreCase("add")
                    || w_h_a_t.equalsIgnoreCase("remove")
                    || w_h_a_t.equalsIgnoreCase("list")) {
                if(onGame) {
                    sender.sendMessage(ChatColor.RED + "The game is currently in progress. Please try again later.");
                    return false;
                }

                if(w_h_a_t.equalsIgnoreCase("add")) {
                    List.add((Player)sender);
                    sender.sendMessage(ChatColor.GREEN + "Successfully added you to Player List!");
                } else if (w_h_a_t.equalsIgnoreCase("list")) {
                    ((Player)sender).sendMessage(ChatColor.GREEN + "List of TypeGame Players");
                    for(Player i : List) {
                        ((Player)sender).sendMessage(i.getDisplayName());
                    }
                }
                else {
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

    @Override
    public java.util.List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        if(args.length == 1) {
            list.add("start");
        } else if(args.length == 2) {
            list.add("<[content]>");
        }

        return list;
    }
}
