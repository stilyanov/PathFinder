package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.AddRouteDTO;
import bg.softuni.pathfinder.model.dto.RouteShortInfoDTO;
import bg.softuni.pathfinder.model.enums.CategoryType;
import bg.softuni.pathfinder.model.enums.LevelType;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {
//        RouteShortInfoDTO randomRoute = this.routeService.getRandomRoute();
//        model.addAttribute("route", randomRoute);

        List<RouteShortInfoDTO> allRoutes = this.routeService.getAllRoutes();
        model.addAttribute("routes", allRoutes);

        return "routes";
    }

    @GetMapping("/routes/add")
    public String addRoute(Model model) {
        model.addAttribute("route", new AddRouteDTO());
        model.addAttribute("levels", LevelType.values());
        model.addAttribute("categories", CategoryType.values());

        return "add-route";
    }

    @PostMapping("/routes/add")
    public String addRoute(AddRouteDTO addRouteDTO) {
        this.routeService.addRoute(addRouteDTO);

        return "redirect:/routes";
    }
}
