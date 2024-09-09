package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demo.entity.Compagnie;
import com.demo.entity.Produits;
import com.demo.entity.Prospects;
import com.demo.entity.ProspectsProduitsLink;
import com.demo.entity.psp_RendezVous;
import com.demo.repository.SitesRepository;
import com.demo.entity.Sites;
import com.demo.entity.Users;
import com.dto.ProspectDto;
import com.dto.RendezVousDTO;
import com.dto.UserDto;
import com.dto.psp_TicketDto;
import com.service.UsersService;

import io.jsonwebtoken.Claims;

import com.service.CompagnieService;
import com.service.ProspectService;
import com.service.RendezvousService;
import com.service.SiteService;
import com.service.TicketService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@RestController
@EnableWebMvc

@ComponentScan(basePackages = { "com.demo", "com.service" })

public class DemoApplication {

    @Autowired
    private UsersService Userservice;

    @Autowired
    private SiteService siteService;

    @Autowired
    private ProspectService prospectservice;

    @Autowired
    private RendezvousService rendezvousservice;

    @Autowired
    private CompagnieService compagnieService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private SiteService Siteservice;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public int getJwtUserId(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);

        if (!auto) {
            return 0;
        }

        Claims data = jwt.parseToken(token);
        int userId = data.get("userId", Integer.class);
        return userId;

    }

    @GetMapping("userInfo/{id}")
    public Users getUsers(@PathVariable int id) {
        return this.Userservice.getUserById(id);
    }

    @PostMapping("createrendezvous")
    public void psp_RendezVous(@ModelAttribute RendezVousDTO obj, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);

        Claims data = jwt.parseToken(token);
        int id = data.get("userId", Integer.class);

        this.rendezvousservice.CreatRendezVous(obj, id);

    }

    @GetMapping("allUsers")
    public ResponseEntity<?> getAllUsers(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        Claims data = jwt.parseToken(token);
        String role = (String) data.get("role");
        if ("PDEV".equalsIgnoreCase(role)) {
            return ResponseEntity.ok(this.Userservice.getAll());
        } else if ("REGION".equalsIgnoreCase(role)) {
            int id = data.get("userId", Integer.class);
            Users obj = this.Userservice.getUserById(id);
            List<Sites> sitesByRegion = this.siteService.getAllsitesByRegion(obj.getRegion());

            List<Sites> activeSites = sitesByRegion.stream()
                    .filter(site -> site.getActif() == 1)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(activeSites);

        }
        return ResponseEntity.ok("done");

    }

    @DeleteMapping("deleteProspect")
    public void deleteProspect(
            @RequestParam("id") int id) {
        this.prospectservice.deleteProspect(id);
    }

    @DeleteMapping("deleteTicket")
    public void deleteTicket(
            @RequestParam("id") int id) {
        this.ticketService.deletTicket(id);
    }

    @GetMapping("getprospectbyid")
    public ResponseEntity<Prospects> getMethodName(@RequestParam("id") Long id) {
        Prospects pro = this.prospectservice.getProspects(id);
        return ResponseEntity.ok(pro);
    }

    @PostMapping("creatcompanie")
    public ResponseEntity<String> creatCompany(@RequestParam("Status") String Status,
            @RequestParam("Libelle") String Libelle) {
        this.compagnieService.CreatCompanie(Status, Libelle);
        return ResponseEntity.ok("created");
    }

    @GetMapping("getAllcompanie")
    public ResponseEntity<List<Compagnie>> getAllcompanie() {
        return ResponseEntity.ok(this.compagnieService.getAllCompagnies());
    }

    @PutMapping("updateLibelle")
    public ResponseEntity<String> updateLibelle(@RequestParam("id") Long CompgnieId,
            @RequestParam("newLibelle") String newLibelle) {
        this.compagnieService.updateLibelle(newLibelle, CompgnieId);
        return ResponseEntity.ok("libelle updated");
    }

    @PutMapping("updateStatus")
    public ResponseEntity<String> updateStatus(@RequestParam("status") String status, @RequestParam("id") Long id) {
        this.compagnieService.updateStatus(status, id);
        return ResponseEntity.ok("status updated");
    }

    @GetMapping("getRendeVoubyid")
    public ResponseEntity<psp_RendezVous> getRendeVoubyid(@RequestParam("id") Long id) {
        psp_RendezVous pro = this.rendezvousservice.getRendeVous(id);
        return ResponseEntity.ok(pro);
    }

    @GetMapping("getRendeVous")
    public ResponseEntity<?> getRendeVous(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        Claims data = jwt.parseToken(token);
        int id = this.getJwtUserId(request);
        String role = (String) data.get("role");
        Users user = this.Userservice.getUserById(id);
        if ("CC".equalsIgnoreCase(role)) {
            return ResponseEntity.ok(user.getRendezvous());
        } else if ("CCS".equalsIgnoreCase(role)) {
            int SiteId = user.getIDSite();
            Sites site = this.siteService.getSiteById(SiteId);
            if (site != null) {
                List<Users> users = site.getUsers();
                List<psp_RendezVous> allRendevous = new ArrayList<>();
                for (Users useri : users) {
                    if (useri.getProspects() != null) {
                        allRendevous.addAll(useri.getRendezvous());
                    }
                }
                return ResponseEntity.ok(allRendevous);
            }
        } else if ("REGIONAL".equalsIgnoreCase(role)) {

            return this.getAllsitesByRegion(request);

        } else if ("PDEV".equalsIgnoreCase(role)) {

            return this.getAllSites();
        }

        return ResponseEntity.ok(user.getRendezvous());
    }

    @PutMapping("UpdateProspect")
    public ResponseEntity<?> UpdateProspect(@ModelAttribute ProspectDto obj,
            @RequestParam("prospectId") Long prospectId, HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);

        if (!auto) {
            // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged
            // in");
        }

        Claims data = jwt.parseToken(token);
        int userId = data.get("userId", Integer.class);

        Prospects pro = prospectservice.getProspects(prospectId);
        return this.prospectservice.updateProspect(pro, obj);

     //   return ResponseEntity.ok(objj);

    }

    @PutMapping("UpdateRendevous")
    public ResponseEntity<psp_RendezVous> UpdateRendevous(@ModelAttribute RendezVousDTO obj,
            @RequestParam("rendevousid") Long rendevousid, HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);

        if (!auto) {
            // return ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        Claims data = jwt.parseToken(token);
        int userId = data.get("userId", Integer.class);
        System.out.print("----------------------------------------------------");

        System.out.print(rendevousid);

        psp_RendezVous pro = rendezvousservice.getRendeVous(rendevousid);
        this.rendezvousservice.updateRendevous(pro, obj);

        return ResponseEntity.ok(pro);

    }

    @PutMapping("updateUser/{id}")
    public void updateuser(@ModelAttribute UserDto data, @PathVariable("id") int id) {

        this.Userservice.UpdateUser(data, id);

    }

    @DeleteMapping("DeleteRendezvous")
    public void DeleteRendezvous(
            @RequestParam("id") int id) {
        this.rendezvousservice.DeleteRendezvous(id);
    }

    @PostMapping("UpdateUserName")
    public ResponseEntity<String> UpdateUserName(@RequestParam("userName") String userName,
            HttpServletRequest request) {
        int userId = this.getJwtUserId(request);
        if (userId == 0) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Updated succefuly");
        }
        this.Userservice.UpdateUserNameById(userId, userName);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Updated succefuly");
    }

    @GetMapping("getTicket")
    public ResponseEntity<?> getTicket() {
        return ResponseEntity.ok(this.ticketService.getAll());
    }

    @PostMapping("creatTicket")
    public ResponseEntity<psp_TicketDto> creatTicket(@ModelAttribute psp_TicketDto data, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        if (!auto) {
            // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user not
            // logged");
        }
        Claims jwtdata = jwt.parseToken(token);
        int id = jwtdata.get("userId", Integer.class);
        Users user = this.Userservice.getUserById(id);

        // Log the received data
        System.out.println("Received ticket data: " + data);

        this.ticketService.creatTicket(data, user);
        return ResponseEntity.ok(data);
    }

    @PostMapping("creatOffice")
    public ResponseEntity<Sites> creatOffice(@RequestParam("officeName") String officeName,
            @RequestParam("Region") String Region) {
        Sites sit = this.Siteservice.creatSite(officeName, Region);
        return ResponseEntity.ok(sit);
    }

    @PostMapping("setOfficeToUser")
    public void setOfficeToUser(@RequestParam("officeId") int officeId, @RequestParam("UserId") int UserId) {
        this.Siteservice.SetUserOffice(officeId, UserId);
    }

    @GetMapping("getAllsites")
    public ResponseEntity<List<Sites>> getAllSites() {
        return ResponseEntity.ok(this.siteService.getSites());
    }

    @GetMapping("getAllsitesByRegion")
    public ResponseEntity<?> getAllsitesByRegion(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        // Validate the token
        if (token == null || !jwt.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        // Parse the token to get claims
        Claims data = jwt.parseToken(token);
        int id = data.get("userId", Integer.class);

        // Fetch the user by ID
        Users user = this.Userservice.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        // Check the user's role and return sites by region
        if (user.getRole().equalsIgnoreCase("REGIONAL")) {
            List<Sites> sitesByRegion = this.siteService.getAllsitesByRegion(user.getRegion());

            List<Sites> activeSites = sitesByRegion.stream()
                    .filter(site -> site.getActif() == 1)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(activeSites);
        } else if (user.getRole().equalsIgnoreCase("PDEV")) {
            List<Sites> allsites = this.siteService.getSites();
            return ResponseEntity.ok(allsites);
        }

        // Return an empty list if the user role is not "PDEV"
        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping("/passWordUpdate")
    public ResponseEntity<String> passWordUpdate(@RequestParam("NewPassword") String NewPassword,
            HttpServletRequest request) {
        int userId = this.getJwtUserId(request);
        try {

            this.Userservice.passWordUpdate(NewPassword, userId);

        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok("done");

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("login") String login,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) {
        return this.Userservice.login(login, password, request, response);
    }

    @GetMapping("getSites")
    public ResponseEntity<Sites> getSitesById(@RequestParam("siteId") int siteId) {
        Sites sites = this.Siteservice.getSiteById(siteId);
        return ResponseEntity.ok(sites);
    }

    @GetMapping("getProspectProducts")
    public void getProspectProducts(@RequestParam("id") int id) {
       // return this.prospectservice.getProducts(id);
       //return List<"done">
    }

    @PostMapping("CreateProspect")
    public ResponseEntity<?> CreateProspect(@ModelAttribute ProspectDto obj, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        if (!auto) {
            // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user not
            // logged");
        }
        Claims data = jwt.parseToken(token);
        int id = data.get("userId", Integer.class);
        Prospects pro = this.prospectservice.CreatProspect(id, obj);
        return ResponseEntity.ok(pro);
    }

    @GetMapping("getProspectsByUser")
    public ResponseEntity<?> getProspectsByUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        if (!auto) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user not  logged");
        }
        Claims data = jwt.parseToken(token);
        int id = data.get("userId", Integer.class);
        return ResponseEntity.ok(this.prospectservice.getAllProspectsByUserId(id));
    }

    @GetMapping("getUserId")
    public ResponseEntity<?> getUserId(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        if (!auto) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user not  logged");
        }
        Claims data = jwt.parseToken(token);
        String role = data.get("role", String.class);
        if ("REGIONAL".equalsIgnoreCase(role) || "PDEV".equalsIgnoreCase(role)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

    @PostMapping("AffectationProspect")
    public ResponseEntity<String> AffectationProspect(@ModelAttribute ProspectDto obj,
            @RequestParam("UserId") int userId, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        if (!auto) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user not logged");
        }
        Claims data = jwt.parseToken(token);
        String role = (String) data.get("role");
        if ("PDEV".equalsIgnoreCase(role) | "REGIONAL".equalsIgnoreCase(role)) {
            this.prospectservice.CreatProspect(userId, obj);
            return ResponseEntity.ok("prospect created");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Prospect not affected");

    }

    @GetMapping("alluserprospects")
    public ResponseEntity<?> alluserprospects(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean auto = jwt.validateToken(token);
        Claims data = jwt.parseToken(token);
        int id = this.getJwtUserId(request);
        String role = (String) data.get("role");
        Users user = this.Userservice.getUserById(id);
        if ("CC".equalsIgnoreCase(role)) {
            return ResponseEntity.ok(user.getProspects());
        } else if ("CCS".equalsIgnoreCase(role)) {
            int SiteId = user.getIDSite();
            Sites site = this.siteService.getSiteById(SiteId);
            if (site != null) {
                List<Users> users = site.getUsers();
                List<Prospects> allProspects = new ArrayList<>();
                for (Users useri : users) {
                    if (useri.getProspects() != null) {
                        allProspects.addAll(useri.getProspects());
                    }
                }
                return ResponseEntity.ok(allProspects);
            }
        } else if ("REGIONAL".equalsIgnoreCase(role)) {

            return ResponseEntity.ok(this.prospectservice.getAllProspectsByUserId(id));
        } else if ("PDEV".equalsIgnoreCase(role)) {

            return ResponseEntity.ok(this.prospectservice.getAllProspects());
        }

        return ResponseEntity.ok(user.getProspects());
    }

    @PostMapping("updateOfficeStatus")
    public void updateOfficeStatus(@RequestParam("id") int id, @RequestParam("status") int status) {
        this.siteService.updateStatus(id, status);
    }

    @PostMapping("UpdateRole")
    public ResponseEntity<String> UpdateRole(HttpServletRequest request) {

        return ResponseEntity.ok("RoleUpdated");
    }

    @GetMapping("UserInfos/{id}")
    public Users getUserInfos(@PathVariable int id) {
        return this.Userservice.getUserById(id);
    }

    @PostMapping("creat")
    public ResponseEntity<?> CreatUser(@ModelAttribute UserDto data) {

        if (this.Userservice.CreatUser(data) == 1) {

            return ResponseEntity.ok("user created");
        }
        return ResponseEntity.ok(data);

    }

}
