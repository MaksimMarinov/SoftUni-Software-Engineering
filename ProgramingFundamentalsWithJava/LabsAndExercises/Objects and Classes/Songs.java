import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs=new ArrayList<>();

        for (int i = 0; i < n; i++) {
        String[] line = scanner.nextLine().split("_+");
        Song song = new Song(line[0], line[1], line[2] );
        songs.add(song);
        }
        String typeList = scanner.nextLine();
        if(typeList.equals("all")){
        for (Song song : songs) {
            System.out.println(song.getName());
        }}else{
            for (Song song : songs) {
                if(song.getTypeList().equals(typeList)){
                    System.out.println(song.getName());
                }
            }
        }



    }
    public static class Song{
        private String typeList;
        private String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }
    }


}
