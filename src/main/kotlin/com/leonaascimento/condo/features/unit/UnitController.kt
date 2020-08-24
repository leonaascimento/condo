package com.leonaascimento.condo.features.unit

import com.leonaascimento.condo.features.unit.list.UnitModel
import com.leonaascimento.condo.persistence.UnitRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/units")
class UnitController(val repository: UnitRepository) {

    @GetMapping
    fun list(): ResponseEntity<Iterable<UnitModel>> {
        val homeUnits = repository.findAll().map { UnitModel(it.number, it.size, it.owner) }

        return ResponseEntity.ok(homeUnits)
    }
}
