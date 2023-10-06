package de.janbnz.bot;

public class BotLauncher {

    public static void main(String[] args) {
        final String token = args[0];
        new DiscordBot(token);
    }
}