package fileSearcher

import java.io.File

class FilterChecker (filter: String){
  def matches(content: String) = content contains filter

  def findMatchedFiles(iOObjects : List[IOObject]) =
    for (iOObject <- iOObjects
      if(iOObject.isInstanceOf[FileObject])
      if(matches(iOObject.name)))
    yield iOObject

  def matchesFileContent(file: File) = {
    import scala.io.Source
    try {
      val fileSource = Source.fromFile(file)
      try
      catch{
        case NonFatal(_) => false
      }
      finally
        fileSource.close()
    }
    catch {
      case NonFatal(_) => false
    }
  }
}

object FilterChecker {
  def apply(filter:String) = new FilterChecker(filter)
}
