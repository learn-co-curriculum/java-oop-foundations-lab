public abstract class Athlete {
    private int jerseyNumber;

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public abstract int getRating() ;

}
