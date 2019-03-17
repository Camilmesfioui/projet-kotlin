package fr.iim.iwm.a5.mesfioui.camil.kotlin

import fr.iim.iwm.a5.mesfioui.camil.kotlin.models.MysqlModel
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ModelTests {

    val model = MysqlModel("jdbc:h2:mem:kotlin;MODE=MYSQL", null, null)


    @Before
    fun initDB() {
        model.connectionPool.use {connection ->
            connection.prepareStatement("""
DROP TABLE IF EXISTS 'articles';
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO-INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
);
INSERT INTO `articles` (`id`, `title`, `description`) VALUES
(1, 'Titre 1', 'Ceci est le contenu 1'),
(2, 'Titre 2', 'Ceci est le contenu 2');
            """).use { stmt ->
                stmt.execute()
            }
        }
    }

    @Test
    fun testArticleInDB() {
        val article = model.getArticle(1)
        assertNotNull(article)
        assertEquals(1, article.id)
        assertEquals("Premier Article", article.title)
        assertTrue(article.description !! .startsWith("Ceci est"))
    }
}