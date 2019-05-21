package com.example.wms.wms.controllers;

import com.example.wms.wms.entities.StillageEntity;
import com.example.wms.wms.repositories.StillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//										Стандартные размеры стилажей
//					Высота									Длина							Глубина
//1000; 1500; 1800; 2000; 2200; 2500; 3000; 3500	||	700; 1000; 1200; 1500 	||	300; 400; 500; 600; 800

@RestController
@RequestMapping(value = "stillage")
public class StillageController {

	private final StillageRepository repository;

	@Autowired
	public StillageController(StillageRepository repository){
		this.repository = repository;
	}

	@PostMapping("/add")
	public void addStillage(@RequestBody StillageEntity stillageEntity){
		repository.save(stillageEntity);
	}

	@PostMapping("/delete")
	public void deleteStillage(@RequestParam(name = "id") Long id){
		repository.delete(repository.getOne(id));
	}
}
