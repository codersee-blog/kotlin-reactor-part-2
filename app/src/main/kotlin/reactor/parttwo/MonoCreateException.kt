package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoCreateException {

    fun exceptionDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        throw RuntimeException("ERRORS HAPPEN")
    }

    fun monoCreateException(): Mono<LocalDateTime> =
        Mono.create { monoSink -> monoSink.success(exceptionDateFetching()) }

    fun monoCreateExceptionSubscription() {
        val myMono = monoCreateException()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }
}
