//package restorder.orderproduk.controllers;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
////import restorder.orderproduk.api.BaseResponse;
//import restorder.orderproduk.entity.User;
//import restorder.orderproduk.service.user.UserService;
//import restorder.orderproduk.service.user.UserServiceImpl;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    @Autowired
//    private UserServiceImpl userService;
//
//
//    @PostMapping("/upload-users-data")
//    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file){
//        this.userService.saveUsersToDatabase(file);
//        return ResponseEntity
//                .ok(Map.of("Message", "Customers data uploaded and save to database successfully"));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> getUsers(){
//        return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);
//    }

//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        User updatedUser = userService.updateUser(id, user);
//        if (updatedUser != null) {
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }



//
//    -----------------------BaseResponse------------------------

//    @GetMapping("/user/v1")
//    public ResponseEntity<BaseResponse<List<User>>> getAllUsers2() {
//        List<User> users = userService.getAllUsers();
//        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua User", users));
//
//    }
//
//
//    @GetMapping("/user/v1/{id}")
//    public ResponseEntity<BaseResponse<User>> getUserById2(@PathVariable("id") Long id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            return ResponseEntity.ok(BaseResponse.ok("User Ditemukan", user));
//        } else {
//            return ResponseEntity.ok(BaseResponse.error("User Tidak Ditemukan"));
//        }
//    }
//}

