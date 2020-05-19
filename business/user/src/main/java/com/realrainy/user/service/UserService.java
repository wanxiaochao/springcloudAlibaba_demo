package com.realrainy.user.service;

import com.realrainy.user.entity.WpUser;

import java.util.List;

public interface UserService {

    List<WpUser> findUser();

    List<WpUser> findUserByIdIn(List<String>ids);

}
