package src.main.java.com.jhogo.irsystem.cars;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private CarDAO carDAO;

    public void carService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void addCar(CarDTO carDTO) throws SQLException {
        Car car = new Car();
        car.setModel(carDTO.getModel());
        car.setBrand(carDTO.getBrand());
        car.setChassis(carDTO.getChassis());
        car.setManufactureYear(carDTO.getManufactureYear());
        car.setSaleValue(carDTO.getSaleValue());
        car.setPurchaseValue(carDTO.getPurchaseValue());
        car.setInStore(carDTO.isInStore());
        carDAO.insertCar(car);
    }

    public List<CarDTO> getAllCars() throws SQLException {
        List<Car> cars = carDAO.getAllCars();
        return cars.stream().map(car -> {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(car.getId());
            carDTO.setModel(car.getModel());
            carDTO.setBrand(car.getBrand());
            carDTO.setChassis(car.getChassis());
            carDTO.setManufactureYear(car.getManufactureYear());
            carDTO.setSaleValue(car.getSaleValue());
            carDTO.setPurchaseValue(car.getPurchaseValue());
            carDTO.setInStore(car.isInStore());
            return carDTO;
        }).collect(Collectors.toList());
    }

    public void updateCar(CarDTO carDTO, int carId) throws SQLException {
        Car car = new Car();
        car.setId(carId);
        car.setModel(carDTO.getModel());
        car.setBrand(carDTO.getBrand());
        car.setChassis(carDTO.getChassis());
        car.setManufactureYear(carDTO.getManufactureYear());
        car.setSaleValue(carDTO.getSaleValue());
        car.setPurchaseValue(carDTO.getPurchaseValue());
        car.setInStore(carDTO.isInStore());
        carDAO.updateCar(car);
    }

    public void removeCarFromStore(int carId) throws SQLException {
        carDAO.deleteCar(carId);
    }
}
