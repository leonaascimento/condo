package com.leonaascimento.condo.features.unit

import com.leonaascimento.condo.persistence.UnitRepository
import com.leonaascimento.condo.persistence.UnitTable
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@WebMvcTest(UnitController::class)
class UnitTableControllerTest {

    @MockBean
    private lateinit var repository: UnitRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `list units as json`() {
        val units = listOf(
            UnitTable(UUID.randomUUID(), 1, 100.1, "John Doe"),
            UnitTable(UUID.randomUUID(), 2, 56.0, "Martin Jones")
        )
        given(repository.findAll()).willReturn(units)

        val unitsJson = """
            [
                { "number":1, "size":100.1, "owner": "John Doe" },
                { "number":2, "size":56, "owner": "Martin Jones" }
            ]
        """.trimIndent()
        mockMvc.perform(get("/v1/units"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(unitsJson))
    }
}
