package gameone

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class CrawlingGameoneTeam{
    fun crawlingTeam(teamURL:String): String{
        var result= ""
        try{
            val doc:Document = Jsoup.connect(teamURL).get()
            val tables: List<Element> = doc.select("table")

            for(table in tables){
                result += table.select(".fixed")
            }
        }catch (e:Exception){
            result = "none"
        }
        finally {
            println("Crawling Fin")
        }

        return result
    }

    fun  crawlingTeamTableOptions(teamURL: String):String {
        var result = ""
        try {
            val doc: Document = Jsoup.connect(teamURL).get()
            val tables: List<Element> = doc.select("table")
            for (tr in getTrsInTable(tables)) {
                result += tr.select("td").text()
            }
        } catch (_: Exception) {
        }.toString()
        return result
    }

    private fun getTrsInTable(tables: List<Element>): List<Element> {
        var trs: List<Element> = emptyList()
        for(table in tables){
            trs = table.select("tr")
        }
        return trs
    }

    fun crawlingTeamSpan(teamURL: String):String{
        var result = ""
        try{
            val doc:Document = Jsoup.connect(teamURL).get()
            val spans : List<Element> = doc.select("span")
            for(span in spans){
                result += span.text()
                result += "\n"
            }
        }catch (e:Exception){
            result = e.message.toString()
        }
        return result
    }
}
