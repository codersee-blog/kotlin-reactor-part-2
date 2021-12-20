package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoDeferNull {

    fun nullReturningDateFetching(): LocalDateTime? {
        Thread.sleep(500)
        println("GETTING DATE")
        return null
    }

    fun monoDeferNull(): Mono<LocalDateTime> =
        Mono.defer { null }

    fun monoDeferSubscription() {
        val myMono = monoDeferNull()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }

    fun monoDeferSubscriptionRecover() {
        val myMono =
            monoDeferNull()
                .onErrorReturn(LocalDateTime.MIN)

        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }
}
