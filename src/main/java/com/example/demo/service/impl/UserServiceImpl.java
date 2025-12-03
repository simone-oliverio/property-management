package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);

        userDTO = userConverter.convertEntityToDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {

        UserDTO userDTO = null;
        Optional<UserEntity> userEntityOptional = userRepository.findByOwnerEmailAndPassword(email,password);

        if(userEntityOptional.isPresent()) {
            userDTO = userConverter.convertEntityToDTO(userEntityOptional.get());
        }

        return userDTO;
    }
}
