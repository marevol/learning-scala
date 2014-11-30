package com.github.tanacasino.nnp


trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    list.init.last
    // list(list.size - 2)
    // list.takeRight(2).head
  }

  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  def length(list: List[Int]): Int = {
    list.length
    // list.size
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def isPalindrome(list: List[Int]): Boolean = {
    list == list.reverse
  }

  def flatten(nested: List[Any]): List[Any] = {
    @scala.annotation.tailrec
    def flatten0(result: List[Any], rest: List[Any]): List[Any] = {
      rest match {
        case Nil => result
        case (x: List[_]) :: xs => flatten0(result, x ::: xs)
        case x :: xs => flatten0(x :: result, xs)
      }
    }
    flatten0(List.empty, nested).reverse
  }

  def compress(list: List[Symbol]): List[Symbol] = {
    @scala.annotation.tailrec
    def compress0(result: List[Symbol], rest: List[Symbol]): List[Symbol] = {
      rest match {
        case Nil => result
        case x :: xs => compress0(x :: result, rest.dropWhile(_ == x))
      }
    }
    compress0(List.empty, list).reverse
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    @scala.annotation.tailrec
    def pack0(result: List[List[Symbol]], rest: List[Symbol]): List[List[Symbol]] = {
      rest match {
        case Nil => result
        case l => l.span(_ == l.head) match {
          case (x, Nil) => x :: result
          case (x, y) => pack0(x :: result, y)
        }
      }
    }
    pack0(List.empty, list).reverse
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    @scala.annotation.tailrec
    def encode0(acc: List[(Int, Symbol)], ls: List[Symbol]): List[(Int, Symbol)] = ls match {
      case Nil => acc.reverse
      case l@head :: _ =>
        val (x, y) = l.span(_ == head)
        encode0((x.size, x.head) :: acc, y)
    }
    encode0(Nil, list)
  }

}


