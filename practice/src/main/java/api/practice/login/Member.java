package api.practice.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
public class Member {

    private UUID Bid = UUID.randomUUID();

    private String id = Bid.toString();

    @NotEmpty
    private String logId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String pw;
}
