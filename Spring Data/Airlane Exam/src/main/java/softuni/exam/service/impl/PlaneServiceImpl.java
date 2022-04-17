package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.Constans.GlobalConstans;
import softuni.exam.models.dto.PlaneRootImportDto;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final PlaneRepository planeRepository;
    private final String PLANE_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    public PlaneServiceImpl(ModelMapper modelMapper, TownService townService,
                            ValidationUtil validationUtil, XmlParser xmlParser, PlaneRepository planeRepository) {
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.planeRepository = planeRepository;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count()>0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANE_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder out = new StringBuilder();
        PlaneRootImportDto planeRootImportDto = xmlParser.fromFile(PLANE_FILE_PATH, PlaneRootImportDto.class);
        planeRootImportDto.getPlanes().forEach(planeImportDto -> {
            if(validationUtil.isValid(planeImportDto)){
                Plane plane = modelMapper.map(planeImportDto, Plane.class);
                planeRepository.save(plane);
                out.append(String.format("Successfully imported Plane %s", plane.getRegisterNumber()));
            }else{
                out.append(String.format(GlobalConstans.INVALID_MESSAGE, "Plane"));
            }
            out.append(System.lineSeparator());
        });
        return out.toString().trim();
    }

    @Override
    public Plane findByRegisterNumber(String registerNumber) {
        return planeRepository.findByRegisterNumber(registerNumber);
    }
}
