package fr.iim.iwm.a5.mesfioui.camil.kotlin.models

import fr.iim.iwm.a5.mesfioui.camil.kotlin.ConnectionPool
import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article
import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Comment

class MysqlModel(url: String, user: String?, password: String?) : Model {

    val connectionPool = ConnectionPool(url, user, password)


    override fun getArticleList(): List<Article> {
        val articles = ArrayList<Article>()
        connectionPool.use { connection ->
            val stmt = connection.prepareStatement("SELECT * FROM articles")
            val results = stmt.executeQuery()

            while (results.next()) {
                articles.add(
                    Article(
                        results.getInt("id"),
                        results.getString("title")
                    )
                )
            }
        }
        return articles
    }

    override fun getArticle(id: Int): Article? {
        connectionPool.use { connection ->
            val stmt = connection.prepareStatement("SELECT * FROM articles WHERE id = ?")
            stmt.setInt(1, id)
            val results = stmt.executeQuery()
            val found = results.next()
            if (found) {
                return Article(
                    results.getInt("id"),
                    results.getString("title"),
                    results.getString("description")
                )
            }
        }
        return null
    }

    /* Add Overide getComment Methode */
    override fun getComments(article_id: Int): List<Comment> {
        val comments = ArrayList<Comment>()
        connectionPool.use { connection ->
            val stmt = connection.prepareStatement("SELECT * FROM comments WHERE article_id = ?")
            stmt.setInt(1, article_id)
            val results = stmt.executeQuery()

            while (results.next()) {
                comments.add(
                    Comment(
                        results.getInt("id"),
                        results.getString("text"),
                        results.getInt("article_id")
                    )
                )
            }

        }
        return comments
    }

    override fun insertArticle(title: String, description: String) {
        connectionPool.use { connection ->
            val stmt = connection.prepareStatement("INSERT INTO articles (title, description) VALUES (?, ?)")
            stmt.setString(1, title)
            stmt.setString(2, description)
            stmt.executeUpdate()
        }
    }

    override fun deleteArticle(id: Int) {
        connectionPool.use {connection ->
            val stmt = connection.prepareStatement("DELETE FROM comments where article_id = ?")
            stmt.setInt(1, id)
            stmt.executeUpdate()
        }
        connectionPool.use {connection ->
            val stmt = connection.prepareStatement("DELETE FROM articles where id = ? ")
            stmt.setInt(1, id)
            stmt.executeUpdate()
        }
    }

    /* Add Overide getComment Methode */
    override fun insertComment(text: String, article_id: Int) {
        connectionPool.use { connection ->
            val stmt = connection.prepareStatement("INSERT INTO comments (text, article_id) VALUES (?, ?)")
            stmt.setString(1, text)
            stmt.setInt(2, article_id)
            stmt.executeUpdate()
        }
    }

    /* Delete Comments */
    override fun deleteComment(id: Int) {
        connectionPool.use {connection ->
            val stmt = connection.prepareStatement("DELETE FROM comments where id = ?")
            stmt.setInt(1, id)
            stmt.executeUpdate()
        }
    }
}