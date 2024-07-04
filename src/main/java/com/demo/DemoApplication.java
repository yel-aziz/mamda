package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demo.entity.users;
import com.dto.ProspectDto;
import com.service.usersService;

import io.jsonwebtoken.Claims;

import com.service.ProspectService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@SpringBootApplication
@RestController
@EnableWebMvc

@ComponentScan(basePackages = { "com.demo", "com.service" })

public class DemoApplication {

    @Autowired
    private usersService userservice;

    @Autowired
    private ProspectService prospectservice;

    @Autowired
    private JwtUtil jwt;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("userInfo/{id}")
    public users getUsers(@PathVariable int id) {
        return this.userservice.getUserById(id);
    }

    @GetMapping("allusers")
    public String getAllusers(HttpServletRequest request) {
        // HttpSession session = request.getSession(false);
        // String email = (String) session.getAttribute("login");
        // String role = (String) session.getAttribute("role");
        // System.out.println("User Email: " + email + ", Role: " + role);
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        System.out.println("--------------------------------------------------------------");

        System.out.println(jwt.parseToken(token));

        return token;
    }

    @DeleteMapping("deleteProspect/{id}")
    public void deleteProspect(
            @PathVariable("id") int id) {
        this.prospectservice.deleteProspect(id);
    }

    @PutMapping("UpdateProspect/{target}/{id}/{newValue}")
    public String UpdateProspect(@PathVariable("target") String target, @PathVariable("newValue") String newValue,
            @PathVariable("id") Long id) {
        this.prospectservice.updateProspect(id, newValue, target);
        return target;
    }

    @PostMapping("UpdateUserName")
    public String UpdateUserName(@RequestParam("userName") String userName, HttpServletRequest request) {

        String[] arr = this.userservice.getSession(request);
        if (arr[0] != "NULL" && arr[1] != "NUll") {

            int id = Integer.parseInt(arr[2]);
            this.userservice.UpdateUserNameById(id, userName);
            return "User Updated succefuly";
        }
        return "User not logged in";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }

    @PostMapping("/passWordUpdate")
    public String passWordUpdate(@RequestParam("NewPassword") String NewPassword,
            HttpServletRequest request) {

        String[] arr = this.userservice.getSession(request);
        System.out.print(arr[0]);
        try {

            if (arr[0] == "NULL") {
                return "retry";

            }
            this.userservice.passWordUpdate(NewPassword, request);

        } catch (Exception e) {
            System.out.println(e);
        }
        return "password reseted";

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("login") String login,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) {

        return this.userservice.login(login, password, request, response);
    }

    @PostMapping("CreateProspect")
    public ResponseEntity<String> CreateProspect(@ModelAttribute ProspectDto obj, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);

        if (!auto) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user not logged");

        }
        Claims data = jwt.parseToken(token);
        int id = data.get("userId", Integer.class);

        this.prospectservice.CreatProspect(id, obj);
        return ResponseEntity.ok("prospect created");

    }

    @GetMapping("UserInfos/{id}")
    public users getUserInfos(@PathVariable int id) {
        return this.userservice.getUserById(id);
    }

    @PostMapping("creat/{name}")
    public void CreatUser(@PathVariable String name) {
        this.userservice.CreatUser(name);
    }

}
