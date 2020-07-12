package cn.edu.henu.analytics.repo;

import cn.edu.henu.analytics.entity.PowerReliability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerReliabilityRepo extends JpaRepository<PowerReliability,Long> {
}
