package com.example.millcreekhoa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;


import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "document")
public class DocumentEntity {
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

    public DocumentEntity(String name, String friendlyName, String description, String category, String item) {
        this.name = name;
        this.friendlyName = friendlyName;
        this.description = description;
        this.category = category;
        this.item = item;
    }
}

