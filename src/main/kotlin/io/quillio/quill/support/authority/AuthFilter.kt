package io.quillio.quill.support.authority

import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class AuthFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        // 필터 로직 구현
        // chain.filter(exchange) 호출을 통해 다음 필터 또는 핸들러로 요청을 전달
        return chain.filter(exchange)
    }

}