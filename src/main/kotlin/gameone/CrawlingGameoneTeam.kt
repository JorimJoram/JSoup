package gameone

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class CrawlingGameoneTeam(
    private var teamURL: String
){
    fun crawlingTeam(): String{
        return try{
            val doc:Document = Jsoup.connect(this.teamURL).get()
            val tables:List<Element> = doc.select("table")
            tables.joinToString(separator = ""){ //각 테이블의 내용을 하나의 문자열로 연결
                table -> table.select(".fixed").toString()
            }
        }catch(e:Exception){
            "none"
        }finally{
            println("Crawling Fin")
        }
    }

    fun crawlingTeamTableOptions():String {
        var result = ""
        try {
            val doc: Document = Jsoup.connect(this.teamURL).get()
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

    fun crawlingTeamSpan():String{
        var result = ""
        try{
            val doc:Document = Jsoup.connect(this.teamURL).get()
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
