package cl.bootcamp.ejercicioindividual5.state

data class ArticleState(
    val name : String = "",
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = ""
)