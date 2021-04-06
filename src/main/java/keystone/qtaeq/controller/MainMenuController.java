package keystone.qtaeq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainMenuController {
    // Mapping -> templates/home.html
    @GetMapping("/")
    public String home(){
        return "home";
    }

    // Mapping -> templates/about.html
    @GetMapping("about") // 주소창에 /about 으로 접근시
    public String about(@RequestParam(value = "name", required = false) String name, Model model){
        if(name == null) name = "No Name";  // name 값이 없을시 기본값 설정
        model.addAttribute("name", name);
        return "about"; // about.html 출력
    }

    // Mapping -> templates/board.html
    @GetMapping("board")
    public String board() {
        return "board";
    }
}
