package cl.bootcamp.ejercicioindividual5.repository

import cl.bootcamp.ejercicioindividual5.data.ApiArticles
import cl.bootcamp.ejercicioindividual5.model.ArticleList
import cl.bootcamp.ejercicioindividual5.model.ArticlesModel
import javax.inject.Inject

class ArticlesRepository @Inject constructor(private val apiArticles: ApiArticles) {

    suspend fun getArticles(): List<ArticleList>? {
        val response = apiArticles.getArticles()
        if (response.isSuccessful) {
            return response.body()?.articles
        }
        return null
    }

    suspend fun getArticleByName(name: String): ArticlesModel? {
        val response = apiArticles.getArticleByName(name)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getArticlesPaging(page: Int, pageSize: Int): ArticlesModel {
        return apiArticles.getArticlesPaging(page, pageSize)
    }
}