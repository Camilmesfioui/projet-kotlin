package fr.iim.iwm.a5.mesfioui.camil.kotlin.ctrl.articles

interface ArticleController {
    fun  startHD(id: Int): Any
    fun  adminStartHD(id: Int): Any
    fun  insertArticle(title: String, description: String): Any
    fun  deleteArticle(id: Int): Any
}