import java.util.Objects;

public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return getPopulation() == city.getPopulation() && Objects.equals(getName(), city.getName()) && Objects.equals(getRegion(), city.getRegion()) && Objects.equals(getDistrict(), city.getDistrict()) && Objects.equals(getFoundation(), city.getFoundation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRegion(), getDistrict(), getPopulation(), getFoundation());
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }
}
