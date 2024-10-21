package edu.icet.hotelBookingSystem.service.impl;


import edu.icet.hotelBookingSystem.entity.UserEntity;
import edu.icet.hotelBookingSystem.model.User;
import edu.icet.hotelBookingSystem.model.UserLog;
import edu.icet.hotelBookingSystem.repository.UserRepository;
import edu.icet.hotelBookingSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;


    @Override
    public void saveUser(User user) {

        UserEntity userEntity=new UserEntity();

        userEntity.setUserEmail(user.getUserEmail());
        userEntity.setUserPassword(user.getUserPassword());
        userEntity.setUserName(user.getUserName());
        userEntity.setUserContactNumber(user.getUserContactNumber());

        userRepository.save(userEntity);



    }

    @Override
    public long checkUser(UserLog userLog) {

        List<UserEntity> byUserEmail = userRepository.findByUserEmail(userLog.getUserEmail());

        for(UserEntity user:byUserEmail){

            if(user.getUserPassword().equals(userLog.getUserPassword())){

                return user.getUserId();
            }

        }



        return 0;
    }
}
