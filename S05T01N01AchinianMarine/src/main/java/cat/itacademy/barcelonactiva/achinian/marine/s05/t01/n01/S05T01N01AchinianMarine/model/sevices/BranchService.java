package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.sevices;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.domain.Branch;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.dto.BranchDTO;

import java.util.List;
import java.util.Optional;

public interface BranchService {
     List<BranchDTO> getAll();
    Branch getOne(Integer id);
     Branch add(Branch branch);
    Branch update(Branch branch);
    void delete(Integer id);

}
