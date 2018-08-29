import java.time.LocalDate

object Searcher {

  def searchBackdatedInsertions(data: Map[Int, LocalDate]): List[Int] = {
    def isBackdate(id: Int, date: LocalDate) = {
      data.filterKeys(_ < id).exists(date isBefore _._2)
    }

    data.foldLeft(List[Int]()) {
      case (acc, (id, date)) => if (isBackdate(id, date)) id :: acc else acc
    }
  }
}
