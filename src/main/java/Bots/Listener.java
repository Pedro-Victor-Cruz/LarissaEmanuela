package Bots;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.io.IOException;

public class Listener extends ListenerAdapter {

    public final Manager m = new Manager();

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        System.out.println(event.getJDA().getSelfUser().getName() + " está online!");
        for (TextChannel channel : event.getJDA().getTextChannelsByName("logs", true)){
            EmbedBuilder onlinebot = new EmbedBuilder();
            onlinebot.setTitle("Larissa Emanuela V2");
            onlinebot.setDescription(":white_check_mark: Bot online com sucesso! \n Ping: "
            + event.getJDA().getGatewayPing() + "ms. \n " +
                    "Status: " + event.getJDA().getStatus().name() + ". \n" +
                    "Guilds: " + event.getJDA().getGuilds().size() + ".");
            onlinebot.setFooter(event.getJDA().getSelfUser().getName());
            onlinebot.setColor(Color.green);
            channel.sendMessage(onlinebot.build()).queue();
        }
    }


    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        if(event.getMessage().getContentRaw().equalsIgnoreCase(Contains.prefix + "desligarbot")
                && event.getAuthor().getId().equals(Contains.IDDONO)){
            event.getJDA().shutdown();
            System.exit(0);
        }
        try {
            m.run(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
