package me.zdodatv.speedrunwithfriends;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedrunWithFriendsCommandExecutor implements CommandExecutor {
    private static boolean speedrunStart = false;
    private static boolean secondPlayerJoin = false;
    private final SpeedrunWithFriends plugin;
    public SpeedrunWithFriendsCommandExecutor(SpeedrunWithFriends plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("speedrun")){
            speedrunStart = true;
            Player player = (Player) sender;
            SpeedrunWithFriends screen = new SpeedrunWithFriends();
            screen.startScreen(player);
            return true;
        } else if(cmd.getName().equalsIgnoreCase("speedrun")&& args[0].equalsIgnoreCase("start")){
            if(Bukkit.getOnlinePlayers().size() == 2){
                //Starts the speedrun
            } else{
                //tells player that the other speedrun needs to join
            }
        }

        return false;
    }

    public static boolean isSpeedrunStart() {
        return speedrunStart;
    }

    public static boolean isSecondPlayerJoin() {
        return secondPlayerJoin;
    }

    public static void setSecondPlayerJoin(boolean secondPlayerJoin) {
        SpeedrunWithFriendsCommandExecutor.secondPlayerJoin = secondPlayerJoin;
    }
}
