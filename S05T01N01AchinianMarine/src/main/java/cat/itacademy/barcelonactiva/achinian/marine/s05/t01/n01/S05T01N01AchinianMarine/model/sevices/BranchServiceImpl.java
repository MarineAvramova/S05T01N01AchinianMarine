package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.sevices;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.domain.Branch;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BranchServiceImpl implements  BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<BranchDTO> getAll() {
        List<Branch> listBranch = branchRepository.findAll();
        List<BranchDTO> listBranchDTO = new ArrayList<>();
        for(Branch sucursal : listBranch){
           listBranchDTO.add(convertToDTO(sucursal));
        }
        return listBranchDTO;
    }

    @Override
    public Branch getOne(Integer id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
       Branch branch = null;
        if (optionalBranch.isPresent()){
            branch = optionalBranch.get();
        } else {
            throw new RuntimeException("Branch is not found ::"  + id);
        }
        return branch;
    }
    @Override
    public Branch add(Branch branch) {
        branchRepository.save(branch);
        return branch;
    }


    @Override
    public Branch update(Branch branch) {
        Optional<Branch> existingBranch = branchRepository.findById(branch.getPk_BranchID());
        existingBranch.get().setNameBranch(branch.getNameBranch());
        existingBranch.get().setCountryBranch(branch.getCountryBranch());
        Branch updatedBranch = branchRepository.save(existingBranch.get());
        return updatedBranch;
    }

    @Override
    public void delete(Integer id) {
     branchRepository.deleteById(id);
    }

    private BranchDTO convertToDTO(Branch branch){
       return new BranchDTO(branch.getPk_BranchID(), branch.getNameBranch(), branch.getCountryBranch());
    }
}


