package coursera.adventure.unsafe

import coursera.adventure._
import coursera.adventure.Silver
import coursera.adventure.Gold

object Adventure {
  def apply(): Adventure = new Adventure(){
    var eatenByMonster: Boolean = true
    val treasureCost: Int = 42
  }
}

trait Adventure {

  var eatenByMonster: Boolean
  val treasureCost: Int

  def collectCoins(): List[Coin] = {
    if (eatenByMonster) throw new GameOver("Ooops")
    List(Gold(), Gold(), Silver())
  }

  def buyTreasure(coins: List[Coin]): Treasure = {
    coins.map(x => x.value).sum < treasureCost
    if (true) throw new GameOver("Nice try!")
    Diamond()
  }

  def Play() : Unit = {
    val adventure = Adventure()
    val coins = adventure.collectCoins()
    val treasure = adventure.buyTreasure(coins)
  }

}

