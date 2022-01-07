package com.asaavedras.usuarios.services;

import com.asaavedras.usuarios.entities.Phone;
import com.asaavedras.usuarios.entities.User;
import com.asaavedras.usuarios.models.request.UserCreateRequestDto;
import com.asaavedras.usuarios.models.responses.PhoneResponseDto;
import com.asaavedras.usuarios.models.responses.UserResponseDto;
import com.asaavedras.usuarios.repositories.UserRepository;
import com.asaavedras.usuarios.security.JWTGeneratorToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {
        User user = new User();
        UserResponseDto userResponseDto = new UserResponseDto();

        List<Phone> phones = new ArrayList<>();
        BeanUtils.copyProperties(userCreateRequestDto,user);
        if(user != null) {
            if(userCreateRequestDto.getPhones().size()>0){
                for (PhoneResponseDto phoneResponseDto: userCreateRequestDto.getPhones()){
                    Phone phone = new Phone();
                    BeanUtils.copyProperties(phoneResponseDto,phone);
                    phone.setUser(user);
                    phones.add(phone);
                }
            }
        }
        user.setPhones(phones);
        user.setCreated(new Date());
        user.setModified(new Date());
        user.setToken(JWTGeneratorToken.generarJWTToken(user.getEmail()));
        user.setLast_login(new Date());
        user.setActive(true);
        User userSave = userRepository.save(user);
        BeanUtils.copyProperties(userSave,userResponseDto);
        userResponseDto.setPhones(convertPhoneAPhoneResponseDto(userSave.getPhones()));
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        for (User user: users ) {
            UserResponseDto target= new UserResponseDto();
            BeanUtils.copyProperties(user , target);
            target.setPhones(convertPhoneAPhoneResponseDto(user.getPhones()));
            userResponseDtos.add(target);
        }
        return userResponseDtos;
    }

    private List<PhoneResponseDto> convertPhoneAPhoneResponseDto(List<Phone> phones){
        List<PhoneResponseDto> phoneResponseDtos = new ArrayList<>();
        if(phones.size()>0){
            for (Phone phone: phones){
                PhoneResponseDto phoneResponseDto = new PhoneResponseDto();
                BeanUtils.copyProperties(phone,phoneResponseDto);
                phoneResponseDtos.add(phoneResponseDto);
            }
        }
        return  phoneResponseDtos;
    }
}
