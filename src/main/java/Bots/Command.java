package Bots;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.IOException;
import java.util.List;

public interface Command {
    void run(List<String> args, GuildMessageReceivedEvent event) throws IOException;
    String getCommand();
    String getHelp();
}
