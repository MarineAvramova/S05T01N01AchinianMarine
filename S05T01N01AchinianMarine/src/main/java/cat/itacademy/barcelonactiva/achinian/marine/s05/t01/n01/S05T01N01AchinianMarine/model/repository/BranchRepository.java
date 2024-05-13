package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.repository;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
