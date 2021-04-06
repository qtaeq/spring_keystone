package keystone.qtaeq.controller;

import keystone.qtaeq.controller.Form.BoardForm;
import keystone.qtaeq.domain.Board;
import keystone.qtaeq.service.BoardService;
import keystone.qtaeq.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/boards/new")
    public String createForm(){
        return "boards/createBoardForm";
    }

    @PostMapping("/boards/new")
    public String create(BoardForm form){
        Board board = new Board();

        board.setTitle(form.getTitle());
        board.setBody(form.getBody());
        board.setDate(Timestamp.valueOf(LocalDateTime.now()));

        System.out.println(board.getDate());

        boardService.create(board);

        return "redirect:/board";
    }

    @GetMapping("boards/list")
    public String list(Model model){
        List<Board> boards = boardService.allList();
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }

    @GetMapping("boards/list/{no}")
    public String viewDetail(@PathVariable("no") Long id, Model model){
        Board board = boardService.viewDetail(id);
        System.out.println("id : " + board.get_id() + "title : " + board.getTitle());
        model.addAttribute("board",board);
        return "boards/boardDetail";
    }

}
