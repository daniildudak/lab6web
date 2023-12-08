package com.example.labsoap;

import com.example.labsoap.controller.PhotoController;
import com.example.labsoap.model.Photo;
import com.example.labsoap.service.PhotoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class YourControllerTests {

    @InjectMocks
    private PhotoController yourController;

    @Mock
    private PhotoService photoService;

    @Test
    public void testGetAllPhotos() {
        // Mock the behavior of the photoService
        when(photoService.getAllPhotoes()).thenReturn(Arrays.asList(new Photo(), new Photo()));

        // Call the controller method
        List<Photo> result = yourController.getAllPhotos();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    public void testSavePhoto_Success() {
        // Mock the behavior of the photoService
        doNothing().when(photoService).savePhoto(any(Photo.class));

        // Call the controller method
        ResponseEntity<String> result = yourController.savePhoto(new Photo());

        // Assert the result
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Фото успешно сохранено", result.getBody());
    }

    @Test
    public void testSavePhoto_Failure() {
        // Mock the behavior of the photoService to throw an exception
        doThrow(new RuntimeException("Some error")).when(photoService).savePhoto(any(Photo.class));

        // Call the controller method
        ResponseEntity<String> result = yourController.savePhoto(new Photo());

        // Assert the result
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Невозможно сохранить фото", result.getBody());
    }

    // Similar tests for deleteBookId and updatePhotoById can be implemented
}

