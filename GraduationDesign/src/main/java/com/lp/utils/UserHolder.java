package com.lp.utils;

import com.lp.dto.UserDTO;

public class UserHolder {
    public static final ThreadLocal<UserDTO> tl = new ThreadLocal<UserDTO>();

    public void saveUser(UserDTO userDTO){
        tl.set(userDTO);
    }

    public UserDTO getUser(){
        return tl.get();
    }

    public void removeUser(){
        tl.remove();
    }
}
