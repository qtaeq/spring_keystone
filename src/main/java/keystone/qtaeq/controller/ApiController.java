package keystone.qtaeq.controller;

import keystone.qtaeq.domain.Entity.BoardEntity;
import keystone.qtaeq.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class ApiController {

    /*
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    private List<BoardEntity> viewDetail(@PathVariable("no") Long id){
        BoardEntity boardEntity = boardService.viewDetail(id);
        List<BoardEntity> Data = new ArrayList<>();
        Data.add(boardEntity);
        System.out.print(Data);
        return Data;
    }

     */

}
