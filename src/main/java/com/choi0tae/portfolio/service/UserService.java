package com.choi0tae.portfolio.service;


import com.choi0tae.portfolio.entity.User;
import com.choi0tae.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
