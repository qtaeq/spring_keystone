package keystone.qtaeq.controller;

import keystone.qtaeq.domain.Dto.BoardDto;
import keystone.qtaeq.domain.Entity.BoardEntity;
import keystone.qtaeq.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/board/new")
    public String createForm(){
        return "boards/createBoardForm";
    }

    @PostMapping("/board/new")
    public String create(BoardDto form){
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setTitle(form.getTitle());
        boardEntity.setBody(form.getBody());
        boardEntity.setDate(Timestamp.valueOf(LocalDateTime.now()));

        boardService.create(boardEntity);

        return "redirect:/board";
    }

    @GetMapping("board")
    public String list(Model model){
        List<BoardEntity> boardEntities = boardService.allList();
        model.addAttribute("boards", boardEntities);
        return "boards/boardList";
    }

    @GetMapping("board/{no}")
    public String viewDetail(@PathVariable("no") Long id, Model model){
        BoardEntity boardEntity = boardService.viewDetail(id);

        model.addAttribute("board", boardEntity);
        return "boards/boardDetail";
    }

    @GetMapping("/api/board/{no}")
    public String viewDetail(@PathVariable("no") Long id){
        BoardEntity boardEntity = boardService.viewDetail(id);
        return boardEntity.getBody();
    }

}
