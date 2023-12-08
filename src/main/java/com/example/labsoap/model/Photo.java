package com.example.labsoap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo {
    @Id
    @Column(name = "photo_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;
    private String link;
}
