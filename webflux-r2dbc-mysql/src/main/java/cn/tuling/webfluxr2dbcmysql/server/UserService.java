package cn.tuling.webfluxr2dbcmysql.server;

import cn.tuling.webfluxr2dbcmysql.dao.UserDao;
import cn.tuling.webfluxr2dbcmysql.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public  Mono<User> addUser(User user){
        Mono<User> save = userDao.save(user);
        return save;
    }



    public Mono<Void> deleteUser(Integer userId){

       return userDao.existsById(userId).flatMap(item->{
            if (item){
                return userDao.deleteById(userId);
            }
            return Mono.empty();
        });
    }

    public Mono<User>  updateUser(User user){
        return userDao.existsById(user.getId()).flatMap(item->{
            if (item){
                return  userDao.save(user);
            }
            return Mono.just(user);
        });

    }

    public Mono<User> getUserById(Integer userId){
     return userDao.findById(userId).switchIfEmpty(Mono.just(new User()));
    }






}
