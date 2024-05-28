package ru.romanov.tests.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String text;

    @OneToMany(mappedBy = "lecture")
    private List<ImageData> imageList;

    public void addImage(ImageData imageData){
        this.imageList.add(imageData);
        imageData.setLecture(this);
    }
}
