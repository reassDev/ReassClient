package io.github.reassdev.ReassClient.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.minecraft.client.Minecraft;

public class FPSHud extends SingleTextHud {
    public FPSHud() {
        super("FPS: ", true);
    }

    @Override
    public String getText(boolean enabled) {
        int fps = Minecraft.getDebugFPS();
        return Integer.toString(fps);
    }
}
