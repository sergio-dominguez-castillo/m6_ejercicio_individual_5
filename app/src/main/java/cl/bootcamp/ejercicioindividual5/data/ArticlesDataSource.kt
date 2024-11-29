package cl.bootcamp.ejercicioindividual5.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cl.bootcamp.ejercicioindividual5.model.ArticleList
import cl.bootcamp.ejercicioindividual5.repository.ArticlesRepository

class ArticlesDataSource(private val repository: ArticlesRepository): PagingSource<Int, ArticleList>() {
    override fun getRefreshKey(state: PagingState<Int, ArticleList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleList> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = repository.getArticlesPaging(nextPageNumber, 5)
            LoadResult.Page(
                data = response.articles,
                prevKey = null,
                nextKey = if (response.articles.isNotEmpty()) nextPageNumber + 1 else null
            )

        } catch (e:Exception) {
            LoadResult.Error(e)
        }
    }
}