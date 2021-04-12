package dev.barbar.sleepsleep;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerMoveEvent;


public class onSleep implements Listener {
    int sleep =0;
    int online=0;
    @EventHandler
    public void onSleep(PlayerMoveEvent event) {
        Player p = event.getPlayer();

        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            online++;
            if(p.isSneaking()){
                sleep++;
                Bukkit.broadcastMessage(p.getDisplayName()+" is sleeping: sleep: "+sleep+" Online: "+online);
                if((sleep/online)*100>50){
                    Bukkit.broadcastMessage("Works");
                    sleep=0;
                    online=0;
                    p.getWorld().setTime(200);
                }else{
                    Bukkit.broadcastMessage("WEEEEE");
                    sleep=0;
                    online=0;
                }
                // do something
            }
        }


    }
}