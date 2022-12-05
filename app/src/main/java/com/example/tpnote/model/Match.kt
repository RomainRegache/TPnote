package com.example.tpnote.model

/*@Entity
class Match {
    @PrimaryKey
    var uid = 0

    @ColumnInfo(name = "joueur1")
    var joueur1: String? = null

    @ColumnInfo(name = "joueur2")
    var joueur2: String? = null

    @ColumnInfo(name = "nbSet")
    var nbSet: Int? = null

    @ColumnInfo(name = "listeScore")
    var listScore:List<Int>? = null
}*/

class Match(
    var uid: Int = 0,
    var joueur1: String? = null,
    var joueur2: String? = null,
    var nbSet: Int? = null,
    var listScore: Array<Int>?,
)