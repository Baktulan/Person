package service.impl;

import db.DataBase;
import exception.MyException;
import model.Car;
import model.Person;
import service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private DataBase dataBase;


    public CarServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void saveCarToPerson(Car car, Long id) {
        for (Person p : dataBase.getPeople()) {
            if (p.getId().equals(id)) {
                p.getCars().add(car);
            }
        }
        System.out.println("Car successfully saved to "+ id+" 'id's Person");
    }

    @Override
    public List<Car> getCarByPersonId(Long id) {
        try {
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getId().equals(id)) {
                    return dataBase.getPeople().get(i).getCars();
                } else {
                    throw new MyException("Not found Person Id");
                }
            }
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return null;
    }

    @Override
    public Car getCarById(Long id) {
        try {
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getCars().get(i).getId().equals(id)) {
                    return dataBase.getPeople().get(i).getCars().get(i);
                } else {
                    throw new MyException("Not found Car Id");
                }
            }

        }catch (MyException myException){
            System.out.println(myException.getMessage());
        }
        return null;
    }

    @Override
    public void updateCarById(Long id, String newName, int newyear) {
        try{
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                for (int j = 0; j <dataBase.getPeople().get(i).getCars().size() ; j++) {
                    if (dataBase.getPeople().get(i).getCars().get(j).getId().equals(id)) {
                        dataBase.getPeople().get(i).getCars().get(j).setName(newName);
                        dataBase.getPeople().get(i).getCars().get(j).setYear(newyear);
                        System.out.println(dataBase.getPeople().get(i).getCars().get(j));
                        ;
                    } else {
                        throw new MyException("Not found Id");
                    }
                }
            }
        }catch (MyException myException){
            System.out.println(myException.getMessage());
        }


    }

    @Override
    public String deleteCarById(Long id) {
        try{
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                for (int j = 0; j < dataBase.getPeople().get(i).getCars().size(); j++) {
                    if (dataBase.getPeople().get(i).getCars().get(j).getId().equals(id)) {
                        dataBase.getPeople().get(i).getCars().remove(j);
                    } else {
                        throw new MyException("Not found Id");
                    }
                }
            }
        }catch (MyException myException){
            System.out.println(myException.getMessage());
        }

        return "Successfully deleted!" ;
    }
}
