package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.dto;

public class BranchDTO {
    private Integer pk_BranchID;
    private String nameBranch;
    private String countryBranch;
    private String typeBranch;

    public BranchDTO() {
    }

    public BranchDTO(Integer pk_BranchID, String nameBranch, String countryBranch) {
        this.pk_BranchID = pk_BranchID;
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
        this.typeBranch = checkCountry();
    }

    public Integer getPk_BranchID() {
        return pk_BranchID;
    }

    public void setPk_BranchID(Integer pk_BranchID) {
        this.pk_BranchID = pk_BranchID;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getCountryBranch() {
        return countryBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;
        this.typeBranch = checkCountry();
    }

    public String getTypeBranch() {
        return typeBranch;
    }

    private String checkCountry() {
        if (EUCountries.isEUCountry(this.countryBranch)) {
            return "EU";
        } else {
            return "Non-EU";
        }
    }
}
