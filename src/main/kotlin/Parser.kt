import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class Parser {
    fun run(html: String): Int {
        val doc: Document = Jsoup.parse(html)
        val drugs: List<Element> = doc.select(".body-card").toList()
        val prices: List<Int> = drugs.mapNotNull {
            it.select(".prices > div:nth-child(2)>span:nth-child(2)").text().substringBefore(" ₽").toIntOrNull()
        }
        val minPrice = prices.toIntArray().min()
        return minPrice
    }
}
