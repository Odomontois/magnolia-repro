import magnolia.{CaseClass, Magnolia, SealedTrait}

trait Description[A]{
  def describe(a: A) : String
}

object Description{
  type Typeclass[A] = Description[A]

  def combine[T](caseclass: CaseClass[Typeclass, T]): Typeclass[T] =
    _ => caseclass.typeName.short

  def dispatch[T](sealedTrait: SealedTrait[Typeclass, T]): Typeclass[T] =
    _ => sealedTrait.subtypes.map(_.typeName.short).mkString("|")

  def generate[A]: Typeclass[A] = macro Magnolia.gen[A]
}



object Magnodule {
  sealed trait Q
  sealed trait S

  final case class Egg(contains: Chicken) extends Q
  final case class Chicken(lays: Egg) extends S

  val describeQ: Description[Q] = Description.generate
  val describeS: Description[S] = Description.generate

}
