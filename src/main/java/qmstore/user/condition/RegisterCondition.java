package qmstore.user.condition;

import lombok.Data;

@Data
public class RegisterCondition {
    private String userId;
    private String userName;
    private String firstPassword;
    private String secondPassword;
    private String phone;
    private String email;
    private String userGroup;
}
