package com.millcreek.backend.entity;

import com.millcreek.backend.data.BoardMemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board_member")
public class BoardMemberEntity {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="name", nullable = false)
    String name;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "title", nullable=false)
    String title;

    public BoardMemberEntity(String name, String email, String title) {
        this.name = name;
        this.email = email;
        this.title = title;
    }

    public BoardMemberEntity(BoardMemberDto boardMemberDto) {
        this.id = boardMemberDto.getId();
        this.name = boardMemberDto.getName();
        this.email = boardMemberDto.getEmail();
        this.title = boardMemberDto.getTitle();
    }
}

