import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

import org.scalatest.FunSuite

import scala.collection.immutable.ListMap

class SearcherSuite extends FunSuite {

  test("searcher result should have only backdated insertions ids") {

    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd", Locale.ENGLISH)

    val data = ListMap(
      1 -> LocalDate.parse("2016.09.11", formatter),
      2 -> LocalDate.parse("2016.09.12", formatter),
      3 -> LocalDate.parse("2016.09.13", formatter),
      4 -> LocalDate.parse("2016.09.14", formatter),
      5 -> LocalDate.parse("2016.09.09", formatter),
      6 -> LocalDate.parse("2016.09.08", formatter),
      7 -> LocalDate.parse("2016.09.15", formatter),
      8 -> LocalDate.parse("2016.09.13", formatter)
    )
    val actual = Searcher.searchBackdatedInsertions(data)

    assert(List(5, 6, 8) == actual)
  }
}
