package org.ldv.ecommerce.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController {
    @GetMapping("/e-commerce/admin/dashboard")
    fun home(): String {
        return "pageAdmin/dashboard"
    }
}
