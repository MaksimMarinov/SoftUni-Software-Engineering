package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repository.IngredientRepository;
import com.example.advquerying.repository.ShampooRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

@Component
public class Controller implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final IngredientRepository ingredientRepository;
    private BufferedReader bf;
    private  String checkSize;
    private Size size;

    public Controller(ShampooRepository shampooRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
        this.bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Choose taskNumber:");
        String task = bf.readLine();
        switch (task){
            case "1"-> selectShampooBySize();
            case "2" -> selectShampooBySizeOrLabelId();
            case "3" -> selectShampoosByPriceHigherThan();
            case "4" -> selectIngredientsByName();
            case "5" -> selectIngredientsByNames();
            case "6" -> countShampoosByPrice();
            case "7" -> selectShampoosByIngredients();
            case "8" -> selectShampoosByIngredientsCount();
            case "9" -> deleteIngredientsByName();
            case "10" -> upgradeIngredientsByPrice();
            case "11" -> upgradeIngredientsByName();
        }
    }

    private void upgradeIngredientsByName() throws IOException {
        List<String> names = Arrays.asList(bf.readLine().split("\\s+"));
        BigDecimal modifier = new BigDecimal(bf.readLine());
    this.ingredientRepository.upgradeIngredientsByName(modifier, names);
    }

    private void upgradeIngredientsByPrice() {
        this.ingredientRepository.upgradeIngredientsByPrice();
    }


    private void deleteIngredientsByName() throws IOException {
        this.ingredientRepository.deleteAllByName(bf.readLine());
    }

    private void selectShampoosByIngredientsCount() throws IOException {
        int count = Integer.parseInt(bf.readLine());
        this.shampooRepository.findAllByIngredientsCount(count)
                .forEach(shampoo -> System.out.println(shampoo.getBrand()));
    }

    private void selectShampoosByIngredients() throws IOException {
        this.shampooRepository.findAllByIngredientsNames(Arrays.asList(bf.readLine().split(" ")))
                .stream().map(Shampoo::getBrand).forEach(System.out::println);
    }

    private void countShampoosByPrice() throws IOException {
        System.out.println(this.shampooRepository.countShampooByPriceIsLessThan(new BigDecimal(bf.readLine())));

    }

    private void selectIngredientsByNames() throws IOException {


        System.out.println("enter input");
        List<String> names = Arrays.asList(bf.readLine().split("\\s+"));

        ingredientRepository.findIngredientByNameIn(names)
                .stream().sorted(Comparator.comparing(Ingredient::getPrice))
                .forEach(ingredient -> System.out.println(ingredient.getName()));
    }

    private void selectIngredientsByName() throws IOException {
        String start = bf.readLine();
        this.ingredientRepository.findIngredientByNameStartingWith(start)
                .forEach(ingredient -> System.out.println(ingredient.getName()));
    }

    private void selectShampoosByPriceHigherThan() throws IOException {
        BigDecimal price = new BigDecimal(bf.readLine());
        this.shampooRepository.findAllByPriceIsGreaterThanOrderByPriceDesc(price)
                .forEach(shampoo -> {
                    System.out.printf("%s %s %s %.2f%n", shampoo.getBrand(), shampoo.getLabel().getTitle(), shampoo.getSize().name(), shampoo.getPrice());
                });

    }

    private void selectShampooBySizeOrLabelId() throws IOException {
       checkSize= bf.readLine();
        Size size = Size.valueOf(checkSize);
        Long labelId = Long.parseLong(bf.readLine());
        this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, labelId)
                .forEach(shampoo -> {
                    System.out.printf("%s %s %s %.2f%n", shampoo.getBrand(), shampoo.getLabel().getTitle(), shampoo.getSize().name(), shampoo.getPrice());
                });
    }

    private void selectShampooBySize() throws IOException {
        checkSize = bf.readLine();
        size = Size.valueOf(checkSize);
        this.shampooRepository.findAllBySizeOrderById(size)
                .forEach(shampoo -> {
                    System.out.printf("%s %s %s %.2f%n", shampoo.getBrand(), shampoo.getLabel().getTitle(), shampoo.getSize().name(), shampoo.getPrice());
                });
    }
}
