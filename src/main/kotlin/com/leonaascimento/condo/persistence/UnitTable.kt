package com.leonaascimento.condo.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("unit")
data class UnitTable(
    @Id
    val id: UUID?,
    val number: Int,
    val size: Double,
    val owner: String
)
