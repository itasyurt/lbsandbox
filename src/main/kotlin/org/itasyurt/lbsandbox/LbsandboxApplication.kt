package org.itasyurt.lbsandbox

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class LbsandboxApplication

fun main(args: Array<String>) {
    runApplication<LbsandboxApplication>(*args)
}

@RestController
@RequestMapping("/api")
class DummyController {

    var data = 10

    @RequestMapping("", method = [RequestMethod.GET])
    fun getResult(): Int {
        return data
    }

    @RequestMapping("", method = [RequestMethod.PUT])
    fun updateData(@RequestParam newData: Int) {
        this.data = newData
    }

}


