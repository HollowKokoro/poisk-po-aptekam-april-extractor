fun main() {
    val html: String = Consumer().run()
    val producer = Producer()
    val price: Int = Parser().run(html)
    producer.send(price, "apteka-april.ru")
    producer.close()
}
