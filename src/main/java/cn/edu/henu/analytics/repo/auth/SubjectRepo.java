package cn.edu.henu.analytics.repo.auth;

import cn.edu.henu.analytics.entity.auth.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {
}
