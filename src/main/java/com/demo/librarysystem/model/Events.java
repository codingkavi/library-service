package com.demo.librarysystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Events {

    @Id
    @GeneratedValue
    private int eventId;
    private String eventTitle;
    private String location;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "date_created")
    private String date;
  /*  @Temporal(TemporalType.DATE)
    private Date time = new Date(System.currentTimeMillis());*/
    private String time;
    private String noofEvents;
    private String eventDescription;
    private String audience;
    private String eventType;
    private String program;
    private String language;
}
