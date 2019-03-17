package fr.iim.iwm.a5.mesfioui.camil.kotlin.templates

import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article
import kotlinx.html.*

fun HTML.indexTemplate(articles: List<Article>) {
    head{
        title("Liste des article")
    }

    body {
        h1{+"Liste des articles:"}
        articles.forEach{
            p {
                a(href = "/article/${it.id}") {
                    +it.title
                }
            }
        }
    }
}