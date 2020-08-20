package com.leonaascimento.condo.features.homeunit

import com.leonaascimento.condo.features.homeunit.list.HomeUnitModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/units")
class HomeUnitController {

    @GetMapping
    fun list(): ResponseEntity<List<HomeUnitModel>> {
        val homeUnits = listOf(
            HomeUnitModel(1, 100, "John Doe"),
            HomeUnitModel(2, 56, "Martin Brown")
        )

        return ResponseEntity.ok(homeUnits)
    }
}
