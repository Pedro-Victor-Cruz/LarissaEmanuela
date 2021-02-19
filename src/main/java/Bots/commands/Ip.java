package Bots.commands;

import Bots.Command;
import Bots.Contains;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.List;

public class Ip implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        EmbedBuilder ip = new EmbedBuilder();
        ip.setFooter("IP: bittenmc.com.br", event.getGuild().getIconUrl());
        ip.setColor(Color.cyan);
        event.getChannel().sendMessage(ip.build()).queue();
    }

    @Override
    public String getCommand() {
        return "ip";
    }

    @Override
    public String getHelp() {
        return "Mostra o ip do servidor. \nUso: " + Contains.prefix + getCommand();
    }
}
