package service.impl;

import db.DataBase;
import exception.MyException;
import model.Person;
import service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private DataBase dataBase;

    public PersonServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void savePerson(Person person) {
        dataBase.getPeople().add(person);
        System.out.println(dataBase.getPeople());
    }

    @Override
    public List<Person> getAllPerson() {
        return dataBase.getPeople();
    }

    @Override
    public Person getPersonByName(String name) {
        try {
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getFirstName().equalsIgnoreCase(name)) {
                    return dataBase.getPeople().get(i);
                } else throw new MyException("Not found Person");
            }
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }

        return null;
    }

    @Override
    public Person updatePersonById(Long id, String newFirstName, String newLastName, int age, String email) {
        Person updatedPerson = null;
        boolean isFound= false;
        try {
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getId().equals(id)) {
                    dataBase.getPeople().get(i).setFirstName(newFirstName);
                    dataBase.getPeople().get(i).setLastName(newLastName);
                    dataBase.getPeople().get(i).setAge(age);
                    dataBase.getPeople().get(i).setEmail(email);
                    updatedPerson = dataBase.getPeople().get(i);
                    isFound=true;
                }if (!isFound){
                    throw new MyException("Not found Id");
                }

            }
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
        return updatedPerson;
    }

    @Override
    public String deletePersonById(Long id) {
        try {
            boolean isFound= false;
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getId().equals(id)) {
                    dataBase.getPeople().remove(i);
                    isFound=true;
                    break;
                }
                }
            if (!isFound){
                throw new MyException("Not found Person ID");
            }

        }catch (MyException myException){
            System.out.println(myException.getMessage());
        }
        return "Person successfully deleted!";
    }
}
