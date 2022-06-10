package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.BoardMemberDto;
import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.entity.BoardMemberEntity;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.repo.BoardMemberRepository;
import com.example.millcreekhoa.repo.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardMemberService {

    @Autowired
    BoardMemberRepository boardMemberRepository;

    public List<BoardMemberEntity> getAllBoardMembers() {
        return boardMemberRepository.findAllByOrderByIdAsc();
    }

    public BoardMemberEntity getBoardMemberById(int id) {
        return boardMemberRepository.findAllById(id);
    }

    public BoardMemberEntity addNewBoardMember(BoardMemberDto boardMemberDto) {
            BoardMemberEntity entity = new BoardMemberEntity(boardMemberDto);
            return boardMemberRepository.save(entity);
        }

     public boolean deleteBoardMember(BoardMemberDto boardMemberDto) {
         // Make sure that ID is filled out
         if (boardMemberDto.getId() == 0) {
             return false;
         }

         // Get entity from id
         BoardMemberEntity entity = boardMemberRepository.findAllById(boardMemberDto.getId());

         if (entity == null) {
             return false;
         }

         boardMemberRepository.delete(entity);
         return true;
     }
    }

