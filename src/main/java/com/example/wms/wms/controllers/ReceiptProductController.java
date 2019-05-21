package com.example.wms.wms.controllers;

import com.example.wms.wms.entities.PalletEntity;
import com.example.wms.wms.entities.ProductEntity;
import com.example.wms.wms.repositories.PalletRepository;
import com.example.wms.wms.repositories.ProductRepository;
import com.example.wms.wms.repositories.StillageRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Поступление товара"}, description = "API для Поступившего товара")
@RestController
@RequestMapping("receipt")
public class ReceiptProductController {

	final ProductRepository productRepository;
	final PalletRepository palletRepository;
	final StillageRepository stillageRepository;

	@Autowired
	public ReceiptProductController(ProductRepository productRepository, PalletRepository palletRepository, StillageRepository stillageRepository) {
		this.productRepository = productRepository;
		this.palletRepository = palletRepository;
		this.stillageRepository = stillageRepository;
	}

	@PostMapping("/addOneProduct")
	public void addOneProduct(@RequestParam(name = "id_product") long id_product) {
		ProductEntity productEntity = productRepository.getOne(id_product);
		productEntity.setCount(productEntity.getCount() + 1);
	}

	@PostMapping("/addPallet")
	public void addPallet(@RequestBody PalletEntity pallet) {
		ProductEntity productEntity = productRepository.getOne(pallet.getProduct_id());
		productEntity.setCount(productEntity.getCount() + pallet.getCount_product());

		palletRepository.save(pallet);
	}

	@PostMapping("/makePallet")
	public void makePallet(@RequestParam PalletEntity pallet){
		palletRepository.save(pallet);
	}
}
