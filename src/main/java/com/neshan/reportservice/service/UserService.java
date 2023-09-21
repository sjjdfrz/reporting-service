package com.neshan.reportservice.service;

import com.neshan.reportservice.mapper.UserMapper;
import com.neshan.reportservice.model.ApiResponse;
import com.neshan.reportservice.model.dto.RegisterRequest;
import com.neshan.reportservice.model.dto.UserDto;
import com.neshan.reportservice.model.dto.UsersDto;
import com.neshan.reportservice.model.entity.User;
import com.neshan.reportservice.repository.UserRepository;
import com.neshan.reportservice.util.PaginationSorting;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public List<UsersDto> getAllUsers(int pageNo, int pageSize, String sortBy) {

        List<Sort.Order> orders = PaginationSorting.getOrders(sortBy);
        Pageable paging = PaginationSorting.getPaging(pageNo, pageSize, orders);

        return userRepository
                .findAll(paging)
                .map(user -> userMapper.userToUsersDto(user))
                .getContent();
    }

    @Transactional
    public UserDto getUser(long id) {
        return userRepository.findUserById(id);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public ApiResponse<Object> updateMe(
            RegisterRequest updateRequest,
            User user) {

        if (!updateRequest.password().isBlank())
            user.setPassword(passwordEncoder.encode(updateRequest.password()));

        userMapper.updateUserFromDto(updateRequest, user);
        userRepository.save(user);

        return ApiResponse
                .builder()
                .status("success")
                .message("Your profile was updated successfully.")
                .build();
    }

    @Transactional
    public ApiResponse<Object> deleteMe(User user) {

        user.setDeleted(true);
        userRepository.save(user);

        return ApiResponse
                .builder()
                .status("success")
                .build();
    }

    @Transactional
    public ApiResponse<UsersDto> getMe(User user) {

        UsersDto usersDto = userMapper.userToUsersDto(user);

        return ApiResponse
                .<UsersDto>builder()
                .status("success")
                .data(usersDto)
                .build();
    }
}
