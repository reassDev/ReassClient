package io.github.reassdev.ReassClient.config;

import cc.polyfrost.oneconfig.config.annotations.Text;
import io.github.reassdev.ReassClient.ReassClient;
import io.github.reassdev.ReassClient.hud.FPSHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.HUD;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class RCConfig extends Config {

    public static boolean isFirstLoad = true;

    @HUD(
            name = "FPS Display",
            category = "HUD"
    )
    public FPSHud fpsHud = new FPSHud();

    @Switch(
            name = "Send Vanguard Profit Logs to Webhook",
            category = "Mining"
    )
    public static boolean isVanguardProfitOn = false;

    @Text(
            name = "Webhook to send to",
            category = "Mining"
    )
    public static String vanguardProfitWebhook = "Link Here";

    public RCConfig() {
        super(new Mod(ReassClient.NAME, ModType.SKYBLOCK), ReassClient.MODID + ".json");
        initialize();
    }
}