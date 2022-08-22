package api.practice.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoginRepository {

    private final MemberRepository memberRepository;

    public Member login(String id, String pw) {
        return memberRepository.findById(id)
                .filter(m -> m.getPw().equals(pw))
                .orElse(null);
    }
}
