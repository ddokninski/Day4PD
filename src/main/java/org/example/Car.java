package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Car {
    protected Producer producer;
    protected boolean isAutomaticGearBox;
    protected Market market;
    protected String segment;
    protected List<Dimension> dimensionList;

    public Producer getProducer() {
        return producer;
    }

    public String getSegment() {
        return segment;
    }

    public List<Dimension> getDimensionList() {
        return dimensionList;
    }

    public Car(Producer producer, boolean isAutomaticGearBox, Market market, String segment, List<Dimension> dimensionList) {
        this.producer = producer;
        this.isAutomaticGearBox = isAutomaticGearBox;
        this.market = market;
        this.segment = segment;
        this.dimensionList = dimensionList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer=" + producer +
                ", isAutomaticGearBox=" + isAutomaticGearBox +
                ", market=" + market +
                ", segment='" + segment + '\'' +
                ", dimensionList=" + dimensionList +
                '}';
    }


    public static List<Car> gearBoxChecker(List<Car> carsList, boolean isAutomaticGearBox) {
        return carsList.stream()
                .filter(car -> car.isAutomaticGearBox == isAutomaticGearBox)
                .collect(Collectors.toList());
    }

    public static List<Car> modelChecker(List<Car> carList, String modelName) {
        return carList.stream()
                .filter(car -> car.getProducer().model().equals(modelName))
                .collect(Collectors.toList());
    }

    public static List<Car> typeChecker(List<Car> carList, String typeName) {
        return carList.stream()
                .filter(car -> car.getProducer().type().equals(typeName))
                .collect(Collectors.toList());
    }

    public static List<Car> segmentChecker(List<Car> carList, String segmentName) {
        return carList.stream()
                .filter(car -> car.getSegment().equals(segmentName))
                .collect(Collectors.toList());
    }

    public static List<Car> marketNameChecker(List<Car> carsList, String marketName) {
        return carsList.stream()
                .filter(car -> car.market.name().equals(marketName))
                .collect(Collectors.toList());
    }

    public boolean hasBiggerTrunkCapacityThan(int trunkCapacity) {
        return dimensionList.stream()
                .anyMatch(dimension -> dimension.trunkCapacity() >= trunkCapacity);
    }

    public static List<Car> minTrunkCapacityChecker(List<Car> carList, int trunkCapacity) {
        return carList.stream()
                .filter(car -> car.hasBiggerTrunkCapacityThan(trunkCapacity))
                .collect(Collectors.toList());
    }

    public boolean hasBiggerHighThan(int high) {
        return dimensionList.stream()
                .anyMatch(dimension -> dimension.high() >= high);
    }

    public static List<Car> minHighChecker(List<Car> carList, int high) {
        return carList.stream()
                .filter(car -> car.hasBiggerHighThan(high))
                .collect(Collectors.toList());
    }

    public boolean hasBiggerWidthThan(int width) {
        return dimensionList.stream()
                .anyMatch(dimension -> dimension.width() >= width);
    }

    public static List<Car> minWidthChecker(List<Car> carList, int width) {
        return carList.stream()
                .filter(car -> car.hasBiggerWidthThan(width))
                .collect(Collectors.toList());
    }

    public boolean hasCountryName (String countryName) {
        return market.countries().stream()
                .anyMatch(country -> country.countryName().equals(countryName));
    }

    public static List<Car> countryNameChecker (List<Car> carList, String countryName) {
        return carList.stream()
                .filter(car -> car.hasCountryName(countryName))
                .collect(Collectors.toList());
    }

    public boolean hasCountrySign (String countrySign) {
        return market.countries().stream()
                .anyMatch(country -> String.valueOf(country.countrySign()).equals(countrySign));
    }

    public static List<Car> countrySignChecker (List<Car> carList, String countrySign) {
        return carList.stream()
                .filter(car -> car.hasCountrySign(countrySign))
                .collect(Collectors.toList());
    }

    public static void printer(List<Car> carsList) {
        for (Car car : carsList) {
            for (int j = 0; j < car.market.countries().size(); j++) {
                System.out.print(car.market.countries().get(j).countryName() + " - ");
                System.out.println(car.market.countries().get(j).countrySign());
            }
        }
    }

    public static List<Car> searchCars(List<Car> carsList) throws IOException {

        Properties testData = FileLoader.loadFile("search.properties");

        String countryName = testData.getProperty("countryName");
        String countrySign = testData.getProperty("countrySign");
        String marketName = testData.getProperty("marketName");
        String minHigh = testData.getProperty("minHigh");
        String minWidth = testData.getProperty("minWidth");
        String minTrunkCapacity = testData.getProperty("minTrunkCapacity");
        String model = testData.getProperty("model");
        String type = testData.getProperty("type");
        String isAutomaticGearBox = testData.getProperty("isAutomaticGearBox");
        String segment = testData.getProperty("segment");

        carsList = !countryName.isEmpty() ? countryNameChecker(carsList, countryName) : carsList;
        carsList = !countrySign.isEmpty() ? countrySignChecker(carsList, countrySign) : carsList;
        carsList = !marketName.isEmpty() ? marketNameChecker(carsList, marketName) : carsList;
        carsList = !minHigh.isEmpty() ? minHighChecker(carsList, Integer.parseInt(minHigh)) : carsList;
        carsList = !minWidth.isEmpty() ? minWidthChecker(carsList, Integer.parseInt(minWidth)) : carsList;
        carsList = !minTrunkCapacity.isEmpty() ? minTrunkCapacityChecker(carsList, Integer.parseInt(minTrunkCapacity)) : carsList;
        carsList = !model.isEmpty() ? modelChecker(carsList, model) : carsList;
        carsList = !type.isEmpty() ? typeChecker(carsList, type) : carsList;

        if (!isAutomaticGearBox.isEmpty()) {
            if ("true".equals(isAutomaticGearBox)) {
                carsList = gearBoxChecker(carsList, true);
            } else {
                carsList = gearBoxChecker(carsList, false);
            }
        }

        carsList = !segment.isEmpty() ? segmentChecker(carsList, segment) : carsList;

        return carsList;
    }

}
