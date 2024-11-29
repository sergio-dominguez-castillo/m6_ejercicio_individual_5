package cl.bootcamp.ejercicioindividual5.model

data class ArticlesModel(
    // val status: String,
    // val totalResults: Int,
    val articles: List<ArticleList>
)

data class ArticleList(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)

data class Source(
    // val id: Int?,
    val name: String
)