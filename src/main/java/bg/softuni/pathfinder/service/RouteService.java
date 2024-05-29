package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.RouteShortInfoDTO;
import bg.softuni.pathfinder.model.entity.Route;

import java.util.List;

public interface RouteService {

    RouteShortInfoDTO getRandomRoute();

    RouteShortInfoDTO mapToShortInfo(Route route);

    List<RouteShortInfoDTO> getAllRoutes();

}
