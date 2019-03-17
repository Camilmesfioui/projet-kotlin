package fr.iim.iwm.a5.mesfioui.camil.kotlin.templates

import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article
import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Comment
import kotlinx.html.*

fun HTML.adminArticleTemplate(article: Article, comments: List<Comment>) {
    head{
        title(article.title)
    }

    body {
        h1{ +article.title}
        p{ +article.description!! }

        h2{+"Commentaires:"}
        ul {
            comments.forEach{
                li {
                    +it.text
                    span {+ " | " }
                    a(href = "/admin/comment/${article.id}/${it.id}/delete") {
                        text(" [supprimer]")
                    }
                }
            }
        }
    }
}
