package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.RouteShortInfoDTO;
import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final Random random;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.random = new Random();
    }


    @Override
    @Transactional
    public RouteShortInfoDTO getRandomRoute() {
        long routeCount = this.routeRepository.count();
        long randomId = this.random.nextLong(routeCount) + 1;

        Optional<Route> route = this.routeRepository.findById(randomId);

        if (route.isEmpty()) {
            throw new RuntimeException();
        }

        return mapToShortInfo(route.get());
    }

    public RouteShortInfoDTO mapToShortInfo(Route route) {
        RouteShortInfoDTO dto = this.modelMapper.map(route, RouteShortInfoDTO.class);

        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());
        return dto;
    }

    @Transactional
    public List<RouteShortInfoDTO> getAllRoutes() {
        return this.routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .toList();
    }
}
