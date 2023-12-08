package com.example.labsoap.service;

import com.example.labsoap.model.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> getAllPhotoes();
    Photo getPhotoById(Long id);
    void savePhoto(Photo photo);
    boolean deletePhotoById(Long id);
    boolean updateInfoAboutPhoto(Long id, Photo updatedPhoto);
}
