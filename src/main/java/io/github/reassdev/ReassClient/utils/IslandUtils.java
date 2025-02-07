package io.github.reassdev.ReassClient.utils;

import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class IslandUtils {

    boolean isOnHypixel = false;
    boolean isOnSkyBlock = false;

    String islandName = "Unknown";

    int dungeonFloor = 0;
    int kuudraTier = 0;

    @Subscribe
    public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent e) {
        isOnHypixel = false;
        isOnSkyBlock = false;
        islandName = "Unknown";
        dungeonFloor = 0;
        kuudraTier = 0;
    }

    @Subscribe
    public void onWorldChange(WorldEvent.Unload e) {
        isOnSkyBlock = false;
        islandName = "Unknown";
        dungeonFloor = 0;
        kuudraTier = 0;
    }

    @Subscribe
    public void onConnect(FMLNetworkEvent.ClientConnectedToServerEvent e) {
        if(!e.isLocal && Minecraft.getMinecraft().thePlayer.getClientBrand().contains(("hypixel")) && Minecraft.getMinecraft().getCurrentServerData().serverIP.contains("hypixel")) {
            isOnHypixel = true;
        }
    }

    public Scoreboard getScoreboard() {
        return Minecraft.getMinecraft().thePlayer.getWorldScoreboard();
    }

    // TODO: Make functions here using scoreboard:
    public void getIsland() {

    }

    private void isOnSkyBlockChecker() {

    }


}
