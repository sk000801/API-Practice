package api.practice.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginRepository loginRepository;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult b, HttpServletResponse response) {
        //bindingResult는 검증 오류가 발생할 경우 오류 내용을 보관
        if(b.hasErrors()) {
            return "login/loginForm";
        }

        Member logMember = loginRepository.login(form.getId(), form.getPw());

        if(logMember == null) {
            b.reject("loginFail", "아이디 또는 비밀번호가 틀렸습니다");
            return "login/loginForm";
        }

        //브라우저를 종료할 경우 로그아웃되도록 하는
        Cookie idCookie = new Cookie("mId", String.valueOf(logMember.getId()));
        response.addCookie(idCookie);

        return "redirect:/";
     }
}
