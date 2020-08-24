package com.leonaascimento.condo.persistence

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UnitRepository : CrudRepository<UnitTable, UUID>
