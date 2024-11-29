package cl.bootcamp.ejercicioindividual5.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import cl.bootcamp.ejercicioindividual5.components.CardArticle
import cl.bootcamp.ejercicioindividual5.components.Loader
import cl.bootcamp.ejercicioindividual5.components.MainTopBar
import cl.bootcamp.ejercicioindividual5.ui.theme.customBlack
import cl.bootcamp.ejercicioindividual5.viewModel.ArticlesViewModel

@Composable
fun HomeView(
    viewModel: ArticlesViewModel,
    navController: NavController
) {

    Scaffold(
        topBar = {
            MainTopBar(title = "API Articles", onClickBackButton = {})
        }
    ) {
        ContentHomeView(it, viewModel, navController)
    }
}

@Composable
fun ContentHomeView(
    paddingValues: PaddingValues,
    viewModel: ArticlesViewModel,
    navController: NavController
) {
    val articlesPage = viewModel.articlesPage.collectAsLazyPagingItems()
    Column(
        modifier = Modifier
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyColumn(
            modifier = Modifier
                .background(customBlack)
        ) {
            items(articlesPage.itemCount) { index ->
                val item = articlesPage[index]



                if (item != null) {
                    CardArticle(item) {
                        navController.navigate(
                            "Detail/${item.source.name}/?" +
                                    "${item.author}/?" +
                                    "${item.title}/?" +
                                    "${item.description}/?" +
                                    "${item.url}/?" +
                                    "${item.urlToImage}/?"
                        )
                    }
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
            }
            when (articlesPage.loadState.append) {
                is LoadState.NotLoading -> Unit
                LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Loader()
                        }
                    }
                }

                is LoadState.Error -> {
                    item {
                        Text(text = "Error al cargar los datos")
                    }
                }
            }

        }

    }
}
