package io.github.reassdev.ReassClient.features;

import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.libs.universal.UChat;
import io.github.reassdev.ReassClient.ReassClient;
import io.github.reassdev.ReassClient.config.RCConfig;

public class PartyCommands {

    @Subscribe
    public void onChatMessage(ChatReceiveEvent event) {
        if (!RCConfig.isPartyCommandsOn) {
            return;
        } else {
            if(event.getFullyUnformattedMessage().startsWith("Party >")) {
                int offset = 0;
                String[] message = event.getFullyUnformattedMessage().split(" ");
                if(!message[2].startsWith("[")) {
                    offset = 1;
                }
                if(RCConfig.isWarpOn && message[4 - offset].equalsIgnoreCase("!warp")) {
                    UChat.say("/p warp");
                } else if(RCConfig.isCoordsOn && message[4 - offset].equalsIgnoreCase("!coords")) {
                    UChat.say("/pc " + ReassClient.getCoordsString());
                } else if(RCConfig.isAllInviteOn && message[4 - offset].equalsIgnoreCase("!allinvite")) {
                    UChat.say("/p settings allinvite");
                } else if(RCConfig.isPartyCommandsOn && message[4 - offset].equalsIgnoreCase("!pt")) {
                    UChat.say("/p transfer" + message[3 - offset].replace(":", ""));
                }
            }
        }
    }
}
