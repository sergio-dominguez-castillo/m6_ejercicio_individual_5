package cl.bootcamp.ejercicioindividual5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.ejercicioindividual5.view.DetailView
import cl.bootcamp.ejercicioindividual5.view.HomeView
import cl.bootcamp.ejercicioindividual5.viewModel.ArticlesViewModel

@Composable
fun NavManager(viewModel: ArticlesViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(viewModel, navController)
        }

        composable("Detail/{name}/?{author}/?{title}/?{title}/?{description}?/{url}/?{urlToImage}", arguments = listOf(
            navArgument("name") { type = NavType.StringType },
            navArgument("author") { type = NavType.StringType },
            navArgument("title") { type = NavType.StringType },
            navArgument("description") { type = NavType.StringType },
            navArgument("url") { type = NavType.StringType },
            navArgument("urlToImage") { type = NavType.StringType }

        )) {
            val name = it.arguments?.getString("name") ?: ""
            val author = it.arguments?.getString("author") ?: ""
            val title = it.arguments?.getString("title") ?: ""
            val description = it.arguments?.getString("description") ?: ""
            val url = it.arguments?.getString("url") ?: ""
            val urlToImage = it.arguments?.getString("urlToImage") ?: ""
            DetailView(viewModel, navController, name, author, title, description, url, urlToImage)
        }
//        composable("SearchGameView") {
//            SearchGameView(viewModel, navController)
//        }
    }
}


