package com.example.labsoap.controller;

import com.example.labsoap.model.Photo;
import com.example.labsoap.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/getAll")
    public List<Photo> getAllPhotos() {
       return photoService.getAllPhotoes();
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePhoto(@RequestBody Photo newPhoto) {
     try{
        photoService.savePhoto(newPhoto);
        return ResponseEntity.ok("Фото успешно сохранено");
     } catch (Exception e){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Невозможно сохранить фото");
     }
    }

    @DeleteMapping("/deletePhotoById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBookId(@PathVariable Long id) {
        if (photoService.deletePhotoById(id)) {
            return ResponseEntity.ok("Фото успешно удалено");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Фото с ID " + id + " не найдено");
        }
    }

    @PutMapping("/updatePhotoInfo/{id}")
    public ResponseEntity<String> updatePhotoById(@PathVariable Long id, @RequestBody Photo updatedPhoto) {
        if (photoService.updateInfoAboutPhoto(id, updatedPhoto)) {
            return ResponseEntity.ok("Информация о фото успешно обновлена");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Фото с ID " + id + " не найдена");
        }
    }
}
