package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.Constans.GlobalConstans;
import softuni.exam.models.dto.TicketImportRootDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Plane;
import softuni.exam.models.entity.Ticket;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {

    private final ModelMapper modelMapper;
    private final TownService townService;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final TicketRepository ticketRepository;
    private final PlaneService planeService;
    private final PassengerService passengerService;
    private final String TICKET_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    public TicketServiceImpl(ModelMapper modelMapper, TownService townService,
                             ValidationUtil validationUtil, XmlParser xmlParser,
                             TicketRepository ticketRepository, PlaneService planeService,
                             PassengerService passengerService) {
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.ticketRepository = ticketRepository;
        this.planeService = planeService;
        this.passengerService = passengerService;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count()>0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKET_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder out = new StringBuilder();
        TicketImportRootDto tickets =  xmlParser.fromFile(TICKET_FILE_PATH, TicketImportRootDto.class);
        tickets.getTickets().forEach(ticketImportDto -> {
            if(validationUtil.isValid(ticketImportDto)){
                Town toTown = townService.findByName(ticketImportDto.getToTown().getName());
                Town fromTown= townService.findByName(ticketImportDto.getFromTown().getName());
                Plane plane = planeService.findByRegisterNumber(ticketImportDto.getPlane().getRegisterNumber());
                Passenger passenger = passengerService.findByEmail(ticketImportDto.getPassenger().getEmail());
                Ticket ticket = modelMapper.map(ticketImportDto, Ticket.class);
                ticket.setFromTown(fromTown);
                ticket.setToTown(toTown);
                ticket.setPassenger(passenger);
                ticket.setPlane(plane);
                try {
                    ticketRepository.save(ticket);
                    out.append(String.format("Successfully imported Ticket %s - %s", fromTown.getName(), toTown.getName()));
                }catch (Throwable e){
                    out.append(String.format(GlobalConstans.INVALID_MESSAGE, "Ticket"));
                }
            }else{
                out.append(String.format(GlobalConstans.INVALID_MESSAGE, "Ticket"));
            }
            out.append(System.lineSeparator());
        });
        return out.toString().trim();
    }
}
