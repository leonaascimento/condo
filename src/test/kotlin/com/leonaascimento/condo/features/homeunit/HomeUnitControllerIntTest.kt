package com.leonaascimento.condo.features.homeunit

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class HomeUnitControllerIntTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `list all home units`() {
        this.mockMvc.perform(get(HOME_UNIT_PATH))
            .andExpect(status().isOk)
    }

    companion object {
        const val HOME_UNIT_PATH = "/v1/units"
    }
}
