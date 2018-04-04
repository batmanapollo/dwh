import java.time.LocalDate

import scala.collection.immutable.ListMap
import scala.collection.mutable.ListBuffer

object Searcher {

  def searchBackdatedInsertions(data: ListMap[Int, LocalDate]): List[Int] = {
    if (data.isEmpty)
      List.empty[Int]
    else {
      var ids = new ListBuffer[Int]()
      var maxDate = data.head._2

      data.foreach {
        case (key, value) => if (value.isBefore(maxDate)) ids += key else maxDate = value
      }

      ids.toList
    }

  }

}
