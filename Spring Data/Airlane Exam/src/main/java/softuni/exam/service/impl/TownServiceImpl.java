package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.Constans.GlobalConstans.INVALID_MESSAGE;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private static final String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";

    public TownServiceImpl(TownRepository townRepository, Gson gson,
                           ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }



    @Override
    public boolean areImported() {
        return townRepository.count()>0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder out = new StringBuilder();
        TownImportDto[] dtos = gson.fromJson(readTownsFileContent(), TownImportDto[].class);
        Arrays.stream(dtos).forEach(townImportDto -> {

            if(validationUtil.isValid(townImportDto)){
                   Town town = modelMapper.map(townImportDto, Town.class);
                   try {
                       townRepository.save(town);
                       out.append(String.format("Successfully imported Town %s - %d", town.getName(), town.getPopulation()));
                   }catch (Throwable e){
                       out.append(String.format(INVALID_MESSAGE, "Town"));
                   }
            }else{
                out.append(String.format(INVALID_MESSAGE, "Town"));
            }
            out.append(System.lineSeparator());
        });
        return out.toString().trim();
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findByName(name);
    }
}
