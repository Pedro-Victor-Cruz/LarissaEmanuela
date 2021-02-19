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

public class RemoveStaff implements Command {

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {


        if(event.getMember().hasPermission(Permission.MANAGE_ROLES) || event.getAuthor().getId().equals(Contains.IDDONO)){

            Role equipe = event.getGuild().getRoleById("792789344569524254");
            Role diretor = event.getGuild().getRoleById("792782195575619595");
            Role gerente = event.getGuild().getRoleById("792782955733975060");
            Role admin = event.getGuild().getRoleById("792783053331628032");
            Role modchefe = event.getGuild().getRoleById("803352442582466620");
            Role mod = event.getGuild().getRoleById("792783092091846686");
            Role builder = event.getGuild().getRoleById("796918471677968384");
            Role ajudante = event.getGuild().getRoleById("792783611535425616");
            Role ajudantedc = event.getGuild().getRoleById("792783768074977331");

            if(args.size() == 2){

                String idmember = args.get(0).replaceAll("<@", "").replaceAll("!", "").replaceAll(">", "");
                Member member = event.getGuild().getMemberById(idmember);

                if(member.getRoles().contains(equipe)){
                    if(args.get(1).equalsIgnoreCase("Diretor")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + diretor.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, diretor).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + diretor.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else if(args.get(1).equalsIgnoreCase("Gerente")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + gerente.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, gerente).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + gerente.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else if(args.get(1).equalsIgnoreCase("Admin")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + admin.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, admin).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + admin.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else if(args.get(1).equalsIgnoreCase("Modchefe")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + modchefe.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, modchefe).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + modchefe.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else if(args.get(1).equalsIgnoreCase("mod")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + mod.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, mod).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + mod.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else if(args.get(1).equalsIgnoreCase("builder")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + builder.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, builder).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + builder.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else if(args.get(1).equalsIgnoreCase("ajudante")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + ajudante.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, ajudante).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + ajudante.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else if(args.get(1).equalsIgnoreCase("ajudantedc")){
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Remoção");
                        stafflogs.setDescription("Um membro foi retirado da staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + ajudantedc.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.RED);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().removeRoleFromMember(member, ajudantedc).queue();
                        event.getGuild().removeRoleFromMember(member, equipe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder removido = new EmbedBuilder();
                        removido.setTitle("Staff removido com sucesso!");
                        removido.setDescription("O usuário " + member.getAsMention() + " foi removido da staff com suesso! \n" +
                                "Foi retirado o cargo " + ajudantedc.getAsMention() + ". \n" +
                                "Caso ele ainda tenha algum cargo da equipe nele, não esqueça de retirar!");
                        removido.setFooter(event.getJDA().getSelfUser().getName());
                        removido.setColor(Color.green);

                        event.getChannel().sendMessage(removido.build()).queue();
                    } else {
                        EmbedBuilder err = new EmbedBuilder();
                        err.setTitle(":x: Erro ao executar o comando!");
                        err.setDescription("**Esse cargo não é válido!**\n" +
                                "Cargos da staff:\n" +
                                "➥ Diretor\n" +
                                "➥ Gerente\n" +
                                "➥ Admin\n" +
                                "➥ ModChefe\n" +
                                "➥ Mod\n" +
                                "➥ Builder\n" +
                                "➥ Ajudante\n" +
                                "➥ AjudanteDc\n");
                        err.setColor(Color.RED);
                        err.setFooter(event.getJDA().getSelfUser().getName());
                        event.getChannel().sendMessage(err.build()).queue();
                    }
                } else {
                    EmbedBuilder err = new EmbedBuilder();
                    err.setTitle(":x: Erro ao executar o comando!");
                    err.setDescription("Esse usuário não é um membro da equipe!");
                    err.setColor(Color.RED);
                    err.setFooter(event.getJDA().getSelfUser().getName());
                    event.getChannel().sendMessage(err.build()).queue();
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
        return "removestaff";
    }

    @Override
    public String getHelp() {
        return "Comando utilizado para remover um staff! \n" +
                "Uso: " + Contains.prefix + getCommand() + " [@staff] [cargo]";
    }
}
