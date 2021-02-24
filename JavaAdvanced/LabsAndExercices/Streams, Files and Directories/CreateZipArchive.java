import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    private static final String FIRST_PATH="C:\\Users\\Maksim\\Desktop\\output.txt";
    private static final String SECOND_PATH="C:\\Users\\Maksim\\Desktop\\output1.txt";
    private static final String THIRD_PATH="C:\\Users\\Maksim\\Desktop\\input.txt";
    private static final String OUTPUT_PATH="C:\\Users\\Maksim\\Desktop\\output12.zip";

    public static void main(String[] args) {
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(OUTPUT_PATH))) {
            addToZip(FIRST_PATH, zos);
            addToZip(SECOND_PATH, zos);
            addToZip(THIRD_PATH, zos);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void addToZip(String path, ZipOutputStream zos) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        String[] tokens = path.split("/");
        String fileName = tokens[tokens.length-1];
        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length =fis.read(bytes))>=0){
        zos.write(bytes, 0, length);

        }
        zos.closeEntry();
        fis.close();
    }
}
