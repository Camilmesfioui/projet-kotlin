package fr.iim.iwm.a5.mesfioui.camil.kotlin.ctrl.comments

interface CommentController {
    fun  insertComment(text: String, article_id: Int): Any
    fun  deleteComment(id: Int): Any
}