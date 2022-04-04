package com.example.millcreekhoa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.common.util.StringHelper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "request")
public class RequestDocumentEntity {
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

    @Column(name = "editable_columns",  length = 5000)
    String editableColumns;

    public RequestDocumentEntity(String name, String friendlyName, String description, String category, String item, String editableColumns) {
        this.name = name;
        this.friendlyName = friendlyName;
        this.description = description;
        this.category = category;
        this.item = item;
        this.editableColumns = editableColumns;
    }
}

