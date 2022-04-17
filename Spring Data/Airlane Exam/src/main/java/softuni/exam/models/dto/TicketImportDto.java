package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDto {
    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeOff;
    @XmlElement(name = "from-town")
    private TownImportByNameDto fromTown;
    @XmlElement(name = "to-town")
    private TownImportByNameDto toTown;
    @XmlElement(name = "passenger")
    private PassengerImportByNameDto passenger;
    @XmlElement(name = "plane")
    private PlaneImportByNameDto plane;

    @Size(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public TownImportByNameDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownImportByNameDto fromTown) {
        this.fromTown = fromTown;
    }

    public TownImportByNameDto getToTown() {
        return toTown;
    }

    public void setToTown(TownImportByNameDto toTown) {
        this.toTown = toTown;
    }

    public PassengerImportByNameDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerImportByNameDto passenger) {
        this.passenger = passenger;
    }

    public PlaneImportByNameDto getPlane() {
        return plane;
    }

    public void setPlane(PlaneImportByNameDto plane) {
        this.plane = plane;
    }
}
