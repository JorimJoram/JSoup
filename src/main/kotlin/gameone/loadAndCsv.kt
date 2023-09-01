package gameone

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.BufferedWriter
import java.io.FileWriter
import java.lang.StringBuilder

class loadAndCsv(
    private var teamURL:String
) {
    fun loadAndCsv(){
        val doc = Jsoup.connect(teamURL).get()
        val table = doc.select("table")
        println(table)

        val writer = BufferedWriter(FileWriter("/Users/janghyolim/code/JSoup/src/main/kotlin/csv/table_data.csv"))
        val row = table.select("tr")
        for(item in row){
            val thCell = item.select("th")
            val tdCell = item.select("td")
            val cells = thCell + tdCell

            val csvLine = StringBuilder()

            for(cell in cells){
                csvLine.append(cell.text()).append(",")
            }
            csvLine.deleteCharAt(csvLine.length - 1)
            csvLine.append("\n")
            writer.write(csvLine.toString())
            //println(csvLine)
        }
        writer.close()
        println("load Fin")
    }
}