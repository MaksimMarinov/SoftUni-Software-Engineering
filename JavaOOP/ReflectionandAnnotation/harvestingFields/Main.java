package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		Field[] fields = RichSoilLand.class.getDeclaredFields();
		while (!line.equals("HARVEST")) {
			if (!line.equals("all")) {
				final String modifier = line;
				Arrays.stream(fields).filter(field -> Modifier.toString(field.getModifiers()).equals(modifier))
						.forEach(field -> System.out.println(Modifier.toString(
								field.getModifiers()) + " " + field.getType().getSimpleName() + " " +
								field.getName()));
			} else {
				Arrays.stream(fields)
						.forEach(field -> System.out.println(Modifier.toString(field.getModifiers()) +
								" " + field.getType().getSimpleName() + " " + field.getName()));
			}

			line = bf.readLine();
		}

	}
}

