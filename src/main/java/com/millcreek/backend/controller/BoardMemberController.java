package com.millcreek.backend.controller;

import com.millcreek.backend.entity.BoardMemberEntity;
import com.millcreek.backend.service.BoardMemberService;
import com.millcreek.backend.data.BoardMemberDto;
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
