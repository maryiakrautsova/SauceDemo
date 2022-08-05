package testdata;

import models.LoginModel;

public class PrepareLoginData {
    public static LoginModel getStandardLogin() {
        return LoginModel.
                builder().
                username("standard_user").
                password("secret_sauce").
                build();
    }

    public static LoginModel getLockedOutLogin() {
        return LoginModel.
                builder().
                username("locked_out_user").
                password("secret_sauce").
                build();
    }

    public static LoginModel getProblemLogin() {
        return LoginModel.
                builder().
                username("problem_user").
                password("secret_sauce").
                build();
    }

    public static LoginModel getPerformanceGlitchLogin() {
        return LoginModel.
                builder().
                username("performance_glitch_user").
                password("secret_sauce").
                build();
    }
}
