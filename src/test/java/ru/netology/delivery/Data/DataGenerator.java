package ru.netology.delivery.Data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateCity() {
        var cities = new String[] {"Вологда","Воронеж","Уфа","Петрозаводск","Казань","Тверь","Томск","Улан-Удэ",
        "Якутск","Владикавказ","Ставрополь","Калуга","Липецк","Москва","Екатеринбург","Новосибирск", "Краснодар",
        "Майкоп","Элиста","Ижевск","Абакан","Чита","Пермь","Красноярск","Хабаровск","Владимир","Магадан","Биробиджан",
        "Астрахань","Архангельск","Сыктывкар","Кызыл","Барнаул","Благовещенск","Брянск","Иркутск","Курск","Курган",
        "Кемерово","Киров","Кострома","Мурманск","Омск","Рязань","Оренбург","Самара","Саратов","Смоленск","Тамбов",
        "Тула","Тюмень","Ульяновск","Ярославль","Салехард","Анадырь","Псков","Иваново","Челябинск","Саранск","Черкесск"};
        return cities[new Random().nextInt(cities.length)];

    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name()
                .lastName() + " " + faker.name()
                .firstName();

    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber()
                .phoneNumber();
    }

    public static String generateData(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
            return user;
        }
    }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }


