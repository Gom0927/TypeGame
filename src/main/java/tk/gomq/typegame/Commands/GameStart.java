package tk.gomq.typegame.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Date;

import static tk.gomq.typegame.TypeGame.*;

public class GameStart implements CommandExecutor, TabCompleter {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command need to executed by human.");
            return false;
        }

        if(args.length >= 1) {
            String command = args[0];
            String content = args[1];

            if (!command.equalsIgnoreCase("start")) {
                sender.sendMessage(ChatColor.RED + "Usage: /typegame start (content)");
                return false;
            } else {
//                if(Players.length < 2) {
//                    ((Player)sender).sendMessage("There must be at least 3 users to play the game!");
//                    return false;
//                }
                if (!List.contains((Player)sender)) {
                    sender.sendMessage(ChatColor.RED + "You are not in the players group");
                    return false;
                }

                onGame = true;
                Content = content;

                for(Player x : List) {

                    x.sendTitle(
                            ChatColor.AQUA + content,
                            ChatColor.GOLD +"Executor: "+((Player) sender).getDisplayName(),
                            1, TITLE_TIME, 1);
                }
                gameTime = new Date().getTime();
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /typegame start (content)");
        }

        return false;
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
