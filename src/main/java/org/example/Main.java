package org.example;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Jsonb jsonb = JsonbBuilder.create();

        Path carsFilePath = Paths.get("src/main/resources/cars");
        List<String> carListFromFile = Files.readAllLines(carsFilePath);
        List<Car> carList = new ArrayList<>();
        for (String car : carListFromFile) {
            carList.add(jsonb.fromJson(car, Car.class));
        }

        Car.printer(Car.searchCars(carList));
    }


}