import commands.events.CommandFiles;
import commands.events.EventChat;
import commands.moderation.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        startBot();

    }

    public static void startBot(){
        String token = readToken();
        try{
            JDA bot = JDABuilder.createDefault(token)
                    .enableIntents(GatewayIntent.GUILD_MEMBERS)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .setActivity(Activity.listening("Wee"))
                    .addEventListeners(new Commands())
                    .addEventListeners(new EventChat())
                    .build()
                    .awaitReady();
        }catch (InterruptedException e){
            System.err.println("Error.");
        }
        System.out.println("Bot is active.");
    }

    public static String readToken(){
        String line = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\java\\token.txt"));

            line = reader.readLine();
        }catch (FileNotFoundException e){
            System.err.println("File not found.");
        }catch (IOException e){
            System.err.println("Line contains unknown characters.");
        }
        return line;
    }
}
