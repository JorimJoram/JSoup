import gameone.CrawlingGameoneTeam
import gameone.loadAndCsv

/**
 * 소스코드 작성 시, 문제 발생 -> 라이브러리 로드 안된 경우일 가능성 높음 -> Project Structure 확인 바람
 */
fun main(args: Array<String>) {
    //val crawling = CrawlingGameoneTeam("http://www.gameone.kr/club/info/ranking/hitter?club_idx=14106")
    //println(crawling.crawlingTeam())
    //println(crawling.crawlingTeamSpan("http://www.gameone.kr/club/info/ranking/hitter?club_idx=14106"))
    //println(crawling.crawlingTeamTableOptions("http://www.gameone.kr/club/info/ranking/hitter?club_idx=14106"))
    val crawling = loadAndCsv("http://www.gameone.kr/club/info/ranking/hitter?club_idx=14106&kind=&season=2022")
    crawling.loadAndCsv()
}