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

public class PromoverStaff implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {
        if(event.getMember().hasPermission(Permission.MANAGE_ROLES) || event.getAuthor().getId().equals(Contains.IDDONO)){
            if(args.size() == 2){

                Role equipe = event.getGuild().getRoleById("792789344569524254");
                Role diretor = event.getGuild().getRoleById("792782195575619595");
                Role gerente = event.getGuild().getRoleById("792782955733975060");
                Role admin = event.getGuild().getRoleById("792783053331628032");
                Role modchefe = event.getGuild().getRoleById("803352442582466620");
                Role mod = event.getGuild().getRoleById("792783092091846686");
                Role builder = event.getGuild().getRoleById("796918471677968384");

                if(event.getMember().getRoles().contains(equipe)) {
                    String idmember = args.get(0).replaceAll("<@", "").replaceAll("!", "").replaceAll(">", "");
                    Member member = event.getGuild().getMemberById(idmember);
                    if (args.get(1).equalsIgnoreCase("diretor")) {
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Promoção");
                        stafflogs.setDescription("Um novo membro foi recrutado para a staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + diretor.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.CYAN);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().addRoleToMember(member, diretor).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder promovido = new EmbedBuilder();
                        promovido.setTitle("Staff promovido com sucesso!");
                        promovido.setDescription("O usuário " + member.getAsMention() + " foi promovido com suesso! \n" +
                                "Foi adicionado o cargo " + diretor.getAsMention() + ". \n" +
                                "Não se esqueça de remover o cargo antigo!");
                        promovido.setFooter(event.getJDA().getSelfUser().getName());
                        promovido.setColor(Color.green);

                        event.getChannel().sendMessage(promovido.build()).queue();
                    } else if (args.get(1).equalsIgnoreCase("gerente")) {
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Promoção");
                        stafflogs.setDescription("Um novo membro foi recrutado para a staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + gerente.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.CYAN);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().addRoleToMember(member, gerente).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder promovido = new EmbedBuilder();
                        promovido.setTitle("Staff promovido com sucesso!");
                        promovido.setDescription("O usuário " + member.getAsMention() + " foi promovido com suesso! \n" +
                                "Foi adicionado o cargo " + gerente.getAsMention() + ". \n" +
                                "Não se esqueça de remover o cargo antigo!");
                        promovido.setFooter(event.getJDA().getSelfUser().getName());
                        promovido.setColor(Color.green);

                        event.getChannel().sendMessage(promovido.build()).queue();
                    } else if (args.get(1).equalsIgnoreCase("admin")) {
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Promoção");
                        stafflogs.setDescription("Um novo membro foi recrutado para a staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + admin.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.CYAN);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().addRoleToMember(member, admin).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder promovido = new EmbedBuilder();
                        promovido.setTitle("Staff promovido com sucesso!");
                        promovido.setDescription("O usuário " + member.getAsMention() + " foi promovido com suesso! \n" +
                                "Foi adicionado o cargo " + admin.getAsMention() + ". \n" +
                                "Não se esqueça de remover o cargo antigo!");
                        promovido.setFooter(event.getJDA().getSelfUser().getName());
                        promovido.setColor(Color.green);

                        event.getChannel().sendMessage(promovido.build()).queue();
                    } else if (args.get(1).equalsIgnoreCase("modchefe")) {
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Promoção");
                        stafflogs.setDescription("Um novo membro foi recrutado para a staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + modchefe.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.CYAN);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().addRoleToMember(member, modchefe).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder promovido = new EmbedBuilder();
                        promovido.setTitle("Staff promovido com sucesso!");
                        promovido.setDescription("O usuário " + member.getAsMention() + " foi promovido com suesso! \n" +
                                "Foi adicionado o cargo " + modchefe.getAsMention() + ". \n" +
                                "Não se esqueça de remover o cargo antigo!");
                        promovido.setFooter(event.getJDA().getSelfUser().getName());
                        promovido.setColor(Color.green);

                        event.getChannel().sendMessage(promovido.build()).queue();
                    } else if (args.get(1).equalsIgnoreCase("mod")) {
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Promoção");
                        stafflogs.setDescription("Um novo membro foi recrutado para a staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + mod.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.CYAN);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().addRoleToMember(member, mod).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder promovido = new EmbedBuilder();
                        promovido.setTitle("Staff promovido com sucesso!");
                        promovido.setDescription("O usuário " + member.getAsMention() + " foi promovido com suesso! \n" +
                                "Foi adicionado o cargo " + mod.getAsMention() + ". \n" +
                                "Não se esqueça de remover o cargo antigo!");
                        promovido.setFooter(event.getJDA().getSelfUser().getName());
                        promovido.setColor(Color.green);

                        event.getChannel().sendMessage(promovido.build()).queue();
                    } else if (args.get(1).equalsIgnoreCase("builder")) {
                        EmbedBuilder stafflogs = new EmbedBuilder();
                        stafflogs.setTitle("Staff-Logs | Promoção");
                        stafflogs.setDescription("Um novo membro foi recrutado para a staff!\nInformações:\n" +
                                "➥ **Membro**: " + member.getAsMention() +
                                "\n➥ **Cargo**: " + builder.getAsMention() +
                                "\n➥ **Responsável**: " + event.getAuthor().getAsMention() +
                                "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        stafflogs.setColor(Color.CYAN);
                        stafflogs.setFooter(event.getJDA().getSelfUser().getName());
                        stafflogs.setThumbnail(member.getUser().getEffectiveAvatarUrl());

                        event.getGuild().addRoleToMember(member, builder).queue();
                        event.getGuild().getTextChannelById("792899411327713310").sendMessage(stafflogs.build()).queue();

                        EmbedBuilder promovido = new EmbedBuilder();
                        promovido.setTitle("Staff promovido com sucesso!");
                        promovido.setDescription("O usuário " + member.getAsMention() + " foi promovido com suesso! \n" +
                                "Foi adicionado o cargo " + builder.getAsMention() + ". \n" +
                                "Não se esqueça de remover o cargo antigo!");
                        promovido.setFooter(event.getJDA().getSelfUser().getName());
                        promovido.setColor(Color.green);

                        event.getChannel().sendMessage(promovido.build()).queue();
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
                                "Caso queira promover para `ajudante` utilize o comando " + Contains.prefix + "recrutar @[membro] @[cargo]");
                        err.setColor(Color.RED);
                        err.setFooter(event.getJDA().getSelfUser().getName());
                        event.getChannel().sendMessage(err.build()).queue();
                    }
                } else {
                    EmbedBuilder err = new EmbedBuilder();
                    err.setTitle(":x: Erro ao executar o comando!");
                    err.setDescription("Esse usuário não é um membro da equipe!\n" +
                            "Caso queira recrutar ele, utilize o comando " + Contains.prefix + "recrutar @[membro] @[cargo]");
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
        return "promover";
    }

    @Override
    public String getHelp() {
        return "Comando utilizado para promover um staffer!\n Uso: " + Contains.prefix + getCommand() + " [@staffer] [@cargo]";
    }
}
