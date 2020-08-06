import org.springframework.boot.logging.logback.ColorConverter
import org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter

import java.nio.charset.StandardCharsets

conversionRule 'clr', ColorConverter
conversionRule 'wex', WhitespaceThrowableProxyConverter

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = StandardCharsets.UTF_8

        pattern = "%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %level %logger - %msg%n"
    }

    logger("org.hibernate", WARN, [], false)
    logger("org.ehcache", WARN, [], false)
    logger("org.apache.cxf.transport.https.SSLUtils", WARN, [], false)
    logger("org.apache.tomcat.jdbc.pool.ConnectionPool", ALL, [], false)
    logger("grails.app.services", INFO, ['STDOUT'], true)
    logger("grails.app.controllers", INFO, ['STDOUT'], true)
    logger("grails.app.domain", INFO, ['STDOUT'], true)
}

root(ERROR, ['STDOUT'])
root(INFO, ['STDOUT'])
