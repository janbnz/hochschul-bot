package de.janbnz.bot.listener;

import de.janbnz.bot.DiscordBot;
import de.janbnz.bot.command.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotEventListener extends ListenerAdapter {

    private final DiscordBot bot;

    public BotEventListener(DiscordBot bot) {
        this.bot = bot;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        final String commandName = event.getName();
        final SlashCommand command = this.bot.getCommandRegistry().getCommands().get(commandName);
        if (command == null) return;
        command.performCommand(event, event.getMember(), event.getChannel().asTextChannel());
    }
}