package fr.iim.iwm.a5.mesfioui.camil.kotlin.templates

import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article
import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Comment
import kotlinx.html.*

fun HTML.ArticleTemplate(article: Article, comments: List<Comment>) {
    head{
        title("liste des articles")
    }

    body {
        h1 { +article.title }
        p { +article.description!! }
        /* Display comments */
        ul {
            comments.forEach{
                li { +it.text }
            }
        }

        /* Add form action for comments submit */
        form(action = "/comments/add", encType = FormEncType.multipartFormData,
            method = FormMethod.post) {
            textInput(name = "text")
            hiddenInput{name = "article_id"; value = article.id.toString()}
            submitInput()
        }
    }
}