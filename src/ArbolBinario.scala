
object Arbol{
  /**
 * @param De 0 a n valores como entrada para introducir al arbol.
 * @return Tipo NodoBin, el arbol binario con sus nodos.
 */
  def apply[A<%Ordered[A]](s:A*):Arbol[A]={
    val c = (s toList).sortWith(_<_)
    if(c isEmpty)Vacio
    else if(c.length==1)NodoBin(s.head,Vacio,Vacio)
    else {
      val(i,d)= c.splitAt(c.length/2)
      val xs = d.tail
      NodoBin(d.head,apply(i:_*),apply(xs:_*))
    }
  }
 /**
 * @param De 0 a n valores en formato lista como entrada para introducir al arbol.
 * @return Tipo NodoBin, el arbol binario con sus nodos.
 */
  def apply[A<%Ordered[A]](s:List[A]):Arbol[A]={
    val c = (s).sortWith(_<_)
    if(c isEmpty)Vacio
    else if(c.length==1)NodoBin(s.head,Vacio,Vacio)
    else {
      val(i,d)= c.splitAt(c.length/2)
      val xs = d.tail
      NodoBin(d.head,apply(i:_*),apply(xs:_*))
    }
  }
}
sealed trait Arbol[+A]{
 /**
 * @return True si esta vacio.
 */
  def isEmpty:Boolean= this match{
    case Vacio => true
    case _ => false
  }
 /**
 * @return Devuelve 0 si esta vacío, sino su número de nodos.
 */
  def size:Int=this match{
    case Vacio => 0
    case NodoBin(valor,i,d) => 1 + i.size + d.size 
  }
  /**
 * @return Devuelve 0 si esta vacío, sino el número de niveles.
 */
  def depth:Int = this match{
    case Vacio=>0
    case NodoBin(valor,izq,der)=>{ 
      if((der.depth) > (izq.depth)) 
        1 + der.depth
      else 
        1 + izq.depth
    }    
  }
  /**
 * @param Elemento a buscar.
 * @return None si no lo encuentra, Some con el número encontrado.
 */
   def findElem[B>:A<%Ordered[B]](elem:B):Option[B]=this match{
    case Vacio=> None
    case NodoBin(valor,i,d) if(elem==valor)=> Some(elem)
    case NodoBin(valor,izq,der)=> {
      val i = izq findElem(elem) 
      if(i==None) 
        der findElem(elem)
      else 
        i
    }
  }
    /**
 * @return None si esta vacío, Some con el mayor número del arbol.
 */
   def max:Option[A]=this match{
    case Vacio=> None
    case NodoBin(valor,izq,der) => {
      if(der == Vacio)
        Some(valor)
      else 
        der max   
    }
  }
    /**
 * @param Función a aplicar.
 * @return Nuevo arbol con la función aplicada sobre cada nodo individualmente.
 */
    def map[B](f:A=>B):Arbol[B]= this match{
      case Vacio => Vacio
      case NodoBin(valor,izq,der)=> NodoBin(f(valor),izq map (f),der map (f))
  } 
      /**
 * @param Función a aplicar.
 * @return Resultado de aplicar el algoritmo foldRigth sobre el arbol.
 */
  def foldRigth[B](z:B)(f:(A,B)=>B):B=this match{
    case Vacio=>z    
    case NodoBin(valor,izq,der)=> {
      val in = der.foldRigth(z)(f)
      if (izq == Vacio)
        f(valor,in)
      else 
        izq.foldRigth(f(valor,in))(f)
    }
  }
  /**
 * @param Función a aplicar.
 * @return Resultado de aplicar el algoritmo foldLeft sobre el arbol.
 */
  def foldLeft[B](z:B)(f:(B,A)=>B):B=this match{
    case Vacio=>z    
    case NodoBin(valor,izq,der)=> {
      val in = der.foldLeft(z)(f)
      if (izq == Vacio)
        f(in,valor) 
      else 
        izq.foldLeft(f(in,valor))(f)
    }
  }
 /**
 * @return Devuelve Nil si esta vacio, o una lista con los nodos del arbol.
 */
  def toList:List[A] = this match{
    case Vacio=> Nil
    case NodoBin(valor,izq,der) => List(valor):::(izq.toList):::(der.toList)  
  }
  /**
 * @param Elemento a introducir en el nuevo arbol.
 * @return Nuevo arbol binario con los elementos del arbol anterior y el elemento introducido.
 */
   def addOrdBalanced[B>:A<%Ordered[B]](elem:B):Arbol[B]= this match{
      case Vacio => Arbol.apply(elem)
      case NodoBin(valor,izq,der) => Arbol(this.toList.::(elem))
   }
 
}
case class NodoBin[A](valor:A ,  izq:Arbol[A] , der:Arbol[A]) extends Arbol[A]
case object Vacio extends Arbol[Nothing]

