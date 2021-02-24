import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =
                new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line =bf.readLine();
        long vowels=0;
        long consonants=0;
        long punctuations=0;

        while (line!=null){
            for (char c : line.toCharArray()) {
               if(c=='a'||c=='e'||c=='i'
                ||c=='o'||c=='u'){
                    vowels++;
                }else if(c==','||c=='.'||c=='?'
                        ||c=='!'){
                    punctuations++;
                }else{
                    consonants++;
                }
            }
            line =bf.readLine();

        }
        bf.close();
        PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
        writer.println("Vowels: "+vowels);
        writer.println("Consonants: "+consonants);
        writer.println("Punctuation: "+punctuations);
        writer.close();


    }
}
