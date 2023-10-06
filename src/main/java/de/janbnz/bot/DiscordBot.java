package de.janbnz.bot;

import de.janbnz.bot.command.SlashCommandRegistry;
import de.janbnz.bot.listener.BotEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;

public class DiscordBot {

    private final JDA jda;
    private final SlashCommandRegistry commandRegistry;

    public DiscordBot(String token) {
        this.jda = JDABuilder.createDefault(token)
                .addEventListeners(new BotEventListener(this))
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .setChunkingFilter(ChunkingFilter.ALL).build();

        this.commandRegistry = new SlashCommandRegistry(this.jda);
        try {
            this.jda.awaitReady();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public SlashCommandRegistry getCommandRegistry() {
        return commandRegistry;
    }

    public JDA getJda() {
        return jda;
    }
}