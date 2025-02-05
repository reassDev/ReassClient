package io.github.reassdev.ReassClient.features;

import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.libs.universal.UChat;
import io.github.reassdev.ReassClient.config.RCConfig;

public class DeathAlert {

    @Subscribe
    public void onChatMessage(ChatReceiveEvent event) {
        if (!RCConfig.isDeathAlertOn) {
            return;
        } else {
            if(RCConfig.deathAlertMessage != null) {
                if(event.getFullyUnformattedMessage().endsWith("and became a ghost.") && !event.getFullyUnformattedMessage().endsWith("disconnected and became a ghost.") && !event.getFullyUnformattedMessage().contains("You")) {
                    String deathPerson = event.getFullyUnformattedMessage().split(" ")[1];
                    UChat.say("/pc " + RCConfig.deathAlertMessage.replace("[player]", deathPerson));
                }
            }
        }
    }
}
