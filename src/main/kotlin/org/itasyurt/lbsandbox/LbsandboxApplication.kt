package org.itasyurt.lbsandbox


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.bus.BusProperties
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class LbsandboxApplication

fun main(args: Array<String>) {
    runApplication<LbsandboxApplication>(*args)
}

@RestController
@RequestMapping("/api")
class DummyController {

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Autowired
    lateinit var busProperties: BusProperties

    @Autowired
    lateinit var state:State

    @RequestMapping("", method = [RequestMethod.GET])
    fun getResult(): Int {
        return state.data
    }

    @RequestMapping("", method = [RequestMethod.PUT])
    fun updateData(@RequestParam newData: Int) {
        val id = busProperties.id
        val event = UpdateDataEvent(this, id, newData)
        applicationContext.publishEvent(event)

    }

}

@Component
class State {

    var data = 10

}


