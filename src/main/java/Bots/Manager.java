package Bots;

import Bots.commands.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Manager {

    private final Map<String, Command> commands = new HashMap<>();

    Manager(){
        addCommand(new Ping());
        addCommand(new Ajuda(this));
        addCommand(new Ip());
        addCommand(new Site());
        addCommand(new Clear());
        addCommand(new Vot());
        addCommand(new Meme());
        addCommand(new UserInfo());
        addCommand(new Staff());
        addCommand(new SetRole());
        addCommand(new RemoveRole());
        addCommand(new Recrutar());
        addCommand(new PromoverStaff());
        addCommand(new RemoveStaff());
        addCommand(new Say());
        addCommand(new Sugestao());
        addCommand(new Kick());
    }


    private void addCommand(Command c){
        if(!commands.containsKey(c.getCommand())){
            commands.put(c.getCommand(), c);
        }
    }

    public Collection<Command> getCommands(){
        return commands.values();
    }

    public Command getCommand(String commandName){
        if(commandName == null){
            return null;
        }
        return commands.get(commandName);
    }

    void run(GuildMessageReceivedEvent event) throws IOException {
        final String msg = event.getMessage().getContentRaw();
        if(!msg.startsWith(Contains.prefix)){
            return;
        }
        final String[] split = msg.replaceFirst("(?i)" + Pattern.quote(Contains.prefix), "").split("\\s+");
        final String command = split[0].toLowerCase();
        if(commands.containsKey(command)){
            final List<String> args = Arrays.asList(split).subList(1, split.length);
            commands.get(command).run(args, event);
        }
    }
}
