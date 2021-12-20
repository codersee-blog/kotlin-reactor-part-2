package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoFromSupplierNull {

    fun nullReturningDateFetching(): LocalDateTime? {
        Thread.sleep(500)
        println("GETTING DATE")
        return null
    }

    fun monoFromSupplierNull(): Mono<LocalDateTime> =
        Mono.fromSupplier { nullReturningDateFetching() }

    fun monoFromSupplierSubscription() {
        val myMono = monoFromSupplierNull()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }

    fun monoFromSupplierRecover() {
        val myMono =
            monoFromSupplierNull()
                .defaultIfEmpty(LocalDateTime.MIN)

        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }
}
