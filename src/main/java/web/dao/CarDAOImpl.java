package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImpl {

    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("BMW","M3","black"));
        carList.add(new Car("Mersedes","AMG","black"));
        carList.add(new Car("Lada","Vesta","boclagan"));
        carList.add(new Car("Nissan","GTR","white"));
        carList.add(new Car("Ferrari","458","red"));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
