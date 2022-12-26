package pl.kmiecik.tests.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface CarRepository extends JpaRepository<CarEntity, Long> {

}
