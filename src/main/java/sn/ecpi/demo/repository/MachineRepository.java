package sn.ecpi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ecpi.demo.entity.Machine;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MachineRepository extends JpaRepository<Machine, UUID> {
    Optional<Machine> findByName(String name);

    Optional<Machine> deleteByName(String name);
}
