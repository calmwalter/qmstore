package qmstore.user.condition;

import lombok.Data;

@Data
public class LoginCondition {

    private String userId;

    private String password;
}
