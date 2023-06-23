import db.DataBase;
import model.Car;
import model.Person;
import model.SocialMedia;
import service.impl.CarServiceImpl;
import service.impl.PersonServiceImpl;
import service.impl.SocialServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DataBase dataBase= new DataBase();
        PersonServiceImpl personService= new PersonServiceImpl(dataBase);
        CarServiceImpl carService= new CarServiceImpl(dataBase);
        SocialServiceImpl socialService= new SocialServiceImpl(dataBase);

        Car audi= new Car(1L,"Audi",2019);
        Car mersedes= new Car(2L,"Mersedes-Benz",2021);
        Car bmw= new Car(3L,"BMW",2020);
        Car toyota= new Car(4L,"Toyota",2023);
        Car honda= new Car(5L,"Honda",2018);

        List<Car>cars= new ArrayList<>();
        cars.add(audi);
        cars.add(mersedes);
        cars.add(bmw);
        cars.add(toyota);
        List<Car>cars1= new ArrayList<>();
        cars1.add(audi);
        List<Car>cars2= new ArrayList<>();
        cars2.add(mersedes);
        List<Car>cars3= new ArrayList<>();
        cars3.add(toyota);
        List<Car>cars4= new ArrayList<>();
        cars2.add(bmw);


        SocialMedia instagramm = new SocialMedia(10L,"Instagramm");
        SocialMedia telegramm = new SocialMedia(11L,"Telegramm");
        SocialMedia whatsapp = new SocialMedia(12L,"WhatsApp");
        SocialMedia twitter = new SocialMedia(13L,"Twitter");
        SocialMedia facebook= new SocialMedia(14L,"FaceBook");
        SocialMedia viber= new SocialMedia(15L,"Viber");

        List<SocialMedia>socialMedia=new ArrayList<>();
        socialMedia.add(instagramm);
        socialMedia.add(telegramm);


        List<SocialMedia>socialMedia1= new ArrayList<>();
        socialMedia1.add(viber);
        socialMedia1.add(whatsapp);
        socialMedia1.add(twitter);


        Person baktulan= new Person(1L,"Baktulan","Nazirbek uulu",23,"baku@mail.ru",new ArrayList<>(),new ArrayList<>());
        Person nurik= new Person(2L,"Nurik","Alymbai uulu",25,"nurik@mail.ru",new ArrayList<>(),new ArrayList<>());
        Person januzak= new Person(1L,"Januzak","Anashov",24,"baku@mail.ru",new ArrayList<>(),new ArrayList<>());
        Person asan= new Person(1L,"Asan","Asanov",27,"baku@mail.ru",new ArrayList<>(),new ArrayList<>());

        List<Person>people= new ArrayList<>();
        people.add(baktulan);
        people.add(nurik);
        people.add(januzak);
        people.add(asan);

        Scanner scanner= new Scanner(System.in);
        int num;
        while (true){
            System.out.println("""
                    1.Save person
                    2.Save person 2
                    3.Get all person
                    4.Get person by name
                    5.Update person by ID
                    6.Delete person ID
                    7. Assign social media to Person
                    8.Save social media
                    9.Get social media by id
                    10.Get all Social media by Person id
                    11.Delete social media by id
                    12.Delete social media by person id
                    13.Save car to person
                    14.Get car by person id
                    15.Get car by id
                    16.Update car by id
                    17.Delete car by id""");
            num=scanner.nextInt();
            switch (num){
                case 1:{
                    personService.savePerson(baktulan);
                    break;
                } case 2:{
                   personService.savePerson(nurik);
                   break;
                } case 3:{
                    System.out.println(personService.getAllPerson());
                    break;
                } case 4:{
                    System.out.println(personService.getPersonByName("Baktulan"));
                    break;
                } case 5:{
                    System.out.println(personService.updatePersonById(1L,"Asylbek","Asylbekov",25,"asyl@mail.ru"));
                    break;
                } case 6:{
                    System.out.println(personService.deletePersonById(2L));
                    break;
                } case 7:{
                    socialService.assignSociaMediaToPerson(1L,facebook);
                    break;
                } case 8:{
                    System.out.println(socialService.saveSocialMedia(viber));
                    break;
                } case 9:{
                    System.out.println(socialService.getSocialMediaById(12L));
                    break;
                } case 10:{
                    System.out.println(socialService.getAllSocialMediaByPersonId(1L));
                    break;
                } case 11:{
                    socialService.deleteSocialMediaByID(10L);
                    break;
                } case  12:{
                    socialService.deleteAllAllSocialMediaByPersonId(1L);
                    break;
                } case 13:{
                    carService.saveCarToPerson(honda,1L);
                    break;
                } case 14:{
                    System.out.println(carService.getCarByPersonId(1L));
                    break;
                } case 15:{
                    System.out.println(carService.getCarById(5L));
                    break;
                } case 16:{
                    carService.updateCarById(5L,"Audi",2013);
                    break;
                } case 17:{
                    System.out.println(carService.deleteCarById(5L));
                    break;
                }
            }
        }


    }
}