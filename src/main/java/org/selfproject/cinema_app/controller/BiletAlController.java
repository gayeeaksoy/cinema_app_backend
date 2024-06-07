package org.selfproject.cinema_app.controller;

import org.selfproject.cinema_app.model.BiletAlEntity;
import org.selfproject.cinema_app.repository.BiletAlRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.selfproject.cinema_app.model.GlobalUserId;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/biletal")
public class BiletAlController {

    private final BiletAlRepository biletAlRepository;

    public BiletAlController(BiletAlRepository biletAlRepository){
        this.biletAlRepository = biletAlRepository;
    }

    @PostMapping
    public ResponseEntity<BiletAlEntity> saveSelection(@RequestBody BiletAlEntity biletAlEntity) {
        try {
            biletAlEntity.setUserId(GlobalUserId.getInstance().getUserId());
            BiletAlEntity savedEntity = biletAlRepository.save(biletAlEntity);
            System.out.println(biletAlEntity.toString());
            return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public List<BiletAlEntity> getAllSelections() {
        return biletAlRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BiletAlEntity> getBiletAlById(@PathVariable Long id) {
        BiletAlEntity biletAl = biletAlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BiletAlEntity not found with id: " + id));
        return ResponseEntity.ok(biletAl);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BiletAlEntity> updateBiletAl(@PathVariable Long id, @RequestBody BiletAlEntity biletAlDetails) {
        BiletAlEntity biletAl = biletAlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BiletAlEntity not found with id: " + id));

        biletAl.setSecilenSinema(biletAlDetails.getSecilenSinema());
        biletAl.setSecilenTarih(biletAlDetails.getSecilenTarih());
        biletAl.setSecilenSeans(biletAlDetails.getSecilenSeans());
        biletAl.setOgrenciBiletSayisi(biletAlDetails.getOgrenciBiletSayisi());
        biletAl.setTamBiletSayisi(biletAlDetails.getTamBiletSayisi());

        BiletAlEntity updatedBiletAl = biletAlRepository.save(biletAl);
        return ResponseEntity.ok(updatedBiletAl);
    }

    @PutMapping("/save")
    public ResponseEntity<BiletAlEntity> updateSeatsSelection(@RequestBody BiletAlEntity biletAlEntity) {
        try {
            System.out.println(biletAlEntity.toString());
            Optional<BiletAlEntity> optionalEntity = biletAlRepository.findTopByOrderByIdDesc();
            optionalEntity.ifPresent(existingEntity -> {
                Optional.ofNullable(biletAlEntity.getSecilenKoltuklar()).ifPresent(existingEntity::setSecilenKoltuklar);
                Optional.ofNullable(biletAlEntity.getSecilenSinema()).ifPresent(existingEntity::setSecilenSinema);
                Optional.ofNullable(biletAlEntity.getSecilenTarih()).ifPresent(existingEntity::setSecilenTarih);
                Optional.ofNullable(biletAlEntity.getSecilenSeans()).ifPresent(existingEntity::setSecilenSeans);
                Optional.ofNullable(biletAlEntity.getOgrenciBiletSayisi()).ifPresent(existingEntity::setOgrenciBiletSayisi);
                Optional.ofNullable(biletAlEntity.getTamBiletSayisi()).ifPresent(existingEntity::setTamBiletSayisi);
                biletAlRepository.save(existingEntity);
            });
            return optionalEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}