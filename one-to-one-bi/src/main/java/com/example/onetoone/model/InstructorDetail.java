package com.example.onetoone.model;

import javax.persistence.*;

@Entity
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="youtubeChannel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    //burada ekledim bi için
    @OneToOne(mappedBy = "instructorDetail" , cascade = {CascadeType.DETACH,CascadeType.MERGE,//InstructorDetail silindiğinde instructor silinmesin diye remove hariç hepsi
            CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
