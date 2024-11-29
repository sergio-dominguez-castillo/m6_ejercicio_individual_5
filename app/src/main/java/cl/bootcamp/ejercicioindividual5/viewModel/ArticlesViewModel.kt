package cl.bootcamp.ejercicioindividual5.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import cl.bootcamp.ejercicioindividual5.data.ArticlesDataSource
import cl.bootcamp.ejercicioindividual5.model.ArticleList
import cl.bootcamp.ejercicioindividual5.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArticlesViewModel @Inject constructor(private val repository: ArticlesRepository): ViewModel() {

    private val _articles = MutableStateFlow<List<ArticleList>>(emptyList())
    val articles = _articles.asStateFlow()

    init {
        fetchArticles()
    }

    private fun fetchArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getArticles()
            _articles.value = result ?: emptyList()
            //Log.w(TAG, "")
        }
    }

    val articlesPage = Pager(PagingConfig(pageSize = 5)) {
        ArticlesDataSource(repository)
    }.flow.cachedIn(viewModelScope)
}