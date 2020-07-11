

object Aplicacion extends App{
  val A = Arbol.apply(1,2,3)
  val B = Arbol.apply()
  println("¿Arbol A vacio? :"+A.isEmpty)
  println("¿Arbol B vacio? :"+B.isEmpty)
  println("Tamaño A : "+A.size)
  println("Profundidad A : "+A.depth)
  println("Encontrar el 1 en A : "+A.findElem(1))
  println("Encontrar el máximo en A : "+A.max)
  println("Multiplicar por dos A :\n  "+A.map(_*2))
  println("Resultado del algo. FoldLeft restando aplicado al arbol A : "+A.foldLeft(0)(_-_))
  println("Resultado del algo. FoldRigth restando aplicado al arbol A : "+A.foldRigth(0)(_-_))
  println("Listar A : \n  "+A.toList)
  println("Añadir el elemnto 0 al arbol A : \n  "+A.addOrdBalanced(0))
}