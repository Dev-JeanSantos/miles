package com.academy.fourtk.milhas.repositories

import com.academy.fourtk.milhas.entitites.Program
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface ProgramRepository: JpaRepository<Program, Long>  {
    @Query(value = "SELECT * FROM program c WHERE c.name = ?1", nativeQuery = true)
    fun findByName(programName: String): Optional<Program>

}
