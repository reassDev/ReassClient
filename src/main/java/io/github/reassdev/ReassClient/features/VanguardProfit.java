package io.github.reassdev.ReassClient.features;

import cc.polyfrost.oneconfig.events.event.ChatReceiveEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.libs.universal.UChat;
import io.github.reassdev.ReassClient.ReassClient;
import io.github.reassdev.ReassClient.config.RCConfig;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class VanguardProfit {

    @Subscribe
    public void onChatMessage(ChatReceiveEvent event) {
        if (!RCConfig.isVanguardProfitOn) {
            return;
        } else {
            if (!RCConfig.vanguardProfitWebhook.contains("discord.com/api/webhooks/")) {
                ReassClient.sendModMessage("§cInvalid webhook URL! Please set a valid webhook URL in the config.");
            } else {
                if(event.getFullyUnformattedMessage().startsWith("[SkyHanni] Profit for Vanguard Corpse:")) {
                try {
                    URL url = new URL(RCConfig.vanguardProfitWebhook);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);
                    String[] profit = event.getFullyUnformattedMessage().split(":");
                    String jsonPayload = "{\"content\": \"" + "Vanguard Opened. Profit:" + profit[1] + "\"}";

                    try (OutputStream os = connection.getOutputStream()) {
                        byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int responseCode = connection.getResponseCode();
                    System.out.println("Response Code: " + responseCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            }
        }


    }

}
