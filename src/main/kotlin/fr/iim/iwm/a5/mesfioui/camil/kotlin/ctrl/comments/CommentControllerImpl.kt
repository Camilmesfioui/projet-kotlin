package fr.iim.iwm.a5.mesfioui.camil.kotlin.ctrl.comments

import fr.iim.iwm.a5.mesfioui.camil.kotlin.models.Model

class CommentControllerImpl(private val model: Model) : CommentController {
    override fun insertComment(text: String, article_id: Int) {
        model.insertComment(text, article_id)
    }

    override fun deleteComment(id: Int): Any {
        model.deleteComment(id)
        return true
    }
}