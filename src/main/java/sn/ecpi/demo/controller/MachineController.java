package sn.ecpi.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ecpi.demo.entity.Machine;
import sn.ecpi.demo.service.MachineService;

import java.util.List;
import java.util.Optional;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("machines")
public class MachineController {
    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    // Endpoint pour créer une nouvelle machine
    @ResponseStatus
    @PostMapping(value = "creatmachine", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Machine> createMachine(@RequestBody Machine machine) {
        Machine createdMachine = machineService.createMachine(machine);
        return new ResponseEntity<>(createdMachine, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer toutes les machines
    @GetMapping
    public ResponseEntity<List<Machine>> getAllMachines() {
        List<Machine> machines = machineService.getAllMachines();
        return new ResponseEntity<>(machines, HttpStatus.OK);
    }

    // Endpoint pour récupérer une machine par son nom
    @GetMapping("/{name}")
    public ResponseEntity<Machine> getMachineByName(@PathVariable String name) {
        Optional<Machine> machineOptional = machineService.getMachineByName(name);
        return machineOptional.map(machine -> new ResponseEntity<>(machine, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour mettre à jour une machine
    @PutMapping("/{name}/update")
    public ResponseEntity<Machine> updateMachine(@PathVariable String name, @RequestBody Machine updatedMachine) {
        Machine machine = machineService.updateMachine(name, updatedMachine);
        if (machine != null) {
            return new ResponseEntity<>(machine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer une machine
    @DeleteMapping("/{name}/delete")
    public ResponseEntity<Void> deleteMachine(@PathVariable String name) {
        machineService.deleteMachine(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
