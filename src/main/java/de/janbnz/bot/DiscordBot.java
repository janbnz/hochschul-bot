package de.janbnz.bot;

import de.janbnz.bot.listener.BotEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;

public class DiscordBot {

    private final JDA jda;

    public DiscordBot(String token) {
        this.jda = JDABuilder.createDefault(token)
                .addEventListeners(new BotEventListener())
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .setChunkingFilter(ChunkingFilter.ALL).build();
        
        try {
            this.jda.awaitReady();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public JDA getJda() {
        return jda;
    }
}