package ru.netology.SpringBootRESTAuthorization;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public  AuthorizationService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<Authorities> getAuthorities(String user, String password)  {
        if (isEmpty(user) || isEmpty(password)) {
            throw new IllegalArgumentException("User name or password is empty");
            //throw new InvalidCredentials();

        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser();
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}