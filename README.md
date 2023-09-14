# <h1 align ="center">USER MANAGEMENT SYSTEM</h1>
***
### overview
***
The project "user management system" is a robust SpringBoot Application designed for managing users data efficiently.it provides a set of REST full API endpoints that allows you to perform variose  operations on users 
records,such as adding ,retrieving,updating ,and deteting user information.
### Technologies used
***
* Framework:Spring Boot
* Language:java
* Build Tool:Maven
  ### Controll Flow
  ***
  #### Controller
  The controller  layer is responsible for handling incomming Http request and delegating them to the appropriate Services.
  It defines API  endpoints for thev following operations.
 * Add user: `POST/User`
 * Add Users: `POST/Users`
 * Get All Users: `GET/AllUsers`
 * Get User by ID: `GET/User/{UserId}`
 * Update User name: `PUT/update/id/{id}/username`
 * Update user Address: `PUT/update/id/{id}/useraddress`
 * Delete user by Id: `DELETE/delete/id/{id}`
 ``` java
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
```
### Repository
The repository level manages data access to the underlying database.
it handles Read,Delete,Update,Create (CRUD) for users .Additionally,it may include data mapping and Conversion between  java objects and database entitties.
```java
@Configuration
public class BeanBag {
    @Bean
    public List<User> getDataSource()
    {
        return new ArrayList<>();
    }
}
```
### Database Design
The project database design includes tables for user management ,with fields such as :
* userId:(userId)
* userName:(userName)
* userPhoneNumber:(userPhoneNumber)
* userAddress:(userAddress)
  ***
### Data Structure Used
* user Class: Defines the structure for user data,including users attributes.
* ArrayList: Utilized for managing lists og User objects efficiently.
  ***
  ### Key Points
  * RESTful API endpoints for user management.
  * clean code separation with a layered architechture(UserController,BeanBagRepository).
  * Robust error handling for improve reliability.
  * java based backend framework(Spring boot) and maven  for build management.
  * Beginner friendly 
  




  
  
  
  
