package com.example.crowncompose.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.crowncompose.ui.theme.CrownComposeTheme

//@OptIn(ExperimentalMaterial3Api::class)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrownApp() {
    CrownComposeTheme() {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                NavigationBar() {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    navItems.forEach { screen ->
                        NavigationBarItem(
                            icon = {
                                if (screen.badgeCount > 0) {
                                    BadgedBox(badge = {
                                        Badge(
                                            containerColor = MaterialTheme.colorScheme.error,
                                            contentColor = MaterialTheme.colorScheme.onError
                                        ) {
                                            Text(text = screen.badgeCount.toString())
                                        }
                                    }) {
                                        Icon(screen.icon, contentDescription = null)
                                    }
                                } else {
                                    Icon(screen.icon, contentDescription = null)
                                }
                            },
                            label = { Text(stringResource(screen.name)) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = WhatsOn.route,
                modifier = Modifier.padding(innerPadding)) {
                composable(WhatsOn.route) { WhatsOn.screen() }
                composable(Rewards.route) { Rewards.screen() }
                composable(Notification.route) { Notification.screen() }
                composable(Details.route) { Details.screen() }
            }
        }
    }
}