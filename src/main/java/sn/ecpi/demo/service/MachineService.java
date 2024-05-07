package sn.ecpi.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.ecpi.demo.entity.Machine;
import sn.ecpi.demo.repository.MachineRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MachineService {

    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    // Create
    public Machine createMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    // Read
    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public Optional<Machine> getMachineByName(String name) {
        return machineRepository.findByName(name);
    }

    // Update
    public Machine updateMachine(String name, Machine updatedMachine) {
        Optional<Machine> existingMachineOptional = machineRepository.findByName(name);
        if (existingMachineOptional.isPresent()) {
            Machine existingMachine = existingMachineOptional.get();
            existingMachine.setName(updatedMachine.getName());
            existingMachine.setOs(updatedMachine.getOs());
            existingMachine.setLevel(updatedMachine.getLevel());
            existingMachine.setPlateforme(updatedMachine.getPlateforme());
            existingMachine.setDescription(updatedMachine.getDescription());
            return machineRepository.save(existingMachine);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    // Delete
    public void deleteMachine(String name) {
        machineRepository.deleteByName(name);
    }
}
