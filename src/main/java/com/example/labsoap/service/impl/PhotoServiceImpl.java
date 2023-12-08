package com.example.labsoap.service.impl;

import com.example.labsoap.model.Photo;
import com.example.labsoap.repository.PhotoRepository;
import com.example.labsoap.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;


    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<Photo> getAllPhotoes(){
        return photoRepository.findAll();
    }

    public Photo getPhotoById(Long id){
        return photoRepository.getReferenceById(id);
    }

    public void savePhoto(Photo photo){
        photoRepository.save(photo);
    }

    public boolean deletePhotoById(Long id){
        try{
            photoRepository.deleteById(id);
            return true;
         }catch(Exception e){
            return false;
        }
    }

    public boolean updateInfoAboutPhoto(Long id, Photo updatedPhoto){
        Optional<Photo> existingPhoto = photoRepository.findById(id);

        if (existingPhoto.isPresent()) {
            Photo photoToUpdate = existingPhoto.get();
            photoToUpdate.setLink(updatedPhoto.getLink());
            photoRepository.save(photoToUpdate);
            return true;
        } else {
            return false;
        }
    }
}
