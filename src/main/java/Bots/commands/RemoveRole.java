package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RemoveRole implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {

        if(event.getAuthor().equals(Contains.IDDONO) || event.getMember().hasPermission(Permission.ADMINISTRATOR)){
            if(args.size() == 2){
                String idmember = args.get(0).replaceAll("<@", "").replaceAll("!", "").replaceAll(">", "");
                String idrole = args.get(1).replaceAll("<@", "").replaceAll("&", "").replaceAll(">", "");
                Member member = event.getGuild().getMemberById(idmember);
                Role role = event.getGuild().getRoleById(idrole);
                if(member.getRoles().contains(role)){
                    EmbedBuilder log = new EmbedBuilder();
                    log.setTitle("**Remoção de cargo**");
                    log.setDescription("Você acabou de remover um cargo!\nInformações:\n\n"
                            + "➥ **Membro**: " + member.getAsMention()
                            + "\n➥ **Cargo**: " + role.getAsMention()
                            + "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    log.setColor(Color.RED);
                    log.setFooter(event.getJDA().getSelfUser().getName());
                    event.getChannel().sendMessage(log.build()).queue();
                    event.getGuild().removeRoleFromMember(member, role).queue();
                } else {
                    EmbedBuilder err = new EmbedBuilder();
                    err.setTitle("Erro ao executar o comando!");
                    err.setDescription("O usuário " + member.getAsMention() + " já possui o cargo " + role.getAsMention() + "!");
                    err.setColor(Color.RED);
                    err.setFooter(event.getJDA().getSelfUser().getName());
                    event.getChannel().sendMessage(err.build()).queue();
                }
            } else {
                Tools.wrongUsage(event.getChannel(), this);
            }
        } else {
            Tools.notPermission(event.getChannel(), this, "ADMINISTRADOR");
        }
    }

    @Override
    public String getCommand() {
        return "removerole";
    }

    @Override
    public String getHelp() {
        return "Utilizado para remover o cargo de usuário!\n Uso: " + Contains.prefix + getCommand() + " [@membro] [@cargo]";
    }
}
