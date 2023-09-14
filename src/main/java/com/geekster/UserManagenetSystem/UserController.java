package com.geekster.UserManagenetSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    List<User> UserList;
    //addinguser
    @PostMapping("User")
    public String addUser(@RequestBody User newUser)
    {
        UserList.add(newUser);
        return "User Added";
    }
    //get allusers
    @GetMapping("AllUsers")
    public List<User> getAllUser()
    {
        return UserList;
    }
    //update user info
    @PutMapping("update/id/{id}/username")
    public String setusernamebyid(@PathVariable Integer id, @RequestParam String value)
    {
        for(User user:UserList)
        {
            if(user.getUserId().equals(id))
            {
                user.setUserName(value);
                {
                    return  "username:"   + id +  "updated to"  +  value;
                }
            }

        }
        return "invalid user id";
    }
    //updating user information
    @PutMapping("update/id/{id}/useraddress")
    public String setuserAddressbyid(@PathVariable Integer id, @RequestParam String value)
    {
        for(User user:UserList)
        {
            if(user.getUserId().equals(id))
            {
                user.setAddress(value);
                {
                    return  "user address:"   + id +  "updated to"  +  value;
                }
            }

        }
        return "invalid user id";
    }



    //delete user
    @DeleteMapping("delete/id/{id}")
    public String removeUserById(@PathVariable Integer id)
    {
        for(User user : UserList)
        {
            if(user.getUserId().equals(id))
            {
                UserList.remove(user);
                return "user: "   + id  + " deleted";
            }
        }

        return "Invalid id";
    }


}
