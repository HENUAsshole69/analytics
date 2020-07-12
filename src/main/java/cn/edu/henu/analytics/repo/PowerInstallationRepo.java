package cn.edu.henu.analytics.repo;

import cn.edu.henu.analytics.entity.PowerInstallation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerInstallationRepo extends JpaRepository<PowerInstallation,Long> {
}
