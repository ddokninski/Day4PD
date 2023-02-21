package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        Country poland = new Country("Poland", 'P');
        Country germany = new Country("Germany", 'D');
        Country italy = new Country("Italy", 'I');
        Country korea = new Country("Korea", 'K');
        Country france = new Country("France", 'F');
        Country china = new Country("China", 'C');

        List<Country> market1List = List.of(poland, italy, korea, france);
        List<Country> market2List = List.of(poland, germany, korea, france);
        List<Country> market3List = List.of(poland, germany, italy, france);
        List<Country> market4List = List.of(poland, germany, italy, korea);
        List<Country> market5List = List.of(poland, germany, italy, korea, france);
        List<Country> market6List = List.of(china);

        Market market1 = new Market("Market1", market1List);
        Market market2 = new Market("Market2", market2List);
        Market market3 = new Market("Market3", market3List);
        Market market4 = new Market("Market4", market4List);
        Market market5 = new Market("Market5", market5List);
        Market market6 = new Market("Market6", market6List);

        Dimension dimension1 = new Dimension(60, 160, 100);
        Dimension dimension2 = new Dimension(70, 160, 200);
        Dimension dimension3 = new Dimension(80, 160, 300);
        Dimension dimension4 = new Dimension(90, 170, 400);
        Dimension dimension5 = new Dimension(100, 170, 400);
        Dimension dimension6 = new Dimension(110, 170, 400);
        Dimension dimension7 = new Dimension(120, 180, 400);
        Dimension dimension8 = new Dimension(130, 180, 500);
        Dimension dimension9 = new Dimension(140, 180, 600);
        Dimension dimension10 = new Dimension(150, 190, 700);
        Dimension dimension11 = new Dimension(1500, 1500, 1500);
        Dimension dimension12 = new Dimension(1000, 1000, 1000);

        List<Dimension> dimensionList1 = List.of(dimension1, dimension2);
        List<Dimension> dimensionList2 = List.of(dimension3, dimension4);
        List<Dimension> dimensionList3 = List.of(dimension5, dimension6);
        List<Dimension> dimensionList4 = List.of(dimension7, dimension8);
        List<Dimension> dimensionList5 = List.of(dimension9, dimension10);
        List<Dimension> dimensionList6 = List.of(dimension11, dimension12);

        Producer bmw = new Producer("BMW", "limousine");
        Producer audi = new Producer("AUDI", "limousine");
        Producer mercedes = new Producer("MERCEDES", "limousine");
        Producer toyota = new Producer("TOYOTA", "SUV");
        Producer vw = new Producer("VW", "SUV");
        Producer skoda = new Producer("SKODA", "combi");
        Producer mazda = new Producer("MAZDA", "cabrio");
        Producer ford = new Producer("FORD", "hatchback");
        Producer chrysler = new Producer("CHRYSLER", "van");
        Producer porsche = new Producer("PORSCHE", "supercar");
        Producer polonez = new Producer("POLONEZ", "supercar");

        Car car1 = new Car(bmw, true, market1, "premium", dimensionList1);
        Car car2 = new Car(audi, true, market2, "premium", dimensionList2);
        Car car3 = new Car(mercedes, true, market3, "premium", dimensionList3);
        Car car4 = new Car(toyota, true, market4, "medium", dimensionList4);
        Car car5 = new Car(vw, true, market5, "medium", dimensionList5);
        Car car6 = new Car(skoda, true, market1, "standard", dimensionList1);
        Car car7 = new Car(mazda, true, market2, "standard", dimensionList2);
        Car car8 = new Car(ford, true, market3, "standard", dimensionList3);
        Car car9 = new Car(chrysler, true, market4, "standard", dimensionList4);
        Car car10 = new Car(porsche, false, market5, "premium", dimensionList5);
        Car car11 = new Car(polonez, false, market6, "standard", dimensionList6);

        List<Car> carsList = List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11);

        System.out.println(Car.searchCars(carsList));
        Car.printer(Car.searchCars(carsList));



    }


}