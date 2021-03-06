package me.bukkit.i01;

import net.dv8tion.jda.api.*;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.time.ZonedDateTime;


public class Bot {

    public static JDA jda;

    public static void sendServerChat(String message, String UUID) {
        EmbedBuilder EmbedServerChat = new EmbedBuilder()
                .setTimestamp(ZonedDateTime.now())
                .setFooter(Main.Message_Embed_Footer)
                .setThumbnail("https://crafatar.com/renders/head/" + UUID)
                .setColor(Color.decode(Main.ColorHexCode))
                .setDescription("\n" + message);

        jda.getGuildById(Main.GuildID).getTextChannelById(Main.ServerChatChannelID).sendMessage(EmbedServerChat.build()).queue();
    }

    public static void init(String Token) {
        try {
            jda = JDABuilder.createDefault(Token).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
