package homeworks.JSONclasswork;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RecipeRunner {
    public static void main(String[] args) throws IOException {
       RecipeRunner recipeRunner = new RecipeRunner();
       recipeRunner.toJson();
//       recipeRunner.fromJson();
        }
    ObjectMapper objectMapper = new ObjectMapper();

    public void toJson() throws IOException {
        Recipe recipe = new Recipe("Salad", Arrays.asList(
                new Ingredient("Tomato", 2),
                new Ingredient("Cucumber", 1)),
                3);
        objectMapper.writerWithDefaultPrettyPrinter().
                writeValue(new File("src/test/java/recipe.json"), recipe);

    }
    public void fromJson() throws IOException {    Recipe recipe = objectMapper
            .readValue(new File("src/test/recipe.json"), Recipe.class);    System.out.println(recipe);}
}
