package com.p5.adoptions.repository.cats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Al 2-lea parametru din JpaRepository e tipul cheiei primare din tabela Cat
public interface CatRepository extends JpaRepository<Cat, Integer> {
    Cat findCatByName(String name);
}
