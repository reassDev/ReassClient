package io.github.reassdev.ReassClient.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.SubCommand;
import io.github.reassdev.ReassClient.ReassClient;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

@Command(value = "rc", description = "Access the " + ReassClient.NAME + " GUI.", aliases = {"reass", "reassclient"})
public class MainCommand {
    @Main
    private void handle() {
        ReassClient.config.openGui();
    }
    @SubCommand(description = "Activate Developer Mode", aliases = "developer")
    private void dev() {
        ReassClient.sendModMessage("§bDeveloper Mode Toggled");
    }
}