package cn.edu.henu.analytics.repo;

import cn.edu.henu.analytics.entity.PowerExpenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerExpenditureRepo extends JpaRepository<PowerExpenditure,Long> {
}
