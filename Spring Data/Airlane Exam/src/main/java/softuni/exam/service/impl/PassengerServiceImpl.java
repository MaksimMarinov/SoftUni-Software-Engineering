package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerImportDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.Constans.GlobalConstans.INVALID_MESSAGE;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final PassengerRepository passengerRepository;
    private static final String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";

    public PassengerServiceImpl(ModelMapper modelMapper, TownService townService,
                                Gson gson, ValidationUtil validationUtil, PassengerRepository passengerRepository) {
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.passengerRepository = passengerRepository;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count()>0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder out = new StringBuilder();
        PassengerImportDto[] passengerImportDtos = gson.fromJson(readPassengersFileContent(),
                PassengerImportDto[].class);
        Arrays.stream(passengerImportDtos).forEach(passengerImportDto -> {
            if(validationUtil.isValid(passengerImportDto)){
                Town town = townService.findByName(passengerImportDto.getTown());
                Passenger passenger = modelMapper.map(passengerImportDto, Passenger.class);
                try {
                    passenger.setTown(town);
                    passengerRepository.save(passenger);
                    out.append(String.format("Successfully imported Passenger %s - %s",
                            passenger.getLastName(), passenger.getEmail()));
                }catch (Throwable e){
                    out.append(String.format(INVALID_MESSAGE, "Passenger"));
                }
            }else{
                out.append(String.format(INVALID_MESSAGE, "Passenger"));
            }
            out.append(System.lineSeparator());
        });
        return out.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder out = new StringBuilder();
        passengerRepository.findByTicketsCountDesc().forEach(passenger -> {
            out.append(String.format("Passenger %s %s\n\tEmail - %s\n\tPhone - %s\n" +
                    "\tNumber of tickets %d\n", passenger.getFirstName(), passenger.getLastName(),
                    passenger.getEmail(), passenger.getPhoneNumber(), passenger.getTickets().size()));
        });

        return out.toString().trim();
    }

    @Override
    public Passenger findByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }
}
