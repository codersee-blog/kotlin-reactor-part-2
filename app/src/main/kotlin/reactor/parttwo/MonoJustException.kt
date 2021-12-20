package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoJustException {

    fun exceptionDateFetching(): LocalDateTime {
        Thread.sleep(500)
        println("GETTING DATE")
        throw RuntimeException("ERRORS HAPPEN")
    }

    fun monoJustException(): Mono<LocalDateTime> =
        Mono.just(exceptionDateFetching())

    fun monoJustExceptionSubscription() {
        val myMono = monoJustException()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }
}
