package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.dto;

public enum EUCountries {
    AUSTRIA,
    BELGIUM,
    BULGARIA,
    CROATIA,
    CYPRUS,
    CZECH_REPUBLIC,
    DENMARK,
    ESTONIA,
    FINLAND,
    FRANCE,
    GERMANY,
    GREECE,
    HUNGARY,
    IRELAND,
    ITALY,
    LATVIA,
    LITHUANIA,
    LUXEMBOURG,
    MALTA,
    NETHERLANDS,
    POLAND,
    PORTUGAL,
    ROMANIA,
    SLOVAKIA,
    SLOVENIA,
    SPAIN,
    SWEDEN;

    public static boolean isEUCountry(String country) {
        String normalizedCountry = country.toUpperCase().replace(" ", "_");
        for (EUCountries euCountry : EUCountries.values()) {
            if (euCountry.name().equals(normalizedCountry)) {
                return true;
            }
        }
        return false;
    }
}
