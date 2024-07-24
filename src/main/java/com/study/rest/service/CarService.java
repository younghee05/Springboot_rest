package com.study.rest.service;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService { // service 객체 생성

    // final -> 상수: 무조건 한번은 초기화를 해줘야 한다. / null을 넣어서라도 초기화 시켜주어야 한다
//    @Autowired
    private final CarRepository carRepository; // carRepository의 주소값이 바뀌면 안된다는 뜻 (상수)

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

//    public CarService(CarRepository carRepository) {
//        this.carRepository = carRepository;
//    }  // @Autowired 를 안쓰면 이런 형태로 써야한다

    public Car getCar(String model) {
        return carRepository.findCarByModel(model); // carRepository 에서 model 값을 그대로 전달
    }
}
