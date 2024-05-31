package com.jhogo.irsystem.car;
// import java.util.ArrayList;
// import java.util.List;

//unused 

// public class CarManager {
//     private List<CarDTO> carList;
//     private List<Spending> spendingList;

//     public CarManager() {
//         carList = new ArrayList<>();
//     }

//     public void addCar(CarDTO newCar) {
//         carList.add(newCar);
//         newCar.setInStore(true);
//         printCarsInStore();
//     }

//     public void removeCarFromStore(int carIndex) {
//         int index = 0;
//         if(carIndex >=0 && carIndex < carList.size()) {
//             for (CarDTO car : carList) {
//                 if (index == carIndex) {
//                     car.setInStore(false);
//                     System.out.println("O veiculo " + car.getModel() + " foi colocado como fora de estoque!");
//                 }
//             }
//         }else {
//             System.out.println("A chave informada nao consta na lista!");
//         }
//     }

//     public void updateCarInfo(CarDTO car, int carIndex) {
//         int index = 0;
//         if(carIndex >=0 && carIndex < carList.size()) {
//             carList.set(carIndex, car);
//             System.out.println("As infos do veiculo de chave " + carIndex + " foram atualizadas para: " + carList.get(carIndex));
//         } else {
//             System.out.println("A chave informada nao consta na lista!");
//         }
//     }

//     public void printCarsInStore () {
//         for (int i = 0; i < carList.size(); i++) {
//             CarDTO car = carList.get(i);
//             if(car.isInStore()) {
//                 System.out.println( "Chave: " + i +
//                 ", Modelo: " + car.getModel() +
//                 ", Marca: " + car.getBrand() +
//                 ", Chassi: " + car.getChassis() +
//                 ", Ano de Fabricação: " + car.getManufactureYear() +
//                 ", Valor de Venda: " + car.getSaleValue() +
//                 ", Valor de Compra: " + car.getPurchaseValue()
//                 );
//             }
//         }
//     }

//     public void printCarsOutStore () {
//         for (int i = 0; i < carList.size(); i++) {
//             CarDTO car = carList.get(i);
//             if(!car.isInStore()) {
//                 System.out.println( "Chave: " + i +
//                 ", Modelo: " + car.getModel() +
//                 ", Marca: " + car.getBrand() +
//                 ", Chassi: " + car.getChassis() +
//                 ", Ano de Fabricação: " + car.getManufactureYear() +
//                 ", Valor de Venda: " + car.getSaleValue() +
//                 ", Valor de Compra: " + car.getPurchaseValue()
//                 );
//             }
//         }
//     }

//     public void printStore () {
//         for (int i = 0; i < carList.size(); i++) {
//             CarDTO car = carList.get(i); 
//             System.out.println( "Chave: " + i +
//             ", Modelo: " + car.getModel() +
//             ", Marca: " + car.getBrand() +
//             ", Chassi: " + car.getChassis() +
//             ", Ano de Fabricação: " + car.getManufactureYear() +
//             ", Valor de Venda: " + car.getSaleValue() +
//             ", Valor de Compra: " + car.getPurchaseValue()
//             );
//         }
//     }

//     public List<CarDTO> getCarList() {
//         return carList;
//     }

//     public void setCarList(List<CarDTO> carList) {
//         this.carList = carList;
//     }

//     public List<Spending> getSpendingList() {
//         return spendingList;
//     }

//     public void setSpendingList(List<Spending> spendingList) {
//         this.spendingList = spendingList;
//     }

    

// }
