package fileSearcher

import java.io.File

import org.scalatest.FlatSpec
//import org.scalatest._ Imports everything from scalatest not just FlatSpec

class FilterCheckerTest extends FlatSpec{
  "FilterChecker passed a list where one file matches the filter" should
  "return a list with that file" in {
    val matchingFile = FileObject(new File("match"))
    val listOfFiles = List(FileObject(new File("random")), matchingFile)
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfFiles
    assert(matchedFiles == List(matchingFile))
  }

  "FilterChecker passed a list with a directory that matches the filer" should
  "not return the directory" in {
    val listOfIOObjects = List(FileObject(new File("random")), DirectoryObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfIOObjects
    assert(matchedFiles.isEmpty)
  }

  "FilterChecker passed a file with content that matches the filter" should
  "return that the match succeeded" in {
    val isContentMatched = FilterChecker("pluralsight")
      .matchesFileContent(new File("./testfiles/pluralsight.data"))
    assert(isContentMatched == true)
  }

  "FilterChecker passed a file with content that does not match the filter" should
  "return that the match failed" in {
    val isContentMatched = FilterChecker("pluralsight")
      .matchesFileContent(new File("./testfiles/readme.txt"))
    assert(isContentMatched == false)
  }
}
