package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

public class CarsController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping()
    public String ind(Model model){
        model.addAttribute("cars", carService.getAllCars());
        return "/cars/index";
    }
    @GetMapping(value = "")
    public String index(@RequestParam(value = "count") int count, Model model){
        List<Car> carList = (count < 5)&(count > 0)? carService.getCars(count)
                : carService.getAllCars();
        model.addAttribute("cars", carList);
        return "/cars/index";
    }
}

