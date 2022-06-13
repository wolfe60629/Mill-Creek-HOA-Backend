package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.BoardMemberDto;
import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.data.EventDto;
import com.example.millcreekhoa.entity.BoardMemberEntity;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.service.BoardMemberService;
import com.example.millcreekhoa.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class BoardMemberController {

    @Autowired
    BoardMemberService boardMemberService;

   @PostMapping(value = "/boardMembers/new")
    public BoardMemberEntity addNewBoardMember(@RequestBody BoardMemberDto boardMemberDto) {
      return boardMemberService.addNewBoardMember(boardMemberDto);
   }

   @GetMapping(value = "/boardMembers")
    public List<BoardMemberEntity> getAllBoardMembers() {
       return boardMemberService.getAllBoardMembers();
   }

    @PostMapping(value = "/boardMembers/delete")
    public boolean deleteBoardMember(@RequestBody BoardMemberDto boardMemberDto) {
        return boardMemberService.deleteBoardMember(boardMemberDto);
    }

}
