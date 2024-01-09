package com.academy.fourtk.milhas.repositories

import com.academy.fourtk.milhas.entitites.Miles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MilesRepository : JpaRepository<Miles, Long>{

}
