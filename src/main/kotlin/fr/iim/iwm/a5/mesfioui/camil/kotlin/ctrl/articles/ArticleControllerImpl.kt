package fr.iim.iwm.a5.mesfioui.camil.kotlin.ctrl.articles

import fr.iim.iwm.a5.mesfioui.camil.kotlin.models.Model
import fr.iim.iwm.a5.mesfioui.camil.kotlin.templates.ArticleTemplate
import fr.iim.iwm.a5.mesfioui.camil.kotlin.templates.adminArticleTemplate
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.HttpStatusCode
import io.ktor.html.HtmlContent

class ArticleControllerImpl(private val model: Model) : ArticleController {

    override fun  startHD(id: Int): Any {
        val article = model.getArticle(id)
        val comments = model.getComments(id)
        if (article !== null) {
            return  HtmlContent { ArticleTemplate(article, comments)}
        }
        return HttpStatusCode.NotFound
    }

    override fun  adminStartHD(id: Int): Any {
        val article = model.getArticle(id)
        val comments = model.getComments(id)
        if (article !== null) {
            return  HtmlContent { adminArticleTemplate(article, comments)}
        }
        return HttpStatusCode.NotFound
    }

    override fun insertArticle(title: String, description: String) {
        model.insertArticle(title, description)
    }

    override fun deleteArticle(id: Int): Any {
        model.deleteArticle(id)
        return true
    }
}