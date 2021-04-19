package keystone.qtaeq.controller;

import keystone.qtaeq.domain.Dto.MemberDto;
import keystone.qtaeq.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String main() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "/members/login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/members/admin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/members/signup";
    }

    @GetMapping("/info")
    public String info() {
        return "/members/myInfo";
    }

    @PostMapping("/signup")
    public String signup(MemberDto memberDto) { // 회원 추가

        memberService.save(memberDto);
        return "redirect:/login";
    }
    // 추가
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}