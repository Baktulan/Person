package service;

import model.Car;

import java.util.List;

public interface CarService {
    void saveCarToPerson(Car car,Long id);
    List<Car>getCarByPersonId(Long id);
    Car getCarById(Long id);
    void updateCarById(Long id,String newName, int newyear);
    String deleteCarById(Long id);


}
