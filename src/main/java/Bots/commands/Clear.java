package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Clear implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(event.getMember().hasPermission(Permission.MESSAGE_MANAGE) || event.getAuthor().getId().equals(Contains.IDDONO)) {
            if (args.isEmpty()) {
                EmbedBuilder err = new EmbedBuilder();
                err.setColor(0xff3923);
                err.setDescription("Especifique a quantidade a ser excluida! \n Use: " + Contains.prefix + "clear [1-100]");
                event.getChannel().sendMessage(err.build()).queue();
            } else {

                try {

                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args.get(0))).complete();
                    event.getChannel().deleteMessages(messages).queue();

                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(0x22ff2a);
                    success.setDescription("Deletadas " + args.get(0) + " mensagens com sucesso!");
                    event.getChannel().sendMessage(success.build()).queue();

                } catch (IllegalArgumentException e) {
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                        EmbedBuilder err = new EmbedBuilder();
                        err.setColor(0xff3923);
                        err.setDescription("Você só pode selecionar até 100 mensagens!");
                        event.getChannel().sendMessage(err.build()).queue();

                    } else {
                        EmbedBuilder err = new EmbedBuilder();
                        err.setColor(0xff3923);
                        err.setDescription("As mensagens selecionadas têm mais de 2 semanas");
                        event.getChannel().sendMessage(err.build()).queue();
                    }
                }
            }
        } else {
            Tools.notPermission(event.getChannel(), this, "MESSAGE_MANAGE");
        }
    }

    @Override
    public String getCommand() {
        return "clear";
    }

    @Override
    public String getHelp() {
        return "Usado para limpar chat. \n Uso: " + Contains.prefix + getCommand() + " `[1-100]`";
    }
}
