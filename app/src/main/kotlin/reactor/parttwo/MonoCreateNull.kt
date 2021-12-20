package reactor.parttwo

import reactor.core.publisher.Mono
import java.time.LocalDateTime


class MonoCreateNull {

    fun nullReturningDateFetching(): LocalDateTime? {
        Thread.sleep(500)
        println("GETTING DATE")
        return null
    }

    fun monoCreateNull(): Mono<LocalDateTime> =
        Mono.create { monoSink -> monoSink.success(nullReturningDateFetching()) }

    fun monoCreateNullSubscription() {
        val myMono = monoCreateNull()
        myMono.subscribe(::println)
        myMono.subscribe(::println)
        myMono.subscribe(::println)
    }
}
