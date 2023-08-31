import gameone.CrawlingGameoneTeam

fun main(args: Array<String>) {
    val crawling = CrawlingGameoneTeam()
    //println(crawling.crawlingTeam("http://www.gameone.kr/club/info/ranking/hitter?club_idx=14106"))
    //println(crawling.crawlingTeamSpan("http://www.gameone.kr/club/info/ranking/hitter?club_idx=14106"))
    println(crawling.crawlingTeamTableOptions("http://www.gameone.kr/club/info/ranking/hitter?club_idx=14106"))

}