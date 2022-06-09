package com.example.millcreekhoa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "newsletter")
public class NewsletterEntity {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String name;

    @Column(name="friendly_name")
    String friendlyName;

    @Column(name = "description")
    String description;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "item", columnDefinition = "TEXT", nullable = false)
    String item;

    @Column(name="category")
    String category;

    @Column(name = "crt_ts", columnDefinition = "TIMESTAMP", nullable = false)
    private Date crt_ts;

    public NewsletterEntity(String name, String friendlyName, String description, String category, String item) {
        this.name = name;
        this.friendlyName = friendlyName;
        this.description = description;
        this.category = category;
        this.item = item;
        this.crt_ts = new Date();
    }
}

