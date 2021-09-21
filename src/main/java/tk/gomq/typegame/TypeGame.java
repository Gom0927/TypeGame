package tk.gomq.typegame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import tk.gomq.typegame.Commands.GameStart;
import tk.gomq.typegame.Commands.MyStat;
import tk.gomq.typegame.Listener.PlayerChatListener;

import java.util.ArrayList;
import java.util.Objects;

public class TypeGame extends JavaPlugin {
    public static final int TITLE_TIME = 60;

    public static boolean onGame = false;
    public static long gameTime = 0;
    public static String Content = null;

    private Player[] llllllllllllll = new Player[Integer.MAX_VALUE];
    public static ArrayList<Player> List = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.broadcastMessage(ChatColor.GREEN + "[CHATGAME] ChatGame Plugin Enabled!");

        Objects.requireNonNull(getCommand("typegame")).setExecutor(new GameStart());
        Objects.requireNonNull(getCommand("mystat")).setExecutor(new MyStat());
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(), this);
    }
    @Override
    public void onDisable() {
        Bukkit.broadcastMessage(ChatColor.RED + "[CHATGAME] ChatGame Plugin Disabled.");
    }
}
