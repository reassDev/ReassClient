package io.github.reassdev.ReassClient;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.libs.universal.UChat;
import io.github.reassdev.ReassClient.command.MainCommand;
import io.github.reassdev.ReassClient.config.RCConfig;
import io.github.reassdev.ReassClient.features.DeathAlert;
import io.github.reassdev.ReassClient.features.PartyCommands;
import io.github.reassdev.ReassClient.features.VanguardProfit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ReassClient.MODID, name = ReassClient.NAME, version = ReassClient.VERSION)
public class ReassClient {

    public static final String MODID = "reassclient";
    public static final String NAME = "ReassClient";
    public static final String VERSION = "1.0.2-beta2";
    @Mod.Instance(MODID)
    public static ReassClient INSTANCE;
    public static RCConfig config;

    public static String getPrefix() {
        return "§6Reass§eClient §8» ";
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new RCConfig();
        CommandManager.INSTANCE.registerCommand(new MainCommand());
        EventManager.INSTANCE.register(VanguardProfit.class);
        EventManager.INSTANCE.register(PartyCommands.class);
        EventManager.INSTANCE.register(DeathAlert.class);
        EventManager.INSTANCE.register(this);
    }

    public static void sendModMessage(String message) {
        UChat.chat(ReassClient.getPrefix() + message);
    }

    @Subscribe
    public void onWorldLoad(WorldLoadEvent event) {
        if(RCConfig.isFirstLoad) {
            UChat.chat("§bThank you for downloading " + "§6Reass§eClient" + " §6v" + VERSION);
            UChat.chat("§bType §e/rc §bto open the GUI");
            RCConfig.isFirstLoad = false;
        }
    }

    public static String getCoordsString() {
        return "X: " + Math.round(Minecraft.getMinecraft().thePlayer.posX) + " Y: " + Math.round(Minecraft.getMinecraft().thePlayer.posY) + " Z: " + Math.round(Minecraft.getMinecraft().thePlayer.posZ);
    }
}
