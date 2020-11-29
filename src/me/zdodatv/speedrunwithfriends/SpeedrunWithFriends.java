package me.zdodatv.speedrunwithfriends;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class SpeedrunWithFriends extends JavaPlugin {
    //When server loads
    @Override
    public void onLoad(){
        getLogger().info("Plugin has loaded!");
    }
    //When world loads
    @Override
    public void onEnable(){
        getLogger().info("Plugin has enabled!");
    }

    @Override
    public void onDisable(){
        this.getCommand("speedrun").setExecutor(new SpeedrunWithFriendsCommandExecutor(this));
    }

    @EventHandler
    public void onPlayerConnect(AsyncPlayerPreLoginEvent evt) {
        if(SpeedrunWithFriendsCommandExecutor.isSpeedrunStart() && Bukkit.getOnlinePlayers().size() > 1){
            evt.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, "Speedrun in progress");
        } else if (SpeedrunWithFriendsCommandExecutor.isSpeedrunStart()){
            SpeedrunWithFriendsCommandExecutor.setSecondPlayerJoin(true);
            evt.allow();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(SpeedrunWithFriendsCommandExecutor.isSecondPlayerJoin()){
            Player player = e.getPlayer();
        }
    }

    public void startScreen(Player player){
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999999999, 999999999));
        //loop to wait for other player
    }
}
