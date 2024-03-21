package utils;
import com.github.javafaker.Faker;
import java.util.Random;
public class DataGenerator {
    static Faker faker = new Faker();
    public static String getRandomEmail()
    {
        return faker.internet().emailAddress();
    }
    public static String getRandomFirstName()
    {
        return faker.name().firstName();
    }
    public static String getRandomLastName()
    {
        return faker.name().lastName();
    }
    public static String getRandomStreetAddress()
    {
        return faker.address().streetAddress();
    }
    public static String getRandomPostCode()
    {
        return faker.address().zipCode();
    }
    public static String getRandomCity()
    {
        return faker.address().city();
    }

    }
