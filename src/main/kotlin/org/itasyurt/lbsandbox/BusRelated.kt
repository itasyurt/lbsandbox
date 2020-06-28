package org.itasyurt.lbsandbox

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.bus.event.RemoteApplicationEvent
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component


@Component
@RemoteApplicationEventScan
class BusConfig

@Component
class UpdateDataEventListener : ApplicationListener<UpdateDataEvent> {

    @Autowired
    lateinit var state: State

    override fun onApplicationEvent(event: UpdateDataEvent) {
        logger.info("event received")
        state.data = event.newData
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UpdateDataEventListener::class.java)
    }
}

class UpdateDataEvent(source: Any? = "", originService: String, var newData: Int) : RemoteApplicationEvent(source, originService)



