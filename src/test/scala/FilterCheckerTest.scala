package fileSearcher

import org.scalatest.FlatSpec
//import org.scalatest._ Imports everything from scalatest not just FlatSpec

class FilterCheckerTest extends FlatSpec{
  "FilterChecker passed a list where one file matches the filter" should
  "return a list with that file" in {
    val matchingFile = new FileObject("match")
    val listOfFiles = List(new FileObject("random"), matchingFile)
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfFiles
    assert(matchedFiles == List(matchingFile))
  }

  "FilterChecker passed a list with a directory that matches the filer" should
  "not return the directory" in {
    val listOfIOObjects = List(new FileObject("random"), new DirectoryObject("match"))
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfIOObjects
    assert(matchedFiles.isEmpty)
  }
}
