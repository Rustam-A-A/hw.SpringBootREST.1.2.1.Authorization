package ru.netology.SpringBootRESTAuthorization;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserRepository {
    private List<Authorities> userAuthorities = new ArrayList<>();

    private Map<String, String> userBase = new HashMap<>() {{
        put("John","qwerty");
        put("Helmut","asd");
        put("Max", "zxc");
        put("admin", "zxc");
    }};

    //localhost:8080/authorize?user=John&password=qwerty
    //localhost:8080/authorize?user=admin&password=zxc

    public List<Authorities> getUserAuthorities(String usersName, String password) {
        userAuthorities.clear();
        if (userBase.containsKey(usersName) && userBase.get(usersName).equals(password)) {
            userAuthorities.add(Authorities.READ);
            userAuthorities.add(Authorities.WRITE);
            if (usersName.equals("admin")){
                userAuthorities.add(Authorities.DELETE);
            }
        } else {
            userAuthorities.clear();
        }
        return userAuthorities;
    }
}

