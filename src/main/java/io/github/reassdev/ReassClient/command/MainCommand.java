package io.github.reassdev.ReassClient.command;

import cc.polyfrost.oneconfig.libs.universal.UChat;
import cc.polyfrost.oneconfig.utils.commands.annotations.SubCommand;
import io.github.reassdev.ReassClient.ReassClient;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import net.minecraft.client.Minecraft;

@Command(value = "rc", description = "Access the " + ReassClient.NAME + " GUI.", aliases = {"reass", "reassclient"})
public class MainCommand {
    @Main
    private void handle() {
        ReassClient.config.openGui();
    }
    @SubCommand(description = "Activate Developer Mode", aliases = "developer") // Doesn't do anything rn
    private void dev() {
        ReassClient.sendModMessage("§bDeveloper Mode Toggled");
    }
    @SubCommand(description="Send your coordinates in chat", aliases = "coords")
    private void sendcoords() {
        UChat.say(ReassClient.getCoordsString());
    }
    @SubCommand(description="Shows your fps")
    private void fps() {
        String fps;
        if(Minecraft.getDebugFPS() > 144) {
            fps = "§a" + Minecraft.getDebugFPS();
        } else if(Minecraft.getDebugFPS() > 100) {
            fps = "§e" + Minecraft.getDebugFPS();
        } else if(Minecraft.getDebugFPS() > 60) {
            fps = "§c" + Minecraft.getDebugFPS();
        } else {
            fps = "§4" + Minecraft.getDebugFPS();
        }
        ReassClient.sendModMessage("§bFPS: " + fps);
    }

    @SubCommand(description="Shows the version of the mod")
    private void version() {
        ReassClient.sendModMessage("§b" + ReassClient.NAME + " §6v" + ReassClient.VERSION);
    }

    @SubCommand(description="Opens the backpack of the specified number")
    private void bp(int number) {
        UChat.say("/backpack " + number);
    }

    @SubCommand(description="Opens the Ender Chest page of the specified number")
    private void ec(int number) {
        UChat.say("/enderchest " + number);
    }

    @SubCommand(description="Opens the wardrobe")
    private void wd() {
        UChat.say("/wardrobe");
    }

    @SubCommand(description="Shows the help message")
    private void help() {
        // Figure out how to override the help message
    }
}