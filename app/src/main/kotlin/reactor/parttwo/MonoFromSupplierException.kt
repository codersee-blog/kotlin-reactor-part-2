package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoFromSupplierException {

    fun exceptionDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        throw RuntimeException("ERRORS HAPPEN")
    }

    fun monoFromSupplierException(): Mono<LocalDateTime> =
        Mono.fromSupplier { exceptionDateFetching() }

    fun monoFromSupplierExceptionSubscription() {
        val myMono = monoFromSupplierException()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }
}
