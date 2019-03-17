package fr.iim.iwm.a5.mesfioui.camil.kotlin.models

import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article
import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Comment

interface Model {
    /* Articles */
    fun insertArticle(title: String, description: String)
    fun getArticleList(): List<Article>
    fun getArticle(id: Int): Article?
    fun deleteArticle(id: Int): Any
    /* Comments */
    fun getComments(article_id: Int): List<Comment>
    fun insertComment(text: String, article_id: Int)
    fun deleteComment(id: Int): Any
}
