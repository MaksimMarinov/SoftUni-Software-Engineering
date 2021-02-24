import java.io.File;

public class NestedFolders2 {
    public static int foldersCount=0;
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Maksim\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File file = new File(fileName);
        dfc(file);
        System.out.println(foldersCount+" folders");
    }
    public static void dfc(File file){
    foldersCount++;
    for(File f:file.listFiles()){
        if(f.isDirectory()){
            dfc(f);
        }
    }
        System.out.println(file.getName());
    }
}
