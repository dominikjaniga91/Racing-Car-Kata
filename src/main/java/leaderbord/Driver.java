package leaderbord;

class Driver implements Comparable<Driver> {

    private final String name;
    private final String country;
    private int points;

    public Driver(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + country.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) obj;
        return this.name.equals(other.name) && this.country.equals(other.country);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Driver o) {
        return this.name.compareTo(o.name);
    }
}