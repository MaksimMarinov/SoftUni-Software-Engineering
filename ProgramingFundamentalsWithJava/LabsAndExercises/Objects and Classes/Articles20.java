import java.util.*;
import java.util.stream.Stream;

public class Articles20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Article> allData = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] articles = scanner.nextLine().split(",");
            Article article = new Article(articles[0], articles[1],articles[2] );
            allData.add(article);
        }
        String command = scanner.nextLine();
        switch (command){
            case("title"):
                allData.sort(Comparator.comparing(Article::getTitle));
                break;
            case("content"):
                allData.sort(Comparator.comparing(Article::getContent));
                break;
            case("author"):
                allData.sort(Comparator.comparing(Article::getAuthor));
                break;
        }
        for (Article allDatum : allData) {
            System.out.println(allDatum.toString());
        }

    }
    public static class Article{
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }
}
