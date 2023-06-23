package db;

import model.Car;
import model.Person;
import model.SocialMedia;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Person>people= new ArrayList<>();
    private List<Car>cars= new ArrayList<>();
    private List<SocialMedia>socialMedia= new ArrayList<>();

    public DataBase(List<Person> people, List<Car> cars, List<SocialMedia> socialMedia) {
        this.people = people;
        this.cars = cars;
        this.socialMedia = socialMedia;
    }

    public DataBase() {
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<SocialMedia> getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(List<SocialMedia> socialMedia) {
        this.socialMedia = socialMedia;
    }
}
