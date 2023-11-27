package helper;

import com.github.javafaker.Faker;
import models.Category;
import models.Pet;
import models.Tag;

import java.util.Random;

public class DataGenerator {
    public static Pet getPet(){
        Faker faker = new Faker();
        Random random = new Random();
        String name = faker.funnyName().name();
        String[] pU = {faker.internet().image()};
        String status = "pending";
        Category category = new Category(random.nextLong(), faker.funnyName().name());
        Tag[] tags = {new Tag(random.nextLong(), faker.animal().name())};
        return  new Pet(name,pU,status,category,tags);
    }
}
