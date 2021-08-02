package com.miguel.day6;


// in proper Dependency manageemnt
//class Engine{
//    public Engine(String type){
//
//    }
//}
//
//class Tyre{
//    public Tyre(String type){
//
//    }
//}
//
//class Car{
//    Engine engine;
//    Tyre tyre;
//
//    public  Car(){
//        this.engine = new Engine();
//        this.tyre = new Tyre();
//    }
//}
class Engine{
    private String modelNumber;
    public Engine(String modelNumber){
        this.modelNumber = modelNumber;
    }

}
class Tyre{
    private String type;
    public Tyre(String type){
        this.type = type;
    }
}

class CarFactory2{
    public static Car getInstance(int id){
        switch (id){
            case 0:
                return new Car(new Engine("RB26DETT"),new Tyre("racing"));
            case 1:
                return new Car(new Engine("2JZ"),new Tyre("racing"));
            default:
                return null;
        }
    }
}

class Car{
    Engine engine;
    Tyre tyre;

    public Car(Engine engine, Tyre tyre){
        this.engine = engine;
        this.tyre = tyre;
    }

}


public class Demo7 {
    public static void main(String[] args) {
       Car supra = CarFactory2.getInstance(1);
       Car skyLine = CarFactory2.getInstance(0);
    }
}
