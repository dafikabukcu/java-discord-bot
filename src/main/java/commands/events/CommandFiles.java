package commands.events;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class CommandFiles {

    public static String[] getGreetingCommands(){
        String line = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/commands/chat/greetingCommands.txt"));
            line = reader.readLine();
        }catch (FileNotFoundException e){
            System.err.println("File not found.");
        }catch (IOException e){
            System.err.println("Line contains unknown characters.");
        }
        String arr[] = line.split(",");

        return arr;
    }

    public static String getRandomGreetingAnswer(){
        String line = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/commands/chat/greetingAnswers.txt"));
            line = reader.readLine();
        }catch (FileNotFoundException e){
            System.err.println("File not found.");
        }catch (IOException e){
            System.err.println("Line contains unknown characters.");
        }
        String arr[] = line.split(",");

        int rand = ThreadLocalRandom.current().nextInt(1, arr.length);
        String answer = arr[rand];

        return answer + " ";
    }

}
