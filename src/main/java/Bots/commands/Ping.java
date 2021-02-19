package Bots.commands;

import Bots.Command;
import Bots.Contains;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Ping implements Command {

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong!").queue(msg -> {
            msg.editMessage(event.getJDA().getGatewayPing() + "ms").queue();
        });
    }

    @Override
    public String getCommand() {
        return "ping";
    }

    @Override
    public String getHelp() {
        return "Verifica o ping do bot! \nUso: " + Contains.prefix + getCommand();
    }
}
