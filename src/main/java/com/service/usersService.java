package com.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Comparator;
import com.demo.JwtUtil;
import com.demo.entity.Prospects;
import com.demo.entity.Users;
import com.demo.repository.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletResponse;

@Service

public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private JwtUtil jwt;

    private static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            // Return hashed password
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Users getUserById(int id) {
        Users i = this.userRepository.findByUserId(id);
        System.out.println(i);
        return i;
    }

    public Users getUserByLogin(String login) {
        return this.userRepository.findByLogin(login);
    }

    public String[] getSession(HttpServletRequest request) {

        String[] sessionnotfound = { "NULL", "NULL", "NULL" };

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("login") != null) {
            String email = (String) session.getAttribute("login");
            String role = (String) session.getAttribute("role");
            String Id = (String) session.getAttribute("Id");
            String[] strings = { email, role, Id };
            // System.out.println(Id);

            return strings;
        }
        return sessionnotfound;
    }

    public int CreatUser(String Username, String password, String role, String Region) {
        Users obj = new Users();

        obj.setActif("1");
        obj.setLogin(Username);
        obj.setPassword(password);
        obj.setBackOfficeAccess("1");
        obj.setRole(role);
        obj.setRegion(Region);

        userRepository.save(obj);
        return 1;
    }

    public Users UpdateUserNameById(int userId, String NewUserName) {

        Users obj = this.userRepository.findByUserId(userId);
        obj.setUsername(NewUserName);
        userRepository.save(obj);

        return obj;

    }

    public ResponseEntity<String> login(String login, String password, HttpServletRequest request,
            HttpServletResponse response) {
        Users obj = getUserByLogin(login);
        if (obj == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User does not exist");
        }

        String dataBasePass = hashPassword(obj.getPassword());
        String requestPass = hashPassword(password);
        boolean status = dataBasePass.equals(requestPass);

        if (status == true) {

            String toekn = jwt.generateToken(obj.getLogin(), 8666660, obj.getUserId(), obj.getRole());
            System.out.print(toekn);

            return ResponseEntity.ok(toekn);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    public String passWordUpdate(@RequestParam("Newpassword") String Newpassword, int id) {

        Users obj = this.getUserById(id);
        if (obj == null) {
            return "user not existed";
        } else if (obj != null) {

            obj.setPassword(Newpassword);
            this.userRepository.save(obj);

        }

        return "password reseted succefuly";
    }

    public List<Users> getAll() {

        return this.userRepository.findAll();
    }

    public List<Prospects> allUserProspects(int userId) {
        Users user = this.userRepository.findByUserId(userId);

        if (user != null) {
            List<Prospects> prospects = user.getProspects();

            prospects.sort(Comparator.comparing(Prospects::getDateCreation).reversed());
            return prospects;

        } else {

            return null;
        }
    }

}
