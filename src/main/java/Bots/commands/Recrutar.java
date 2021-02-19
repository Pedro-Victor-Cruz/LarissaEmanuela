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
import java.util.concurrent.TimeUnit;

public class Recrutar implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {
        if(event.getMember().hasPermission(Permission.MANAGE_ROLES) || event.getAuthor().getId().equals(Contains.IDDONO)){
            if(args.size() == 2){
                String idmember = args.get(0).replaceAll("<@", "").replaceAll("!", "").replaceAll(">", "");
                String idrole = args.get(1).replaceAll("<@", "").replaceAll("&", "").replaceAll(">", "");
                Member member = event.getGuild().getMemberById(idmember);
                Role role = event.getGuild().getRoleById(idrole);
                Role equipe = event.getGuild().getRoleById("792789344569524254");
                if(member.getRoles().contains(equipe)){
                    EmbedBuilder err = new EmbedBuilder();
                    err.setTitle("Erro ao executar o comando!");
                    err.setDescription("Esse usuário já é um staff!");
                    err.setColor(Color.RED);
                    err.setFooter(event.getJDA().getSelfUser().getName());
                    event.getChannel().sendMessage(err.build()).queue();
                } else {
                    EmbedBuilder recruta = new EmbedBuilder();
                    recruta.setTitle("Staff-Logs | Admição");
                    recruta.setDescription("Um novo membro foi recrutado para a staff!\nInformações:\n" +
                            "➥ **Membro**: " + member.getAsMention() +
                            "\n➥ **Cargo**: " + role.getAsMention() +
                            "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                            "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    recruta.setColor(Color.CYAN);
                    recruta.setFooter(event.getJDA().getSelfUser().getName());
                    recruta.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                    EmbedBuilder recrutado = new EmbedBuilder();
                    recrutado.setTitle("Staff recrutado com sucesso!");
                    recrutado.setDescription("O usuário " + member.getAsMention() + " foi recrutado para a staff! \n" +
                            "Foi adicionado o cargo " + equipe.getAsMention() + " e " + role.getAsMention() + ".");
                    recrutado.setFooter(event.getJDA().getSelfUser().getName());
                    recrutado.setColor(Color.green);

                    event.getChannel().sendMessage(recrutado.build()).queue(msg -> {
                        msg.delete().queueAfter(5, TimeUnit.SECONDS);
                    });
                    event.getGuild().getTextChannelById("792899411327713310").sendMessage(recruta.build()).queue();
                    event.getGuild().addRoleToMember(member, role).queue();
                    event.getGuild().addRoleToMember(member, equipe).queue();
                }
            } else {
                Tools.wrongUsage(event.getChannel(), this);
            }
        } else {
            Tools.notPermission(event.getChannel(), this, "MANAGE_ROLES");
        }
    }

    @Override
    public String getCommand() {
        return "recrutar";
    }

    @Override
    public String getHelp() {
        return "Recruta um membro para a staff! \n Uso: " + Contains.prefix + getCommand() + " [@membro] [@cargo]";
    }
}
