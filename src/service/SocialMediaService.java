package service;

import model.SocialMedia;

import java.util.List;

public interface SocialMediaService {
    void assignSociaMediaToPerson(Long id,SocialMedia socialMedia);
    String saveSocialMedia(SocialMedia socialMedia);
    SocialMedia getSocialMediaById(Long id);
    List<SocialMedia>getAllSocialMediaByPersonId(Long id);
    void deleteAllAllSocialMediaByPersonId(Long id);
    void deleteSocialMediaByID(Long id);

}
