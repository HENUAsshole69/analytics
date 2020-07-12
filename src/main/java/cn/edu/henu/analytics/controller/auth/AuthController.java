package cn.edu.henu.analytics.controller.auth;

import cn.edu.henu.analytics.entity.auth.Subject;
import cn.edu.henu.analytics.except.NotAuthorizedException;
import cn.edu.henu.analytics.repo.auth.SubjectRepo;
import cn.edu.henu.analytics.service.SecurityService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private SecurityService securityService;
    private SubjectRepo subjectRepo;
    @Autowired
    public AuthController(SecurityService securityService, SubjectRepo subjectRepo){
        this.securityService = securityService;
        this.subjectRepo = subjectRepo;
    }
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userName,@RequestParam String password){
        var subject = new Subject();
        subject.setName(userName);
        subject.setPassword(password);
        subject = subjectRepo.findOne(Example.of(subject)).orElseThrow(NotAuthorizedException::new);
        return ResponseEntity.ok(securityService.tokenCreate(subject));
    }
    @PostMapping("/subject")
    public ResponseEntity<Subject> getSubject(@RequestBody String token){
        return ResponseEntity.ok(securityService.tokenVerify(token));
    }
    @GetMapping("/register")
    public ResponseEntity<Subject> register(@RequestParam String userName,@RequestParam String role,@RequestParam String password){
        val subject = new Subject();
        subject.setRole(role);
        subject.setName(userName);
        subject.setPassword(password);
        return ResponseEntity.ok(subjectRepo.save(subject));
    }
}
