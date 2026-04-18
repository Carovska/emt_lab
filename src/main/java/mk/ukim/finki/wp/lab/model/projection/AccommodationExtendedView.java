package mk.ukim.finki.wp.lab.model.projection;

public interface AccommodationExtendedView {
    Long getId();
    String getName();
    String getAccommodationCategory();
    Integer getNumRooms();
    String getHostFullName();
    String getHostCountryName();
}
