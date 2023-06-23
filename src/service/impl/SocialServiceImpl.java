package service.impl;

import db.DataBase;
import exception.MyException;
import model.Person;
import model.SocialMedia;
import service.SocialMediaService;

import java.util.List;

public class SocialServiceImpl implements SocialMediaService {
    private DataBase dataBase;


    public SocialServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void assignSociaMediaToPerson(Long id, SocialMedia socialMedia) {
        try {
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getId().equals(id)) {
                    dataBase.getPeople().get(i).getSocialMedia().add(socialMedia);
                    System.out.println("Successfully assigned");
                } else {
                    throw new MyException("Not found Person Id");
                }
            }

        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
    }

    @Override
    public String saveSocialMedia(SocialMedia socialMedia) {
        for (Person s : dataBase.getPeople()) {
            s.getSocialMedia().add(socialMedia);
            System.out.println(s.getSocialMedia());
        }
        return "successfully saved";
    }

    @Override
    public SocialMedia getSocialMediaById(Long id) {
        try {
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getSocialMedia().get(i).getId().equals(id)) {
                    return dataBase.getPeople().get(i).getSocialMedia().get(i);
                }

            }
            throw new MyException("Not found id");
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }

        return null;
    }

    @Override
    public List<SocialMedia> getAllSocialMediaByPersonId(Long id) {
        try {
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getId().equals(id)) {
                    return dataBase.getPeople().get(i).getSocialMedia();
                } else {
                    throw new MyException("Not found person id");
                }
            }
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }

        return null;
    }

    @Override
    public void deleteAllAllSocialMediaByPersonId(Long id) {
        try {
            boolean isFpund=false;
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getId().equals(id)) {
                    dataBase.getPeople().get(i).getSocialMedia().removeAll(dataBase.getPeople().get(i).getSocialMedia());
                    isFpund=true;
                    break;
                } if (!isFpund){
                    throw new MyException("Not found id");
                }
            }
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }

        System.out.println("Successfully deleted");

    }

    @Override
    public void deleteSocialMediaByID(Long id) {
        try {
            boolean isFound=false;
            for (int i = 0; i < dataBase.getPeople().size(); i++) {
                if (dataBase.getPeople().get(i).getSocialMedia().get(i).getId().equals(id)) {
                    dataBase.getPeople().get(i).getSocialMedia().remove(i);
                    System.out.println("Succesfully deleted!");
                    isFound=true;
                    break;
                }if (!isFound){
                    throw new MyException("Not found SocialMedia ID");
                }

            }


        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }

    }
}
