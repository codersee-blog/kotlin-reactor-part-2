package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoDeferException {

    fun exceptionDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        throw RuntimeException("ERRORS HAPPEN")
    }

    fun monoJustException(): Mono<LocalDateTime> =
        Mono.just(exceptionDateFetching())

    fun monoDeferException(): Mono<LocalDateTime> =
        Mono.defer { monoJustException() }

    fun monoDeferExceptionSubscription() {
        val myMono = monoDeferException()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }
}
