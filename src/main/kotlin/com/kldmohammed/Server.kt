package com.kldmohammed

import com.hexagonkt.http.httpDate
import com.hexagonkt.http.server.Server
import com.hexagonkt.http.server.ServerPort
import com.hexagonkt.http.server.jetty.JettyServletAdapter
import com.hexagonkt.injection.InjectionManager.bindObject


val server: Server by lazy {
    Server {
        before {
            response.setHeader("Date", httpDate())
            get("/hello/{name}") { ok("Hello, ${pathParameters["name"]}!", "text/plain") }

        }
    }
}


/**
 * Start the service from the command line.
 */
fun main() {
    bindObject<ServerPort>(JettyServletAdapter()) // Bind Jetty server to HTTP Server Port
    server.start()
}