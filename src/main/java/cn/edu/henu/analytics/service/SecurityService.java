package cn.edu.henu.analytics.service;

import cn.edu.henu.analytics.entity.auth.Subject;
import cn.edu.henu.analytics.except.NotAuthorizedException;
import cn.edu.henu.analytics.repo.auth.SubjectRepo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Value("${HMAC256.secret}")
    private String secret;
    private SubjectRepo subjectRepo;
    @Autowired
    public SecurityService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    public String tokenCreate(Subject subject) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);
        return JWT.create()
                .withSubject(subject.getId().toString())
                .withClaim("name", subject.getName())
                .withClaim("role", subject.getRole())
                .sign(algorithm);
    }

    public Subject tokenVerify(String token) throws NotAuthorizedException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return subjectRepo.findById(Long.parseLong(jwt.getSubject())).orElseThrow(NotAuthorizedException::new);
        } catch (JWTVerificationException exception) {
            throw new NotAuthorizedException();
        }
    }
}
