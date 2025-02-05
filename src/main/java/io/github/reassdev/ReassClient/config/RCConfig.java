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

    @Switch(
            name = "Party Commands",
            category = "Party Commands"
    )
    public static boolean isPartyCommandsOn = false;

    @Switch(
            name = "!warp",
            category = "Party Commands"
    )
    public static boolean isWarpOn = false;

    @Switch(
            name = "!coords",
            category = "Party Commands"
    )
    public static boolean isCoordsOn = false;

    @Switch(
            name = "!allinvite",
            category = "Party Commands"
    )
    public static boolean isAllInviteOn = false;

    @Switch(
            name = "!pt",
            category = "Party Commands"
    )
    public static boolean isPtOn = false;

    public RCConfig() {
        super(new Mod(ReassClient.NAME, ModType.SKYBLOCK), ReassClient.MODID + ".json");
        initialize();
    }
}