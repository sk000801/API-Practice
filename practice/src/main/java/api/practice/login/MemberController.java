package api.practice.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String joinMember(@ModelAttribute("member") Member member) {
        return "/members/addMember";
    }

    @PostMapping("/add")
    public String joinMember2(@Valid @ModelAttribute Member member, BindingResult b) {
        if(b.hasErrors()) {
            return "/members/addMember";
        }

        memberRepository.save(member);
        return "redirect:/";
    }
}
