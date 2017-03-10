package services;

import Dao.HelloDao;
import Dao.HelloDaoImpl;

/**
 * Created by acangou on 21/11/16.
 */
public class HelloServiceImpl implements HelloService {

    HelloDao helloDao = new HelloDaoImpl();

    public String sayhello(String login){
        helloDao.persisitLogin(login);
        return "hello "+ login;
    }
}
