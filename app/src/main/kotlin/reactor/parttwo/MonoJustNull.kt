package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoJustNull {

    fun nullReturningDateFetching(): LocalDateTime? {
        Thread.sleep(500)
        println("GETTING DATE")
        return null
    }

    fun monoJustNull(): Mono<LocalDateTime> =
        Mono.just(nullReturningDateFetching())

    fun monoJustNullSubscription() {
        val myMono = monoJustNull()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }

    fun monoJustNullInstantiation() {
        val myMono = monoJustNull()
    }

    fun monoJustOrEmptyNull(): Mono<LocalDateTime> =
        Mono.justOrEmpty(nullReturningDateFetching())
}
