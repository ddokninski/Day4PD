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

        Path countryFilePath = Paths.get("src/main/resources/country");
        List<String> countryListFromFile = Files.readAllLines(countryFilePath);
        List<Country> countryList = new ArrayList<>();
        for (String country : countryListFromFile) {
            countryList.add(jsonb.fromJson(country, Country.class));
        }

        List<Country> market1List = List.of(countryList.get(0), countryList.get(1), countryList.get(2), countryList.get(3));
        List<Country> market2List = List.of(countryList.get(0), countryList.get(2), countryList.get(3), countryList.get(4));
        List<Country> market3List = List.of(countryList.get(0), countryList.get(1), countryList.get(3), countryList.get(4));
        List<Country> market4List = List.of(countryList.get(0), countryList.get(1), countryList.get(2), countryList.get(4));
        List<Country> market5List = List.of(countryList.get(0), countryList.get(1), countryList.get(2), countryList.get(3));
        List<Country> market6List = List.of(countryList.get(5));

        Market market1 = new Market("Market1", market1List);
        Market market2 = new Market("Market2", market2List);
        Market market3 = new Market("Market3", market3List);
        Market market4 = new Market("Market4", market4List);
        Market market5 = new Market("Market5", market5List);
        Market market6 = new Market("Market6", market6List);

        Path marketFilePath = Paths.get("src/main/resources/market");
        List<String> marketListFromFile = Files.readAllLines(marketFilePath);
        List<Market> marketList = new ArrayList<>();
        for (String market : marketListFromFile) {
            marketList.add(jsonb.fromJson(market, Market.class));
        }

        Path dimensionsFilePath = Paths.get("src/main/resources/dimensions");
        List<String> dimensionsListFromFile = Files.readAllLines(dimensionsFilePath);
        List<Dimension> dimensionList = new ArrayList<>();
        for (String dimension : dimensionsListFromFile) {
            dimensionList.add(jsonb.fromJson(dimension, Dimension.class));
        }

        List<Dimension> dimensionList1 = List.of(dimensionList.get(0), dimensionList.get(1));
        List<Dimension> dimensionList2 = List.of(dimensionList.get(2), dimensionList.get(3));
        List<Dimension> dimensionList3 = List.of(dimensionList.get(4), dimensionList.get(5));
        List<Dimension> dimensionList4 = List.of(dimensionList.get(6), dimensionList.get(7));
        List<Dimension> dimensionList5 = List.of(dimensionList.get(8), dimensionList.get(9));
        List<Dimension> dimensionList6 = List.of(dimensionList.get(10), dimensionList.get(11));

        Path producerFilePath = Paths.get("src/main/resources/producer");
        List<String> producerListFromFile = Files.readAllLines(producerFilePath);
        List<Producer> producerList = new ArrayList<>();
        for (String producer : producerListFromFile) {
            producerList.add(jsonb.fromJson(producer, Producer.class));
        }

        Car car1 = new Car(producerList.get(0), true, marketList.get(0), "premium", dimensionList1);
        Car car2 = new Car(producerList.get(1), true, marketList.get(1), "premium", dimensionList2);
        Car car3 = new Car(producerList.get(2), true, marketList.get(2), "premium", dimensionList3);
        Car car4 = new Car(producerList.get(3), true, marketList.get(3), "medium", dimensionList4);
        Car car5 = new Car(producerList.get(4), true, marketList.get(4), "medium", dimensionList5);
        Car car6 = new Car(producerList.get(5), true, marketList.get(0), "standard", dimensionList1);
        Car car7 = new Car(producerList.get(6), true, marketList.get(1), "standard", dimensionList2);
        Car car8 = new Car(producerList.get(7), true, marketList.get(2), "standard", dimensionList3);
        Car car9 = new Car(producerList.get(8), true, marketList.get(3), "standard", dimensionList4);
        Car car10 = new Car(producerList.get(9), false, marketList.get(3), "premium", dimensionList5);
        Car car11 = new Car(producerList.get(10), false, marketList.get(5), "standard", dimensionList6);
        Car car12 = new Car(producerList.get(2), false, marketList.get(5), "standard", dimensionList6);
        Car car13 = new Car(producerList.get(3), false, marketList.get(5), "standard", dimensionList6);
        Car car14 = new Car(producerList.get(4), false, marketList.get(5), "standard", dimensionList6);
        Car car15 = new Car(producerList.get(5), false, marketList.get(5), "standard", dimensionList6);

        String s = jsonb.toJson(car1);
        System.out.println(s);
        System.out.println(producerList.size());

        List<Car> carsList = List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15);

        System.out.println(Car.searchCars(carsList));
        Car.printer(Car.searchCars(carsList));



    }


}